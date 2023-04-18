package com.nortesur.nortesur.Api.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nortesur.nortesur.Api.Dtos.BookingDto;
import com.nortesur.nortesur.Api.Dtos.BookingMapper;
import com.nortesur.nortesur.entidades.Booking;
import com.nortesur.nortesur.entidades.BookingStatus;
import com.nortesur.nortesur.services.BookingService;
import com.nortesur.nortesur.services.UserService;


@RestController
public class BookingController {
    private  BookingService bookingService;
    private  UserService userService;

    @Autowired
    public BookingController(BookingService bookingService, UserService userService) {
        this.bookingService = bookingService;
        this.userService = userService;
    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity<BookingDto> findById(@PathVariable("id") Long id){
        BookingDto booking = bookingService.getBooking(id).map(b->BookingMapper.mapToBookingDto(b)).orElseThrow();      
        return ResponseEntity.status(HttpStatus.FOUND).body(booking);
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<BookingDto>> findByManyParameters(@RequestParam(required = false) BookingStatus status, @RequestParam(required = false) String customerName){
        if(status == null && customerName == null){
            List<BookingDto> bookingDtos = bookingService.getAllBookings().stream().map(b->BookingMapper.mapToBookingDto(b)).collect(Collectors.toList());
            if(bookingDtos.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
            } 
            return ResponseEntity.status(HttpStatus.FOUND).body(bookingDtos);
        }
        else if(status != null && customerName == null){
            List<BookingDto> bookingDtos = bookingService.getBookingsByStatus(status).stream().map(b->BookingMapper.mapToBookingDto(b)).collect(Collectors.toList());
            if(bookingDtos.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
            } 
            return ResponseEntity.status(HttpStatus.FOUND).body(bookingDtos);
        }
        else if(status == null && customerName != null){
            Long id = userService.getAllUsers().stream().filter(u->u.getFullname().equals(customerName)).collect(Collectors.toList()).get(0).getId();
            List<BookingDto> bookingDtos = bookingService.getUserBookings(id).stream().map(b->BookingMapper.mapToBookingDto(b)).collect(Collectors.toList());
            if(bookingDtos.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
            } 
            return ResponseEntity.status(HttpStatus.FOUND).body(bookingDtos);
        }
        else{
            Long id = userService.getAllUsers().stream().filter(u->u.getFullname().equals(customerName)).collect(Collectors.toList()).get(0).getId();
            List<BookingDto> bookingDtos = bookingService.getBookingsByNameAndStatus(status,id).stream().map(b->BookingMapper.mapToBookingDto(b)).collect(Collectors.toList());
            if(bookingDtos.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
            } 
            return ResponseEntity.status(HttpStatus.FOUND).body(bookingDtos);
        }
    }

    @PostMapping("/bookings/flight/{flightId}/user/{userId}")
    public ResponseEntity<BookingDto> createBooking(@PathVariable Long flightId, @PathVariable Long userId){
        if(flightId != null && userId != null){
            Booking BookingNew=bookingService.createBookingByflightAndUser(flightId, userId);
            return ResponseEntity.status(HttpStatus.FOUND).body(BookingMapper.mapToBookingDto(BookingNew));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/bookings/{id}")
    public ResponseEntity<BookingDto> deleteBooking(@PathVariable("id") Long id){
        bookingService.deleteBooking(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/bookings/flight/{id}")
    public ResponseEntity<List<BookingDto>> getBookingsByFlight(@PathVariable("id") Long id){
        List<BookingDto> bookingDtos = bookingService.getBookingsByFlight(id).stream().map(b->BookingMapper.mapToBookingDto(b)).collect(Collectors.toList());
        if(bookingDtos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
        } 
        return ResponseEntity.status(HttpStatus.FOUND).body(bookingDtos);
    }

    @PostMapping("/bookings")
    public ResponseEntity<BookingDto> CreateBooking(@RequestBody BookingDto bookingDto, @RequestParam Long userId, @RequestParam Long flightId){
        Booking booking = BookingMapper.mapToBooking(bookingDto);
        booking = bookingService.createBooking(booking, userId, flightId);
        return ResponseEntity.status(HttpStatus.OK).body(BookingMapper.mapToBookingDto(booking));
    }

}
