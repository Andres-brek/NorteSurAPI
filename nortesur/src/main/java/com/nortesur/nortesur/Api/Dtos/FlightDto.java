package com.nortesur.nortesur.Api.Dtos;

import java.util.Set;

import com.nortesur.nortesur.entidades.Booking;

import lombok.Data;

@Data
public class FlightDto {
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
    private Set<Booking> booking;

}
