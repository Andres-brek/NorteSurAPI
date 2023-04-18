package com.nortesur.nortesur.entidades;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "flights")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private String departureDate;

    @Column(nullable = false)
    private String departureAirportCode;

    @Column(nullable = false)
    private String departureAirportName;

    @Column(nullable = false)
    private String departureCity;

    @Column(nullable = false)
    private String departureLocale;

    @Column(nullable = false)
    private String arrivalDate;

    @Column(nullable = false)
    private String arrivalAirportCode;

    @Column(nullable = false)
    private String arrivalAirportName;

    @Column(nullable = false)
    private String arrivalCity;

    @Column(nullable = false)
    private String arrivalLocale;

    @Column(nullable = false)
    private Integer ticketPrice;

    @Column(nullable = false)
    private String ticketCurrency;

    @Column(nullable = false)
    private Integer flightNumber;

    @Column(nullable = false)
    private Integer numberOfSeats;

    @OneToMany(mappedBy = "outboundFlight")
    private Set<Booking> booking;
}
