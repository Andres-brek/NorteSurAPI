package com.nortesur.nortesur.Api.Dtos;

import com.nortesur.nortesur.entidades.Flight;

public class FlightMapper {

    public static FlightDto mapToFlightDto(Flight flight){
        FlightDto flightDto = new FlightDto();
        flightDto.setDepartureDate(flight.getDepartureDate());
        flightDto.setDepartureAirportCode(flight.getDepartureAirportCode());
        flightDto.setDepartureAirportName(flight.getDepartureAirportName());
        flightDto.setDepartureCity(flight.getDepartureCity());
        flightDto.setDepartureLocale(flight.getDepartureLocale());
        flightDto.setArrivalDate(flight.getArrivalDate());
        flightDto.setArrivalAirportCode(flight.getArrivalAirportCode());
        flightDto.setArrivalAirportName(flight.getArrivalAirportName());
        flightDto.setArrivalCity(flight.getArrivalCity());
        flightDto.setArrivalLocale(flight.getArrivalLocale());
        flightDto.setTicketPrice(flight.getTicketPrice());
        flightDto.setTicketCurrency(flight.getTicketCurrency());
        flightDto.setFlightNumber(flight.getFlightNumber());
        flightDto.setNumberOfSeats(flight.getNumberOfSeats());
        return flightDto;
    }

    public static Flight mapToFlight(FlightDto flightDto){
        Flight flight = new Flight();
        flight.setDepartureDate(flightDto.getDepartureDate());
        flight.setDepartureAirportCode(flightDto.getDepartureAirportCode());
        flight.setDepartureAirportName(flightDto.getDepartureAirportName());
        flight.setDepartureCity(flightDto.getDepartureCity());
        flight.setDepartureLocale(flightDto.getDepartureLocale());
        flight.setArrivalDate(flightDto.getArrivalDate());
        flight.setArrivalAirportCode(flightDto.getArrivalAirportCode());
        flight.setArrivalAirportName(flightDto.getArrivalAirportName());
        flight.setArrivalCity(flightDto.getArrivalCity());
        flight.setArrivalLocale(flightDto.getArrivalLocale());
        flight.setTicketPrice(flightDto.getTicketPrice());
        flight.setTicketCurrency(flightDto.getTicketCurrency());
        flight.setFlightNumber(flightDto.getFlightNumber());
        flight.setNumberOfSeats(flightDto.getNumberOfSeats());
        flight.setBooking(flightDto.getBooking());
        return flight;
    }

    public static FlightCreationDto mapToFlightCreation(Flight flight){
        FlightCreationDto flightCreationDto = new FlightCreationDto();
        flightCreationDto.setId(flight.getId());
        flightCreationDto.setDepartureDate(flight.getDepartureDate());
        flightCreationDto.setDepartureAirportCode(flight.getDepartureAirportCode());
        flightCreationDto.setDepartureAirportName(flight.getDepartureAirportName());
        flightCreationDto.setDepartureCity(flight.getDepartureCity());
        flightCreationDto.setDepartureLocale(flight.getDepartureLocale());
        flightCreationDto.setArrivalDate(flight.getArrivalDate());
        flightCreationDto.setArrivalAirportCode(flight.getArrivalAirportCode());
        flightCreationDto.setArrivalAirportName(flight.getArrivalAirportName());
        flightCreationDto.setArrivalCity(flight.getArrivalCity());
        flightCreationDto.setArrivalLocale(flight.getArrivalLocale());
        flightCreationDto.setTicketPrice(flight.getTicketPrice());
        flightCreationDto.setTicketCurrency(flight.getTicketCurrency());
        flightCreationDto.setFlightNumber(flight.getFlightNumber());
        flightCreationDto.setNumberOfSeats(flight.getNumberOfSeats());
        return flightCreationDto;
    }

    public static Flight mapToFlight(FlightCreationDto flightCreationDto){
        Flight flight = new Flight();
        flight.setDepartureDate(flightCreationDto.getDepartureDate());
        flight.setDepartureAirportCode(flightCreationDto.getDepartureAirportCode());
        flight.setDepartureAirportName(flightCreationDto.getDepartureAirportName());
        flight.setDepartureCity(flightCreationDto.getDepartureCity());
        flight.setDepartureLocale(flightCreationDto.getDepartureLocale());
        flight.setArrivalDate(flightCreationDto.getArrivalDate());
        flight.setArrivalAirportCode(flightCreationDto.getArrivalAirportCode());
        flight.setArrivalAirportName(flightCreationDto.getArrivalAirportName());
        flight.setArrivalCity(flightCreationDto.getArrivalCity());
        flight.setArrivalLocale(flightCreationDto.getArrivalLocale());
        flight.setTicketPrice(flightCreationDto.getTicketPrice());
        flight.setTicketCurrency(flightCreationDto.getTicketCurrency());
        flight.setFlightNumber(flightCreationDto.getFlightNumber());
        flight.setNumberOfSeats(flightCreationDto.getNumberOfSeats());
        return flight;
    }

}
