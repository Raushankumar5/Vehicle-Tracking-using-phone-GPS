package com.example.VehicleTracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.VehicleTracking.model.Driver;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByUsername(String username);
}
