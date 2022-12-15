package com.api.parkingcontrol.resources;

import com.api.parkingcontrol.domains.ParkingSpot;
import com.api.parkingcontrol.dto.ParkingSpotDto;
import com.api.parkingcontrol.mappers.ParkingSpotMapper;
import com.api.parkingcontrol.services.ParkingSpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/parking-spot")
@RequiredArgsConstructor
public class ParkingSpotResource {

    final ParkingSpotService parkingSpotService;
    final ParkingSpotMapper parkingSpotMapper;

    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid final ParkingSpotDto parkingSpotDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotDto));
    }

    @GetMapping
    public ResponseEntity<Page<ParkingSpot>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value= "id")UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findOneParkingSpot(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") UUID id){
        parkingSpotService.deleteParkingSpot(id);
        return ResponseEntity.status(HttpStatus.OK).body("Parking spot deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") UUID id, @RequestBody final ParkingSpotDto parkingSpotDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.updateParkingSpot(id, parkingSpotDto));
    }
}
