package com.VehicleDet.RegDetails.service;

import com.VehicleDet.RegDetails.entity.Vehicle;
import com.VehicleDet.RegDetails.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(String id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public Vehicle getVehicleByRegistrationNumber(String registrationNumber) {
        return vehicleRepository.findByRegistrationNumber(registrationNumber);
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(String id) {
        vehicleRepository.deleteById(id);
    }
}
