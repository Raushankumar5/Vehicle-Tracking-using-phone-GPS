package com.example.VehicleTracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.VehicleTracking.model.Driver;
import com.example.VehicleTracking.repository.DriverRepository;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }
}
