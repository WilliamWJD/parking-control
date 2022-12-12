package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.domains.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, UUID> {
}
