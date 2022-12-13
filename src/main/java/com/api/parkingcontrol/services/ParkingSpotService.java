package com.api.parkingcontrol.services;

import com.api.parkingcontrol.domains.ParkingSpot;
import com.api.parkingcontrol.dto.ParkingSpotDto;

public interface ParkingSpotService {
    ParkingSpot save(final ParkingSpot parkingSpot);
}
