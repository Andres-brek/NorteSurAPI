package com.nortesur.nortesur.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private BookingStatus status; 

    @ManyToOne
    @JoinColumn(name = "FlightId", referencedColumnName = "id")
    private Flight outboundFlight;

    @Column(nullable = false)
    private String paymentToken;

    @Column(nullable = false)
    private Boolean checkedIn;

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "id")
    private User customer;

    @Column(nullable = false)
    private String createdAt;

    @Column(nullable = false)
    private String bookingReference;
    
}
