package com.api.parkingcontrol.mappers;

import com.api.parkingcontrol.domains.ParkingSpot;
import com.api.parkingcontrol.dto.ParkingSpotDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class ParkingSpotMapper {

    public ParkingSpot convertDtoForEntity(final ParkingSpotDto parkingSpotDto){
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setParkingSpotNumber(parkingSpotDto.getParkingSpotNumber());
        parkingSpot.setLicensePlateCar(parkingSpotDto.getLicensePlateCar());
        parkingSpot.setBrandCar(parkingSpotDto.getBrandCar());
        parkingSpot.setModelCar(parkingSpotDto.getModelCar());
        parkingSpot.setColorCar(parkingSpotDto.getColorCar());
        parkingSpot.setResponsibleName(parkingSpotDto.getResponsibleName());
        parkingSpot.setApartment(parkingSpotDto.getApartment());
        parkingSpot.setBlock(parkingSpotDto.getBlock());
        parkingSpot.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

        return parkingSpot;
    }
}
