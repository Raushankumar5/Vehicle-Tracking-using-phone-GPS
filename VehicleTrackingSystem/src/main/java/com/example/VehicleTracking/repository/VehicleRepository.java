package com.example.VehicleTracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.VehicleTracking.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
