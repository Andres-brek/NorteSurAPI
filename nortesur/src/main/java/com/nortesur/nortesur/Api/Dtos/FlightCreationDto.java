package com.nortesur.nortesur.Api.Dtos;

import com.nortesur.nortesur.entidades.Booking;

import lombok.Data;

@Data
public class FlightCreationDto {
    private Long id;
    private String departureDate;
    private String departureAirportCode;
    private String departureAirportName;
    private String departureCity;
    private String departureLocale;
    private String ArrivalDate;
    private String arrivalAirportCode;
    private String arrivalAirportName;
    private String arrivalCity;
    private String arrivalLocale;
    private Integer ticketPrice;
    private String ticketCurrency;
    private Integer FlightNumber;
    private Integer numberOfSeats;
    private Booking booking;
}
