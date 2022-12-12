package com.api.parkingcontrol.services.impl;

import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import com.api.parkingcontrol.services.ParkingSpotService;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotServiceImpl implements ParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotServiceImpl(final ParkingSpotRepository parkingSpotRepository){
        this.parkingSpotRepository = parkingSpotRepository;
    }
}
