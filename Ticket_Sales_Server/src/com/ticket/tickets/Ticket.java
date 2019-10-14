package com.ticket.tickets;

/**
 * Created by Kreator 11/7/2019
 * 
 * Ticket class in an abstract class for all further tickets
 */
public abstract class Ticket {

	protected double price;

	/**
	 * 
	 * @param price of the ticket.
	 */
	public Ticket(double price) {
		this.price = price;
	}

	/**
	 * 
	 * @return price of the ticket.
	 */
	public double getPrice() {
		return price;
	}

}
