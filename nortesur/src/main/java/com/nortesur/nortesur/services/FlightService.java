package com.nortesur.nortesur.services;

import java.util.List;
import java.util.Optional;


import com.nortesur.nortesur.entidades.Flight;


public interface FlightService {
    public Flight createFlight(Flight flight);
    public Optional<Flight> updateFlight(Long id,Flight flight);
    public void deleteFlight(long id);
    public Flight getFlight(Long id);
    public List<Flight> getAllFlights();
    public List<Flight> getFlightsByDepartureAndArrivalAndDate(String departureAirportCode, String arrivalAirportCode, String departureDate);
    public List<Flight> getFlightsByDepartureAndDate(String departureAirportCode, String departureDate);
}
