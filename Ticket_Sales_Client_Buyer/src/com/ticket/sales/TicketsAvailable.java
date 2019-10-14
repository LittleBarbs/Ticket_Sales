package com.ticket.sales;

import event.EventOffer;

/**
 * Created by Kreator 11/7/2019 TicketsAvailable class is responsible to create
 * objects with EventOffer and number of available tickets for corresponding
 * event
 *
 */
public class TicketsAvailable {

	private EventOffer eventTicket;
	private int ticketNumbers;

	/**
	 * 
	 * @param eventTicket:   event from EventOffer enum
	 * @param ticketNumbers: number of tickets available for corresponding event
	 */
	public TicketsAvailable(EventOffer eventTicket, int ticketNumbers) {
		this.eventTicket = eventTicket;
		this.ticketNumbers = ticketNumbers;
	}

	/**
	 * Overridden toString method
	 */
	public String toString() {
		return "Please select your ticket: Vip, Meet & Greet or Standard ticket";
	}

	/**
	 * 
	 * @return decrement number of tickets for each bought ticket
	 */
	public EventOffer getEventTicket() {
		ticketNumbers--;
		return eventTicket;
	}

	/**
	 * 
	 * @return corresponding number of tickets
	 */
	public int getTicketNumbers() {
		return ticketNumbers;
	}

}
