package com.controller;

import com.model.ShippingCharge;
import com.service.ShippingChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipping")
public class ShippingChargeController {

    @Autowired
    private ShippingChargeService shippingChargeService;

    @GetMapping("/charges")
    public List<ShippingCharge> getAllShippingCharges() {
        return shippingChargeService.getAllShippingCharges();
    }

    @GetMapping("/charges/{id}")
    public ResponseEntity<ShippingCharge> getShippingChargeById(@PathVariable Long id) {
        ShippingCharge shippingCharge = shippingChargeService.getShippingChargeById(id);
        return ResponseEntity.ok(shippingCharge);
    }

    @PostMapping("/charges")
    public ShippingCharge createShippingCharge(@RequestBody ShippingCharge shippingCharge) {
        return shippingChargeService.createShippingCharge(shippingCharge);
    }

    @PutMapping("/charges/{id}")
    public ResponseEntity<ShippingCharge> updateShippingCharge(@PathVariable Long id, @RequestBody ShippingCharge shippingChargeDetails) {
        ShippingCharge updatedShippingCharge = shippingChargeService.updateShippingCharge(id, shippingChargeDetails);
        return ResponseEntity.ok(updatedShippingCharge);
    }

    @DeleteMapping("/charges/{id}")
    public ResponseEntity<Void> deleteShippingCharge(@PathVariable Long id) {
        shippingChargeService.deleteShippingCharge(id);
        return ResponseEntity.noContent().build();
    }
}
