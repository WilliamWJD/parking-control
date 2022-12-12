package com.api.parkingcontrol.resources;

import com.api.parkingcontrol.services.ParkingSpotService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotResource {

    final ParkingSpotService parkingSpotService;

    public ParkingSpotResource(final ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }
}
