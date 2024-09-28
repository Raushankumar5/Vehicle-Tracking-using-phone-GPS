package com.example.VehicleTracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.VehicleTracking.model.Driver;
import com.example.VehicleTracking.repository.DriverRepository;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverRepository driverRepository;

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        Optional<Driver> driver = driverRepository.findByUsername(username);
        if (driver.isPresent() && driver.get().getPassword().equals(password)) {
            return "Login Successful";
        } else {
            return "Invalid credentials";
        }
    }

    @PostMapping("/updateLocation/{id}")
    public String updateLocation(@PathVariable Long id, @RequestBody Map<String, Double> location) {
        Optional<Driver> driverOptional = driverRepository.findById(id);
        if (driverOptional.isPresent()) {
            Driver driver = driverOptional.get();  // Get the Driver object from Optional
            driver.setLat(location.get("lat"));
            driver.setLng(location.get("lng"));
            driverRepository.save(driver);  // Save the actual Driver object, not Optional
            return "Location updated";
        } else {
            return "Driver not found";
        }
    }
}