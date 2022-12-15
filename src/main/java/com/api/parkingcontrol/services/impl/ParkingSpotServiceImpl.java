package com.api.parkingcontrol.services.impl;

import com.api.parkingcontrol.domains.ParkingSpot;
import com.api.parkingcontrol.dto.ParkingSpotDto;
import com.api.parkingcontrol.mappers.ParkingSpotMapper;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import com.api.parkingcontrol.services.ParkingSpotService;
import com.api.parkingcontrol.services.exceptions.DataIntegrityViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ParkingSpotServiceImpl implements ParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;
    final ParkingSpotMapper mapper;

    @Transactional
    @Override
    public ParkingSpot save(final ParkingSpotDto parkingSpotDto) {
        if(existsByLicensePlateCar(parkingSpotDto.getLicensePlateCar())){
            throw new DataIntegrityViolationException("Conflict: License plate car is already in use");
        }

        if(existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())){
            throw new DataIntegrityViolationException("Conflict: parking spot number is already in use");
        }

        if(existsByApartmentAndBlock(parkingSpotDto.getApartment(), parkingSpotDto.getBlock())){
            throw new DataIntegrityViolationException("Conflict: Apartment block is in use");
        }

        return parkingSpotRepository.save(mapper.convertDtoForEntity(parkingSpotDto));
    }

    @Override
    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }

    @Override
    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    @Override
    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return parkingSpotRepository.existsAllByApartmentAndBlock(apartment, block);
    }

    @Override
    public Page<ParkingSpot> findAll(Pageable pageable) {
        return parkingSpotRepository.findAll(pageable);
    }

    @Override
    public Optional<ParkingSpot> findOneParkingSpot(UUID id) {
        return parkingSpotRepository.findById(id);
    }

    @Transactional
    @Override
    public void deleteParkingSpot(UUID id) {
        parkingSpotRepository.deleteById(id);
    }

    @Override
    public ParkingSpot updateParkingSpot(final ParkingSpot parkingSpot) {
        return parkingSpotRepository.save(parkingSpot);
    }
}
