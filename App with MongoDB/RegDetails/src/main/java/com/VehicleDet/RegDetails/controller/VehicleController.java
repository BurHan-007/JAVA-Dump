package com.VehicleDet.RegDetails.controller;

import com.VehicleDet.RegDetails.entity.Vehicle;
import com.VehicleDet.RegDetails.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable String id) {
        return vehicleService.getVehicleById(id);
    }

    @GetMapping("/registration/{regNo}")
    public Vehicle getVehicleByRegistrationNumber(@PathVariable String regNo) {
        return vehicleService.getVehicleByRegistrationNumber(regNo);
    }

    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable String id) {
        vehicleService.deleteVehicle(id);
    }
}
