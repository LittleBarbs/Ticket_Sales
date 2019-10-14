package com.ticket.sales;

import static event.EventOffer.ALTER_BRIDGE;
import static event.EventOffer.ARCTIC_MONKEYS;
import static event.EventOffer.CORRODED;
import static event.EventOffer.DAVID_BOWIE;
import static event.EventOffer.INSOMNIUM;
import static event.EventOffer.QUEEN;
import static event.EventOffer.SADE;
import static event.EventOffer.SKA_P;
import static event.EventOffer.TOOL;
import static event.EventOffer.TOTO;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import event.EventOffer;

/**
 * Created by Kreator 11/7/2019 Stock class contains list of events and its
 * corresponding number/stock of tickets
 */
public class Stock {

	private int stock;
	private int vipStock;
	private int mgStock;
	private int sStock;
	private EnumMap<EventOffer, TicketsAvailable> allTicketsMap = new EnumMap<>(EventOffer.class);

	/**
	 * @parameter stock the ticket stock
	 * @parameter vipStock for future purposes to set vip ticket stock
	 * @parameter mgStock for future purposes to set meet and greet ticket stock
	 * @parameter sStock for future purposes to set standard ticket stock
	 * @parameter allTickets Enum list of events and available tickets
	 */

	/**
	 * 
	 */
	TicketsAvailable toolStock = new TicketsAvailable(TOOL, 5000);
	TicketsAvailable sadeStock = new TicketsAvailable(SADE, 3000);
	TicketsAvailable ABStock = new TicketsAvailable(ALTER_BRIDGE, 2000);
	TicketsAvailable totoStock = new TicketsAvailable(TOTO, 10000);
	TicketsAvailable arcticMonkeysStock = new TicketsAvailable(ARCTIC_MONKEYS, 4000);
	TicketsAvailable DBStock = new TicketsAvailable(DAVID_BOWIE, 22000);
	TicketsAvailable queenStock = new TicketsAvailable(QUEEN, 30000);
	TicketsAvailable skaPStock = new TicketsAvailable(SKA_P, 5000);
	TicketsAvailable corrodedStock = new TicketsAvailable(CORRODED, 500);
	TicketsAvailable insomniumStock = new TicketsAvailable(INSOMNIUM, 800);

	/**
	 * Stock() constructors builds our stock list of available tickets for
	 * corresponding event
	 */
	public Stock() {
		allTicketsMap.put(TOOL, toolStock);
		allTicketsMap.put(SADE, sadeStock);
		allTicketsMap.put(ALTER_BRIDGE, ABStock);
		allTicketsMap.put(TOTO, totoStock);
		allTicketsMap.put(ARCTIC_MONKEYS, arcticMonkeysStock);
		allTicketsMap.put(DAVID_BOWIE, DBStock);
		allTicketsMap.put(QUEEN, queenStock);
		allTicketsMap.put(SKA_P, skaPStock);
		allTicketsMap.put(CORRODED, corrodedStock);
		allTicketsMap.put(INSOMNIUM, insomniumStock);
	}

	/**
	 * buyTicketFromMap method sends a message to the seller informing it about the
	 * remaining ticket stock for chosen event
	 * 
	 * @param event chosen by user
	 */
	public void buyTicketFromMap(EventOffer event) {
		TicketsAvailable stock = allTicketsMap.get(event);
		System.out.println(
				"[Message to SELLER]Stock: " + stock.getEventTicket().getName() + ",  " + stock.getTicketNumbers());
	}

