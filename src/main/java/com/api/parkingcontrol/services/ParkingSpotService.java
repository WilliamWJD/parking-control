package com.api.parkingcontrol.services;

import com.api.parkingcontrol.domains.ParkingSpot;
import com.api.parkingcontrol.dto.ParkingSpotDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParkingSpotService {
    ParkingSpot save(final ParkingSpotDto parkingSpot);
    boolean existsByLicensePlateCar(final String licensePlateCar);
    boolean existsByParkingSpotNumber(final String parkingSpotNumber);
    boolean existsByApartmentAndBlock(final String apartment, String block);
    List<ParkingSpot> findAll();
    Optional<ParkingSpot> findOneParkingSpot(final UUID id);
    void deleteParkingSpot(final UUID id);

}
