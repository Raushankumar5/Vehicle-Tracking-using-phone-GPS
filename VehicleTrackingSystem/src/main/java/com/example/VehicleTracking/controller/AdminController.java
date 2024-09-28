package com.example.VehicleTracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.VehicleTracking.model.Driver;
import com.example.VehicleTracking.repository.DriverRepository;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DriverRepository driverRepository;

    @PostMapping("/addDriver")
    public Driver addDriver(@RequestBody Driver driver) {
        return driverRepository.save(driver);
    }

    @GetMapping("/allDrivers")
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @DeleteMapping("/deleteDriver/{id}")
    public void deleteDriver(@PathVariable Long id) {
        driverRepository.deleteById(id);
    }
}
