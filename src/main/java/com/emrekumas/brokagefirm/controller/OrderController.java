package com.emrekumas.brokagefirm.controller;

import com.emrekumas.brokagefirm.model.dto.OrderDto;
import com.emrekumas.brokagefirm.model.request.CreateOrderRequest;
import com.emrekumas.brokagefirm.model.request.ListOrderRequest;
import com.emrekumas.brokagefirm.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping("create")
    public void createOrder(@RequestBody CreateOrderRequest request) {
        log.info("Order create request received with: {}", request);
        service.createService(request);
        log.info("Order create completed successfully");
    }

    @PostMapping("list")
    public List<OrderDto> listOrders(@RequestBody ListOrderRequest request) {
        log.info("List order request received with: {}", request);
        List<OrderDto> orders = service.listOrders(request);
        log.info("List order completed successfully: {}", orders);

        return orders;
    }

    @DeleteMapping
    public void deleteOrder(long orderId) {
        log.info("Order delete request received with: {}", orderId);
        service.deleteService(orderId);
        log.info("Order delete completed successfully");
    }
}
