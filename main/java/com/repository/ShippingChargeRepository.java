package com.repository;

import com.model.ShippingCharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingChargeRepository extends JpaRepository<ShippingCharge, Long> {
}
