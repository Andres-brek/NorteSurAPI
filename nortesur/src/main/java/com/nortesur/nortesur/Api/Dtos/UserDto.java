package com.nortesur.nortesur.Api.Dtos;

import java.util.Set;

import com.nortesur.nortesur.entidades.Booking;

import lombok.Data;

@Data  
public class UserDto {
    private String fullname;
    private String username;
    private String password;
    private Set<Booking> bookings;
}
