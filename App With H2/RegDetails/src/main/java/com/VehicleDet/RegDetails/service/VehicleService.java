package com.VehicleDet.RegDetails.service;

import com.VehicleDet.RegDetails.entity.Vehicle;
import com.VehicleDet.RegDetails.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        existingVehicle.setModel(updatedVehicle.getModel());
        existingVehicle.setManufacturer(updatedVehicle.getManufacturer());
        existingVehicle.setOwnerName(updatedVehicle.getOwnerName());
        existingVehicle.setVehicleYear(updatedVehicle.getVehicleYear());
        return vehicleRepository.save(existingVehicle);
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
