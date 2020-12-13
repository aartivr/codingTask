package com.booking.model;

import java.util.Date;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;



@Table("booking")
public class Booking {
	
	@PrimaryKey	
	private String bookingref;
	private String container_destination;
	private String container_origin;
	private int container_size;
	private String container_type;
	private int quantity;
	private Date time_created;
	
	
	public Booking(String bookingRef2, String origin, 
			String destination, int size,
			String type, int quantity1) 
	{
		this.bookingref = bookingRef2;
		this.container_destination = destination;
		this.container_origin = origin;
		this.container_size = size;
		this.container_type = type;
		this.quantity = quantity1;
		this.time_created = new Date();
		
	}
	
	@Override	
	public String toString()
	{
		return " Booking ref = "+bookingref;
	}
	
	public String getBookingref() {
		return bookingref;
	}
	public void setBookingref(String bookingref) {
		this.bookingref = bookingref;
	}
	public String getContainer_destination() {
		return container_destination;
	}
	public void setContainer_destination(String container_destination) {
		this.container_destination = container_destination;
	}
	public String getContainer_origin() {
		return container_origin;
	}
	public void setContainer_origin(String container_origin) {
		this.container_origin = container_origin;
	}
	public int getContainer_size() {
		return container_size;
	}
	public void setContainer_size(int container_size) {
		this.container_size = container_size;
	}
	public String getContainer_type() {
		return container_type;
	}
	public void setContainer_type(String container_type) {
		this.container_type = container_type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getTime_created() {
		return time_created;
	}
	public void setTime_created(Date time_created) {
		this.time_created = time_created;
	}

	
	
	
	
	

}
