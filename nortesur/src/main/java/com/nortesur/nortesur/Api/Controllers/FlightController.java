package com.nortesur.nortesur.Api.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nortesur.nortesur.Api.Dtos.FlightDto;
import com.nortesur.nortesur.Api.Dtos.FlightMapper;
import com.nortesur.nortesur.entidades.Flight;
import com.nortesur.nortesur.services.FlightService;

@RestController
public class FlightController {
    
    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/flights")
    public ResponseEntity<List<FlightDto>> getFlights(@RequestParam String departureAirportCode, @RequestParam String arrivalAirportCode, @RequestParam String departureDate) {
        List<FlightDto> flights = flightService.getFlightsByDepartureAndArrivalAndDate(departureAirportCode, arrivalAirportCode, departureDate).stream().map(f -> FlightMapper.mapToFlightDto(f)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(flights);
    }

    @PostMapping("/flights")
    public ResponseEntity<FlightDto> createFlight(@RequestBody FlightDto flightDto) {
        Flight flightCreated = flightService.createFlight(FlightMapper.mapToFlight(flightDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(FlightMapper.mapToFlightDto(flightCreated));
    }

    @PutMapping("/flights/{id}")
    public ResponseEntity<FlightDto> updateFlight(@RequestParam Long id, @RequestBody FlightDto flightDto) {
        Flight flightUpdated = flightService.updateFlight(id, FlightMapper.mapToFlight(flightDto)).get();
        return ResponseEntity.status(HttpStatus.OK).body(FlightMapper.mapToFlightDto(flightUpdated));
    }

    @DeleteMapping("/flights/{id}")
    public ResponseEntity<Void> deleteFlight(@RequestParam Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/flights/{AirportCode}")
    public ResponseEntity<List<FlightDto>> getFlightsAirport(@PathVariable String AirportCode,@RequestParam String departureDate ) {
        List<FlightDto> flights = flightService.getFlightsByDepartureAndDate(AirportCode, departureDate).stream().map(f -> FlightMapper.mapToFlightDto(f)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.FOUND).body(flights);
    }
}
