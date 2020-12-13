package com.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.model.Booking;
import com.booking.repository.BookingRepository;
import reactor.core.publisher.Mono;

@Service
public class ContainerBookingService {	

	@Autowired
	private BookingRepository bookingRepository;

	    public ContainerBookingService(BookingRepository bookingRepository) {
	        this.bookingRepository = bookingRepository;
	    }

	    public Mono<Booking> save(Booking booking) {
	        return bookingRepository.save(booking);
	    }

	    
	    public Mono<Booking> find(String id)  {
	        return bookingRepository.findById(id);
	    }
	}


