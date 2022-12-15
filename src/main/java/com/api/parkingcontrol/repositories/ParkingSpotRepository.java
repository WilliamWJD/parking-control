package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.domains.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, UUID> {
   boolean existsByLicensePlateCar(String licensePlateCar);
   boolean existsByParkingSpotNumber(String parkingSpotNumber);
   boolean existsAllByApartmentAndBlock(String apartment, String block);
}
