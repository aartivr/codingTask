package com.booking.repository;



import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.booking.containerbooking.model.Booking;

@Repository
public interface BookingRepository extends ReactiveCrudRepository<Booking, String>{ 

	
}
