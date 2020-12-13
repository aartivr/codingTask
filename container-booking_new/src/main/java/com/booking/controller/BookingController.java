package com.booking.controller;

import java.sql.Date;
import java.util.Random;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.booking.containerbooking.model.Booking;
import com.booking.containerbooking.service.ContainerBookingService;

import reactor.core.publisher.Mono;
 
@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	
	@Autowired
	private ContainerBookingService bookingService;

    public BookingController(ContainerBookingService bookingService) {
        this.bookingService = bookingService;
    }	

	@PostMapping(value="/api/bookings/createbookings")
	public Mono<ResponseEntity<Booking>> createBooking(@RequestBody Booking booking) {
	
		int num = new Random().nextInt(); 
		String ref = String.format("%06d", num);
		String bookingRef = "957"+ref;
		Booking book= new Booking(bookingRef, booking.getContainer_origin(), booking.getContainer_destination(), booking.getContainer_size(), booking.getContainer_type(), booking.getQuantity());
		return bookingService.save(book).map(bookingFinal -> {
			return ResponseEntity.ok(book);
		}).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}


	@GetMapping("{id}")
	public Mono<Booking> findbyId(@PathVariable String Id) {
		return bookingService.find(Id);
	}

}