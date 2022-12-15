package com.api.parkingcontrol.resources;

import com.api.parkingcontrol.domains.ParkingSpot;
import com.api.parkingcontrol.dto.ParkingSpotDto;
import com.api.parkingcontrol.mappers.ParkingSpotMapper;
import com.api.parkingcontrol.services.ParkingSpotService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
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
        if(parkingSpotService.existsByLicensePlateCar(parkingSpotDto.getLicensePlateCar())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License plate car is already in use");
        }

        if(parkingSpotService.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: parking spot number is already in use");
        }

        if(parkingSpotService.existsByApartmentAndBlock(parkingSpotDto.getApartment(), parkingSpotDto.getBlock())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Apartment block is in use");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotDto));
    }

    @GetMapping
    public ResponseEntity<Page<ParkingSpot>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value= "id")UUID id){
        Optional<ParkingSpot> parkingSpot = parkingSpotService.findOneParkingSpot(id);
        if(!parkingSpot.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking spot not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpot.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") UUID id){
        Optional<ParkingSpot> parkingSpot = parkingSpotService.findOneParkingSpot(id);
        if(!parkingSpot.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking spot not found");
        }
        parkingSpotService.deleteParkingSpot(id);
        return ResponseEntity.status(HttpStatus.OK).body("Parking spot deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") UUID id, @RequestBody final ParkingSpotDto parkingSpotDto){
        Optional<ParkingSpot> parkingSpot = parkingSpotService.findOneParkingSpot(id);
        if(!parkingSpot.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking spot not found");
        }
        ParkingSpot parkingSpotDomain = parkingSpotMapper.convertDtoForEntity(parkingSpotDto);
        parkingSpotDomain.setId(parkingSpot.get().getId());
        parkingSpotDomain.setRegistrationDate(parkingSpot.get().getRegistrationDate());

        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.updateParkingSpot(parkingSpotDomain));
    }
}
