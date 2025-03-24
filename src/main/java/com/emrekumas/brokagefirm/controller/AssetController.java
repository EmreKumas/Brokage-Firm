package com.emrekumas.brokagefirm.controller;

import com.emrekumas.brokagefirm.model.dto.AssetDto;
import com.emrekumas.brokagefirm.model.request.CreateAssetRequest;
import com.emrekumas.brokagefirm.service.AssetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("asset")
@RequiredArgsConstructor
public class AssetController {

    private final AssetService service;

    @PostMapping
    public void createAsset(@RequestBody CreateAssetRequest request) {
        log.info("Asset create request received with: {}", request);
        service.create(request);
        log.info("Asset create completed successfully");
    }

    @GetMapping("{customerId}")
    public List<AssetDto> listAssets(@PathVariable long customerId) {
        log.info("Order create request received with: {}", customerId);
        List<AssetDto> assets = service.list(customerId);
        log.info("Order create completed successfully: {}", assets);

        return assets;
    }
}
