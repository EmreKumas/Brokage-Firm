package com.emrekumas.brokagefirm.repository;

import com.emrekumas.brokagefirm.model.entity.AssetDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssetRepository extends JpaRepository<AssetDao, Long> {
    List<AssetDao> findByCustomerId(long customerId);
    Optional<AssetDao> findByCustomerIdAndAssetName(long customerId, String assetName);
}
