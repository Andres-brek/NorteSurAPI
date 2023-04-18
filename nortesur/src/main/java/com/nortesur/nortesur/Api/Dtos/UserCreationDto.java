package com.nortesur.nortesur.Api.Dtos;

import java.util.Set;

import lombok.Data;

@Data
public class UserCreationDto {
    private Long id;
    private String fullname;
    private String username;
    private String password;
    private Set<Booking> bookings;
}