	/*
	 * First attempt to get the chosen ticket out of a enum list with switch
	 * statement which was replaced by mapping methods
	 */

//	public void buyTicket(EventOffer event) {
//		switch (event) {
//		case TOOL:
//			System.out.println("[Message to SELLER]Stock: " + toolStock.getTicketNumbers());
//			break;
//		case SADE:
//			System.out.println("[Message to SELLER]Stock: " + sadeStock.getTicketNumbers());
//			break;
//		case ALTER_BRIDGE:
//			System.out.println("[Message to SELLER]Stock: " + ABStock.getTicketNumbers());
//			break;
//		case TOTO:
//			System.out.println("[Message to SELLER]Stock: " + totoStock.getTicketNumbers());
//			break;
//		case ARCTIC_MONKEYS:
//			System.out.println("[Message to SELLER]Stock: " + arcticMonkeysStock.getTicketNumbers());
//			break;
//		case DAVID_BOWIE:
//			System.out.println("[Message to SELLER]Stock: " + DBStock.getTicketNumbers());
//			break;
//		case QUEEN:
//			System.out.println("[Message to SELLER]Stock: " + queenStock.getTicketNumbers());
//			break;
//		case SKA_P:
//			System.out.println("[Message to SELLER]Stock: " + skaPStock.getTicketNumbers());
//			break;
//		case CORRODED:
//			System.out.println("[Message to SELLER]Stock: " + corrodedStock.getTicketNumbers());
//			break;
//		case INSOMNIUM:
//			System.out.println("[Message to SELLER]Stock: " + insomniumStock.getTicketNumbers());
//			break;
//		default:
//			System.out.println("Nope");
//			break;
//		}
//	}

	/**
	 * Overriden toString method
	 */
	@Override
	public String toString() {
		return "Please select your ticket: Vip, Meet & Greet or Standard ticket";
	}

	/**
	 * 
	 * @return stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * 
	 * @return vipStock
	 */
	public int getVipStock() {
		return vipStock;
	}

	/**
	 * 
	 * @return return mgStock
	 */
	public int getMgStock() {
		return mgStock;
	}

	/**
	 * 
	 * @return sStock
	 */
	public int getSStock() {
		return sStock;
	}

	/**
	 * 
	 * @param event:   chosen event
	 * @param numbers: selection of tickets
	 * @return new ticket stock number
	 */
	public List<EventOffer> testSell(EventOffer event, int numbers) {
//		TicketsAvailable toolStock = new TicketsAvailable(TOOL, 5000);
		// toolStock.getEventTicket();
		List<EventOffer> soldTickets = new ArrayList<>();
		TicketsAvailable stock = allTicketsMap.get(event);
		// soldTickets.add(stock.getEventTicket());
		for (int i = 1; i < numbers; i++) {
			soldTickets.add(stock.getEventTicket());
		}

		/*
		 * First attempt
		 */
//		for (int i = 0; i < numbers; i++) {
//			switch (event) {
//			case TOOL:
//				soldTickets.add(toolStock.getEventTicket());
//				break;
//			case SADE:
//				soldTickets.add(sadeStock.getEventTicket());
//				break;
//			case ALTER_BRIDGE:
//				soldTickets.add(ABStock.getEventTicket());
//				break;
//			case TOTO:
//				soldTickets.add(totoStock.getEventTicket());
//				break;
//			default:
//				System.out.println("Not available");
//				break;
//
//			}
//
//		}
		// buyTicket(event);
		buyTicketFromMap(event);
		return soldTickets;
	}

	/*
	 * Setup for future purposes of ticket stock overview
	 */
//	public void vipSold(int sold) {
//		stock -= sold;
//		vipStock -= sold;
//		System.out.println("All tickets on stock: " + stock + "\nVIP tickets on stock: " + vipStock);
//
//		if (vipStock == 0) {
//			System.out.println("Sorry, VIP tickets are sold out!");
//		}
//	}
//
//	public void mgSold(int sold) {
//		stock -= sold;
//		mgStock -= sold;
//		System.out.println("All tickets on stock: " + stock + "\nMeet and Greet tickets on stock: " + mgStock);
//		if (mgStock == 0) {
//			System.out.println("Sorry, Meet&Greet is sold out!");
//		}
//	}
//
//	public void sSold(int sold) {
//		stock -= sold;
//		sStock -= sold;
//		System.out.println("All tickets on stock: " + stock + "\nStandard tickets on stock: " + sStock);
//		if (sStock == 0) {
//			System.out.println("Sorry, standard tickets are sold out!");
//		}
//	}
//
//	public void soldOut() {
//		if (vipStock == 0 && mgStock == 0 && stock == 0) {
//			System.out.println("Tickets are sold out!");
//		}
//	}
}
