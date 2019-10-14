package com.ticket.tickets;

/**
 * Created by Kreator 11/7/2019
 * 
 * Meet And Greet Ticket is a ticket subclass with additional features
 *
 */
public class MeetAndGreetTicket extends Ticket implements TicketDescription {

	public MeetAndGreetTicket(double price) {
		super(price);
	}

	public void describe() {
		System.out.println(
				"Meet And Greet offers you an exceptional experience where you will meet the artist, have a chat with them"
						+ "and you will also attend their soundcheck. For you my friend, everythings starts already at 15.00PM. Don't be late!");
	}

}
