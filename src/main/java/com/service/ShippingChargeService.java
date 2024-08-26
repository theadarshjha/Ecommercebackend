package com.service;

import com.model.ShippingCharge;
import com.repository.ShippingChargeRepository;
import com.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingChargeService {

    @Autowired
    private ShippingChargeRepository shippingChargeRepository;

    public List<ShippingCharge> getAllShippingCharges() {
        return shippingChargeRepository.findAll();
    }

    public ShippingCharge getShippingChargeById(Long id) {
        return shippingChargeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipping charge not found with id: " + id));
    }

    public ShippingCharge createShippingCharge(ShippingCharge shippingCharge) {
        return shippingChargeRepository.save(shippingCharge);
    }

    public ShippingCharge updateShippingCharge(Long id, ShippingCharge shippingChargeDetails) {
        ShippingCharge shippingCharge = getShippingChargeById(id);
        shippingCharge.setDestination(shippingChargeDetails.getDestination());
        shippingCharge.setCharge(shippingChargeDetails.getCharge());
        return shippingChargeRepository.save(shippingCharge);
    }

    public void deleteShippingCharge(Long id) {
        ShippingCharge shippingCharge = getShippingChargeById(id);
        shippingChargeRepository.delete(shippingCharge);
    }
}
