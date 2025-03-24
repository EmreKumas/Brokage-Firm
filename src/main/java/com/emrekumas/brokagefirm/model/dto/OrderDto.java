package com.emrekumas.brokagefirm.model.dto;

import com.emrekumas.brokagefirm.model.enums.OrderSide;
import com.emrekumas.brokagefirm.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private Long customerId;
    private String assetName;
    private OrderSide orderSide;
    private int size;
    private double price;
    private OrderStatus status;
    private ZonedDateTime createDate;
}
