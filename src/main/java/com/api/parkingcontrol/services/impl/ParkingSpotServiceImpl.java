package com.api.parkingcontrol.services.impl;

import com.api.parkingcontrol.domains.ParkingSpot;
import com.api.parkingcontrol.dto.ParkingSpotDto;
import com.api.parkingcontrol.mappers.ParkingSpotMapper;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import com.api.parkingcontrol.services.ParkingSpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ParkingSpotServiceImpl implements ParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;
    final ParkingSpotMapper mapper;

    @Transactional
    @Override
    public ParkingSpot save(final ParkingSpotDto parkingSpotDto) {
        System.out.println(">>>>> AQUI: "+mapper.convertDtoForEntity(parkingSpotDto));
        return parkingSpotRepository.save(mapper.convertDtoForEntity(parkingSpotDto));
    }
}
