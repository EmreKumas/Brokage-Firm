package com.emrekumas.brokagefirm.model;

import com.emrekumas.brokagefirm.model.dto.AssetDto;
import com.emrekumas.brokagefirm.model.dto.OrderDto;
import com.emrekumas.brokagefirm.model.entity.AssetDao;
import com.emrekumas.brokagefirm.model.entity.OrderDao;
import com.emrekumas.brokagefirm.model.request.CreateAssetRequest;
import com.emrekumas.brokagefirm.model.request.CreateOrderRequest;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper
public interface Mapper {

    Mapper INSTANCE = Mappers.getMapper(Mapper.class);

    OrderDao toOrderDao(CreateOrderRequest request);
    OrderDto toOrderDto(OrderDao order);

    AssetDao toAssetDao(CreateAssetRequest request);
    AssetDto toAssetDto(AssetDao asset);
}
