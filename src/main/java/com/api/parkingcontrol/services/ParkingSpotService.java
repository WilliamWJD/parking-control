package com.api.parkingcontrol.services;

import com.api.parkingcontrol.domains.ParkingSpot;
import com.api.parkingcontrol.dto.ParkingSpotDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ParkingSpotService {
    ParkingSpot save(final ParkingSpotDto parkingSpot);
    Page<ParkingSpot> findAll(Pageable pageable);
    ParkingSpot findOneParkingSpot(final UUID id);
    void deleteParkingSpot(final UUID id);

    ParkingSpot updateParkingSpot(final UUID id, final ParkingSpotDto parkingSpotDto);

}
