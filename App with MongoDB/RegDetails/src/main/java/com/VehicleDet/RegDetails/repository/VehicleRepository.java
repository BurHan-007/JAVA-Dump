package com.VehicleDet.RegDetails.repository;

import com.VehicleDet.RegDetails.entity.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {
    Vehicle findByRegistrationNumber(String registrationNumber);
}