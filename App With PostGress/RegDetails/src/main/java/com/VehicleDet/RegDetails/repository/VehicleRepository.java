package com.VehicleDet.RegDetails.repository;

import com.VehicleDet.RegDetails.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByRegistrationNumberStartingWith(String prefix);
}
