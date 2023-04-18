package com.nortesur.nortesur.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nortesur.nortesur.entidades.Booking;
import com.nortesur.nortesur.entidades.BookingStatus;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
    List<Booking> findByStatusAndCustomer(BookingStatus status, Long id);
    List<Booking> findBystatus(BookingStatus status);
    List<Booking> findByoutboundFlight(Long id);
}
