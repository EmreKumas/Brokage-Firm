package com.emrekumas.brokagefirm.model.request;

import com.emrekumas.brokagefirm.model.enums.OrderSide;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {
    private long customerId;
    private String assetName;
    private OrderSide orderSide;
    private int size;
    private double price;
}
