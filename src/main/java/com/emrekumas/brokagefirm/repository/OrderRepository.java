package com.emrekumas.brokagefirm.repository;

import com.emrekumas.brokagefirm.model.entity.OrderDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderDao, Long> {
    List<OrderDao> findByCustomerIdAndCreateDateBetween(long customerId, ZonedDateTime start, ZonedDateTime end);
}
