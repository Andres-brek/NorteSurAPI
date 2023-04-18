package com.nortesur.nortesur.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nortesur.nortesur.entidades.Booking;
import com.nortesur.nortesur.entidades.User;
import com.nortesur.nortesur.entidades.BookingStatus;
import com.nortesur.nortesur.entidades.Flight;
import com.nortesur.nortesur.repositories.BookingRepository;

@Service
public class BookingServiceImp implements BookingService {

    private BookingRepository bookingRepository;
    private UserService userService;
    private FlightService FlightService;

    public BookingServiceImp(BookingRepository bookingRepository, UserService userService, FlightService FlightService) {
        this.bookingRepository = bookingRepository;
        this.userService = userService;
        this.FlightService = FlightService;
    }

    @Override
    public Booking createBooking(Booking booking, Long userId, Long flightId) {
        User user = userService.getUser(userId);
        Flight flight = FlightService.getFlight(flightId);
        booking.setCustomer(user);
        booking.setOutboundFlight(flight);
        return bookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> updateBooking(Long id, Booking booking) {
        if(bookingRepository.findById(id).isPresent()){
            return bookingRepository.findById(id).map(b -> {
                b.setId(b.getId());
                b.setStatus(booking.getStatus());
                b.setOutboundFlight(booking.getOutboundFlight());
                b.setPaymentToken(booking.getPaymentToken());
                b.setCheckedIn(booking.getCheckedIn());
                b.setCustomer(booking.getCustomer());
                b.setCreatedAt(b.getCreatedAt());
                b.setBookingReference(b.getBookingReference());
                return bookingRepository.save(b);
            });
        }
        else{
            return null;
        }
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public Optional<Booking> getBooking(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public List<Booking> getUserBookings(Long id) {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream().filter(b -> b.getCustomer().getId() == id).toList();

    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getBookingsByNameAndStatus(BookingStatus status, Long id) {
        return bookingRepository.findByStatusAndCustomer(status, id);
    }

    @Override
    public List<Booking> getBookingsByStatus(BookingStatus status) {
        return bookingRepository.findBystatus(status);
    }

    @Override
    public Booking createBookingByflightAndUser(Long flightId, Long userId) {
        if(!bookingRepository.findByoutboundFlight(flightId).isEmpty()){
            Booking copyflight=bookingRepository.findByoutboundFlight(flightId).get(0);
            User copyuser= userService.getUser(userId);
            copyflight.setCustomer(copyuser);
            return bookingRepository.save(copyflight);
        }
        else{
            return null;
        }
    }

    @Override
    public List<Booking> getBookingsByFlight(Long id) {
        return bookingRepository.findByoutboundFlight(id);
    }
    
}
