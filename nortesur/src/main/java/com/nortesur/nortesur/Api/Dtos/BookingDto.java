package com.nortesur.nortesur.Api.Dtos;

import com.nortesur.nortesur.entidades.BookingStatus;
import com.nortesur.nortesur.entidades.Flight;
import com.nortesur.nortesur.entidades.User;

import lombok.Data;

@Data
public class BookingDto {
    private BookingStatus status;
    private Flight outboundFlight;
    private String paymentToken;
    private Boolean checkedIn;
    private User customer;
    private String createdAt;
    private String bookingReference;
}
