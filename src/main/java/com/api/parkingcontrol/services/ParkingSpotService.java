package com.api.parkingcontrol.services;

import com.api.parkingcontrol.domains.ParkingSpot;
import com.api.parkingcontrol.dto.ParkingSpotDto;

public interface ParkingSpotService {
    ParkingSpot save(final ParkingSpotDto parkingSpot);
    boolean existsByLicensePlateCar(final String licensePlateCar);
    boolean existsByParkingSpotNumber(final String parkingSpotNumber);
    boolean existsByApartmentAndBlock(final String apartment, String block);
}
