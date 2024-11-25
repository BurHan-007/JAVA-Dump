package com.VehicleDet.RegDetails.controller;

import com.VehicleDet.RegDetails.entity.Vehicle;
import com.VehicleDet.RegDetails.repository.VehicleRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VehicleControllerTest {

	private VehicleRepository vehicleRepository;

	@BeforeEach
	void setUp() {
		// Create a mock repository
		vehicleRepository = Mockito.mock(VehicleRepository.class);
	}

	@Test
	void testSaveVehicle() {
		// Create a test vehicle
		Vehicle vehicle = new Vehicle();
		vehicle.setRegistrationNumber("TEST_" + UUID.randomUUID().toString().substring(0, 5));
		vehicle.setManufacturer("Toyota");
		vehicle.setModel("Corolla");
		vehicle.setOwnerName("John Doe");
		vehicle.setYear(2023);

		// Mock the save method
		when(vehicleRepository.save(vehicle)).thenReturn(vehicle);

		// Call the save method
		Vehicle savedVehicle = vehicleRepository.save(vehicle);

		// Verify the behavior and assert the result
		verify(vehicleRepository, times(1)).save(vehicle);
		assertNotNull(savedVehicle);
		assertEquals("Toyota", savedVehicle.getManufacturer());
	}

	@Test
	void testFindAllVehicles() {
		// Mock the findAll method
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setRegistrationNumber("TEST_1");
		vehicle1.setManufacturer("Honda");

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setRegistrationNumber("TEST_2");
		vehicle2.setManufacturer("Nissan");

		when(vehicleRepository.findAll()).thenReturn(Arrays.asList(vehicle1, vehicle2));

		// Call the findAll method
		Iterable<Vehicle> vehicles = vehicleRepository.findAll();

		verify(vehicleRepository, times(1)).findAll();
		assertNotNull(vehicles);
		assertEquals(2, ((List<Vehicle>) vehicles).size());
	}

	@Test
	void testFindVehicleById() {
		// Mock the findById method
		Vehicle vehicle = new Vehicle();
		vehicle.setId(1L);
		vehicle.setRegistrationNumber("TEST_1");
		vehicle.setManufacturer("Ford");

		when(vehicleRepository.findById(1L)).thenReturn(Optional.of(vehicle));

		// Call the findById method
		Optional<Vehicle> retrievedVehicle = vehicleRepository.findById(1L);

		verify(vehicleRepository, times(1)).findById(1L);
		assertTrue(retrievedVehicle.isPresent());
		assertEquals("Ford", retrievedVehicle.get().getManufacturer());
	}

	@Test
	void testDeleteVehicle() {
		// Mock a vehicle to delete
		Vehicle vehicle = new Vehicle();
		vehicle.setId(1L);

		doNothing().when(vehicleRepository).deleteById(1L);

		// Call the deleteById method
		vehicleRepository.deleteById(1L);

		verify(vehicleRepository, times(1)).deleteById(1L);
	}
}
