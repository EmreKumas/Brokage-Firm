package com.emrekumas.brokagefirm.service;

import com.emrekumas.brokagefirm.exception.AlreadyExistsException;
import com.emrekumas.brokagefirm.model.Mapper;
import com.emrekumas.brokagefirm.model.dto.AssetDto;
import com.emrekumas.brokagefirm.model.entity.AssetDao;
import com.emrekumas.brokagefirm.model.request.CreateAssetRequest;
import com.emrekumas.brokagefirm.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssetService {

    private final AssetRepository assetRepository;

    public void create(CreateAssetRequest request) {
        Optional<AssetDao> assetOpt = assetRepository.findByCustomerIdAndAssetName(request.getCustomerId(), request.getAssetName());

        if (assetOpt.isPresent()) {
            throw new AlreadyExistsException("Asset already exists");
        }

        AssetDao assetDao = Mapper.INSTANCE.toAssetDao(request);
        assetDao.setUsableSize(request.getSize());
        assetRepository.save(assetDao);
    }

    public List<AssetDto> list(long customerId) {
        List<AssetDao> assets = assetRepository.findByCustomerId(customerId);

        return assets.stream()
                .map(Mapper.INSTANCE::toAssetDto)
                .toList();
    }
}
