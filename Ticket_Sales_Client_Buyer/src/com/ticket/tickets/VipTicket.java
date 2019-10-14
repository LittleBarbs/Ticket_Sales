package com.ticket.tickets;

/**
 * Created by Kreator 11/7/2019
 * 
 * VipTicket class is a subclass of Ticket class
 *
 */
public class VipTicket extends Ticket implements TicketDescription {

	/**
	 * 
	 * @param price ticket price
	 */

	public VipTicket(double price) {
		super(price);
	}

	public void describe() {
		System.out.println("Vip Ticket gives you an acces to the front row and a free drink of your choice.");
	}
}
