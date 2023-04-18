package com.nortesur.nortesur.services;

import java.util.List;
import java.util.Optional;



import com.nortesur.nortesur.entidades.Booking;
import com.nortesur.nortesur.entidades.BookingStatus;


public interface BookingService {
    public Booking createBooking(Booking booking,Long userId,Long flightId);
    public Booking createBookingByflightAndUser(Long flightId, Long userId);
    public Optional<Booking> updateBooking(Long id,Booking booking);
    public void deleteBooking(Long id);
    public Optional<Booking> getBooking(Long id);
    public List<Booking> getBookingsByFlight(Long id);
    public List<Booking> getUserBookings(Long id);
    public List<Booking> getAllBookings();
    public List<Booking> getBookingsByNameAndStatus(BookingStatus status, Long id);
    public List<Booking> getBookingsByStatus(BookingStatus status);
}
