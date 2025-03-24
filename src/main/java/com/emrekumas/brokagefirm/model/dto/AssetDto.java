package com.emrekumas.brokagefirm.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssetDto {
    private Long customerId;
    private String assetName;
    private int size;
    private int usableSize;
}
