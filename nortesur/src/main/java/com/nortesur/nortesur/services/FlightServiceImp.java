package com.nortesur.nortesur.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nortesur.nortesur.entidades.Flight;
import com.nortesur.nortesur.repositories.FlightRepository;

@Service
public class FlightServiceImp implements FlightService{

    private final FlightRepository flightRepository;

    public FlightServiceImp(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Optional<Flight> updateFlight(Long id, Flight flight) {
        if(flightRepository.findById(id).isPresent()){
            return flightRepository.findById(id).map(f -> {
                f.setId(f.getId());
                f.setDepartureDate(flight.getDepartureDate());
                f.setDepartureAirportCode(flight.getDepartureAirportCode());
                f.setDepartureAirportName(flight.getDepartureAirportName());
                f.setDepartureCity(flight.getDepartureCity());
                f.setDepartureLocale(flight.getDepartureLocale());
                f.setArrivalDate(flight.getArrivalDate());
                f.setArrivalAirportCode(flight.getArrivalAirportCode());
                f.setArrivalAirportName(flight.getArrivalAirportName());
                f.setArrivalCity(flight.getArrivalCity());
                f.setArrivalLocale(flight.getArrivalLocale());
                f.setTicketPrice(flight.getTicketPrice());
                f.setTicketCurrency(flight.getTicketCurrency());
                f.setFlightNumber(flight.getFlightNumber());
                f.setNumberOfSeats(flight.getNumberOfSeats());
                f.setBooking(flight.getBooking());
                return flightRepository.save(f);
            });
        }
        else{
            return null;
        }
    }

    @Override
    public void deleteFlight(long id) {
        flightRepository.deleteById(id);
    }

    @Override
    public Flight getFlight(Long id) {
        return flightRepository.findById(id).get();
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public List<Flight> getFlightsByDepartureAndArrivalAndDate(String departureAirportCode, String arrivalAirportCode, String departureDate) {
        return flightRepository.findByDepartureAirportCodeAndArrivalAirportCodeAndDepartureDate(departureAirportCode, arrivalAirportCode, departureDate);
    }

    @Override
    public List<Flight> getFlightsByDepartureAndDate(String departureAirportCode, String departureDate) {
        return flightRepository.findByDepartureAirportCodeAndDepartureDate(departureAirportCode, departureDate);
    }
    
}
