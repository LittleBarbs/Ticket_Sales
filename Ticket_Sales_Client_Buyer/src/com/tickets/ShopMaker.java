package com.tickets;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.ticket.sales.Shop;
import com.ticket.sales.ShopList;
import com.ticket.sales.Stock;
import com.ticket.sales.TicketsAvailable;
import com.ticket.tickets.MeetAndGreetTicket;
import com.ticket.tickets.TicketDescription;
import com.ticket.tickets.VipTicket;

import event.EventMaker;
import event.EventOffer;
import event.Events;

import static com.ticket.sales.ShopList.*;

/**
 * Created by Kreator 11/7/2019
 * 
 * This class is responsible for creating a list of shops containing the Event
 * Offer it implements Serializable for the project purposes of client/server
 * object transmission
 * 
 */

public class ShopMaker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Shop> allShops = new ArrayList<>();
	private ShopList[] shops = { TICKET_DEN, TICKET_PARADISE, AT_THE_SPOT, ZITADELLE_SPANDAU };
	// private transient Scanner reader;

	/**
	 * 
	 * @return an array of shops
	 */
	public List<Shop> getShops() {
		return allShops;
	}

	public ShopMaker() {
		// ShopMaker throws us a random shop at which the customer can purchase
		// tickets --> later should be optional
		Random shop = new Random();
		int n = shop.nextInt(4);

		// We get the greeting and the name from random shop and a method which is the
		// same for all shops and displays the event offer
		shops[n].getGreeting();
		System.out.println();
		displayEvents();

	}

	/**
	 * 
	 * @return shop from our list of shops that are providing the ticket sale
	 *         service
	 */

	public ShopList[] getShop() {
		return shops;
	}

	/**
	 * displayEvents method gives the user the list of the events from EventOffer
	 * with all the stored information about an Event and checks users input
	 */
	public void displayEvents() {

		System.out.println(
				"************* Please select the concert you would like to attend (type in a corresponding artist): *************");
		EventMaker makeEvent = new EventMaker();
		List<Events> allEvents = makeEvent.getEvents();
		allEvents.forEach(System.out::println);
		VipTicket vip = new VipTicket(0);
		MeetAndGreetTicket meet = new MeetAndGreetTicket(0);
		System.out.println();
		System.out.println("Type here: ");

		/**
		 * try/catch checks switch statement of the users input, if there is a match
		 * with given events it processes it further, if not, the method calls itself
		 * out again
		 */

		Scanner reader = new Scanner(System.in);
		String eventName = reader.nextLine().toUpperCase().replace(' ', '_');
		EventOffer chosen = EventOffer.valueOf(eventName);
		eventName = chosen.toString().toUpperCase();
		try {
			switch (chosen) {
			case TOOL:
			case SADE:
			case ALTER_BRIDGE:
			case TOTO:
			case ARCTIC_MONKEYS:
			case DAVID_BOWIE:
			case QUEEN:
			case SKA_P:
			case CORRODED:
			case INSOMNIUM:
				System.out.println(chosen.getDescription(chosen));
				break;
			default:
				System.err.println("Hm-hm-hm");
				break;
			}

			/**
			 * if the users input matched the EventOffer, the user is asked whether they
			 * would like to purchase a ticket or not if the input is positive, program
			 * checks which type of Ticket is being purchased and acts accordingly, if the
			 * input is negative, displayEvent is called out again, if the input is anything
			 * else, the program is terminated
			 */
			System.out.println();
			System.out.println(
					"*********If you want to get your ticket please type y, if you want to go back to our offer type n and press enter***********");

			reader = new Scanner(System.in);
			String output = reader.nextLine().toLowerCase();

			if (output.equals("y")) {
				Stock stock = new Stock();
				TicketsAvailable available = new TicketsAvailable(chosen, 0);
				System.out.println(available.toString());
				reader = new Scanner(System.in);
				String ticket = reader.nextLine().toLowerCase();
				int ticketSold;

				switch (chosen) {
				case TOOL:
				case SADE:
				case ALTER_BRIDGE:
				case TOTO:
				case ARCTIC_MONKEYS:
				case DAVID_BOWIE:
				case QUEEN:
				case SKA_P:
				case CORRODED:
				case INSOMNIUM:

					switch (ticket) {
					case "vip":
						describeTicket(vip);
						System.out.println("You can order max 5 tickets, please type your number: ");
						reader = new Scanner(System.in);
						ticketSold = reader.nextInt();
						stock.testSell(chosen, ticketSold);
						System.out.println("[Message to BUYER]Thank you for your VIP purchase!");
						break;
					case "meet":
						describeTicket(meet);
						System.out.println("You can order max 3 tickets, please type your number: ");
						reader = new Scanner(System.in);
						ticketSold = reader.nextInt();
						stock.testSell(chosen, ticketSold);
						System.out.println("[Message to BUYER]Thank you for your Meet&Greet purchase!");
						break;
					case "standard":
						System.out.println("You can order max 3 tickets, please type your number: ");
						reader = new Scanner(System.in);
						ticketSold = reader.nextInt();
						stock.testSell(chosen, ticketSold);
						System.out.println("[Message to BUYER]Thank you for your purchase!");
						break;
					default:
						System.out.println("Please try again.");
						break;
					}
					break;
				default:
					System.err.println("Hm-hm-hm");
					break;
				}

			} else if (output.equals("n")) {

				displayEvents();

			} else {

				System.out.println("[SESSION TERMINATED)");
				System.exit(1);

			}
		} catch (IllegalArgumentException i) {
			System.out.println("Invalid input please try again: ");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();

			}

			displayEvents();

		}

	}

	public static void describeTicket(TicketDescription description) {
		description.describe();
	}
}
