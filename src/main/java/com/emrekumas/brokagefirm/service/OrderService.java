package com.emrekumas.brokagefirm.service;

import com.emrekumas.brokagefirm.exception.BalanceInsufficientException;
import com.emrekumas.brokagefirm.exception.NotFoundException;
import com.emrekumas.brokagefirm.exception.OrderStatusProgressedException;
import com.emrekumas.brokagefirm.model.Mapper;
import com.emrekumas.brokagefirm.model.dto.OrderDto;
import com.emrekumas.brokagefirm.model.entity.AssetDao;
import com.emrekumas.brokagefirm.model.entity.OrderDao;
import com.emrekumas.brokagefirm.model.enums.OrderSide;
import com.emrekumas.brokagefirm.model.enums.OrderStatus;
import com.emrekumas.brokagefirm.model.request.CreateOrderRequest;
import com.emrekumas.brokagefirm.model.request.ListOrderRequest;
import com.emrekumas.brokagefirm.repository.AssetRepository;
import com.emrekumas.brokagefirm.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final AssetRepository assetRepository;
    private final OrderRepository orderRepository;

    public void createService(CreateOrderRequest request) {
        if (request.getOrderSide() == OrderSide.SELL) {
            deductFromAsset(request);
        }

        OrderDao order = Mapper.INSTANCE.toOrderDao(request);

        order.setCreateDate(ZonedDateTime.now());
        order.setStatus(OrderStatus.PENDING);

        orderRepository.save(order);
    }

    private void deductFromAsset(CreateOrderRequest request) {
        AssetDao asset = assetRepository.findByCustomerIdAndAssetName(request.getCustomerId(), request.getAssetName())
                .orElseThrow(() -> new NotFoundException("Cannot find the customer asset"));

        if (asset.getUsableSize() < request.getSize()) {
            throw new BalanceInsufficientException("Customer's asset size is not enough to sell");
        }

        asset.setUsableSize(asset.getUsableSize() - request.getSize());
        assetRepository.save(asset);

        log.info("Asset updated successfully");
    }

    public List<OrderDto> listOrders(ListOrderRequest request) {
        List<OrderDao> orders = orderRepository.findByCustomerIdAndCreateDateBetween(request.getCustomerId(), request.getStart(), request.getEnd());

        return orders.stream()
                .map(Mapper.INSTANCE::toOrderDto)
                .toList();
    }

    public void deleteService(long orderId) {
        OrderDao order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Cannot find order"));

        if (order.getStatus() != OrderStatus.PENDING) {
            throw new OrderStatusProgressedException("Order status is not PENDING");
        }

        if (order.getOrderSide() == OrderSide.SELL) {
            AssetDao asset = assetRepository.findByCustomerIdAndAssetName(order.getCustomerId(), order.getAssetName())
                    .orElseThrow(() -> new NotFoundException("Cannot find the customer asset"));

            asset.setUsableSize(asset.getUsableSize() + order.getSize());
            assetRepository.save(asset);
        }

        order.setStatus(OrderStatus.CANCELED);
        orderRepository.save(order);
    }
}
