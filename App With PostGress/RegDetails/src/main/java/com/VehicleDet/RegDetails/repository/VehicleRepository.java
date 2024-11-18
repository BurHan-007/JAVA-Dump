package com.VehicleDet.RegDetails.repository;

import com.VehicleDet.RegDetails.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
//        Properties Here.....
}
