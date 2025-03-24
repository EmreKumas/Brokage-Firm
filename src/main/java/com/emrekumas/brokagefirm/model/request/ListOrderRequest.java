package com.emrekumas.brokagefirm.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListOrderRequest {
    private long customerId;
    private ZonedDateTime start;
    private ZonedDateTime end;
}
