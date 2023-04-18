package com.nortesur.nortesur.Api.Dtos;
import com.nortesur.nortesur.entidades.Booking;

public class BookingMapper {
    public static BookingDto mapToBookingDto(Booking booking){
        BookingDto bookingDto = new BookingDto();
        bookingDto.setStatus(booking.getStatus());
        bookingDto.setOutboundFlight(booking.getOutboundFlight());
        bookingDto.setPaymentToken(booking.getPaymentToken());
        bookingDto.setCustomer(booking.getCustomer());
        bookingDto.setCreatedAt(booking.getCreatedAt());
        bookingDto.setBookingReference(booking.getBookingReference());
        bookingDto.setCheckedIn(booking.getCheckedIn());
        return bookingDto;
    }

    public static Booking mapToBooking(BookingDto bookingDto){
        Booking booking = new Booking();
        booking.setStatus(bookingDto.getStatus());
        booking.setOutboundFlight(bookingDto.getOutboundFlight());
        booking.setPaymentToken(bookingDto.getPaymentToken());
        booking.setCustomer(bookingDto.getCustomer());
        booking.setCreatedAt(bookingDto.getCreatedAt());
        booking.setBookingReference(bookingDto.getBookingReference());
        booking.setCheckedIn(bookingDto.getCheckedIn());
        return booking;
    }

    public static Booking mapToBooking(BookingCreationDto bookingCreationDto){
        Booking booking = new Booking();
        booking.setId(bookingCreationDto.getId());
        booking.setStatus(bookingCreationDto.getStatus());
        booking.setOutboundFlight(bookingCreationDto.getOutboundFlight());
        booking.setPaymentToken(bookingCreationDto.getPaymentToken());
        booking.setCustomer(bookingCreationDto.getCustomer());
        booking.setCreatedAt(bookingCreationDto.getCreatedAt());
        booking.setBookingReference(bookingCreationDto.getBookingReference());
        booking.setCheckedIn(bookingCreationDto.getCheckedIn());
        return booking;
    }

    public static BookingCreationDto mapToBookingCreationDto(Booking booking){
        BookingCreationDto bookingCreationDto = new BookingCreationDto();
        bookingCreationDto.setId(booking.getId());
        bookingCreationDto.setStatus(booking.getStatus());
        bookingCreationDto.setOutboundFlight(booking.getOutboundFlight());
        bookingCreationDto.setPaymentToken(booking.getPaymentToken());
        bookingCreationDto.setCustomer(booking.getCustomer());
        bookingCreationDto.setCreatedAt(booking.getCreatedAt());
        bookingCreationDto.setBookingReference(booking.getBookingReference());
        bookingCreationDto.setCheckedIn(booking.getCheckedIn());
        return bookingCreationDto;
    }
    
}
