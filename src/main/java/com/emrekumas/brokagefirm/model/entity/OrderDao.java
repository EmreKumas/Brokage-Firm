package com.emrekumas.brokagefirm.model.entity;

import com.emrekumas.brokagefirm.model.enums.OrderSide;
import com.emrekumas.brokagefirm.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Orders")
public class OrderDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private String assetName;
    @Enumerated(EnumType.STRING)
    private OrderSide orderSide;
    private int size;
    private double price;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private ZonedDateTime createDate;
}
