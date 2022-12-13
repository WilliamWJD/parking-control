package com.api.parkingcontrol.services.impl;

import com.api.parkingcontrol.domains.ParkingSpot;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import com.api.parkingcontrol.services.ParkingSpotService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ParkingSpotServiceImpl implements ParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotServiceImpl(final ParkingSpotRepository parkingSpotRepository){
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Transactional
    @Override
    public ParkingSpot save(ParkingSpot parkingSpot) {
        return parkingSpotRepository.save(parkingSpot);
    }
}
