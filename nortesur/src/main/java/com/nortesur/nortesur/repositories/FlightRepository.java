package com.nortesur.nortesur.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nortesur.nortesur.entidades.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{
    List<Flight> findByDepartureAirportCodeAndArrivalAirportCodeAndDepartureDate(String departureAirportCode, String arrivalAirportCode, String departureDate);
    List<Flight> findByDepartureAirportCodeAndDepartureDate(String departureAirportCode, String departureDate);
}
