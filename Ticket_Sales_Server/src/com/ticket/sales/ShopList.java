package com.ticket.sales;

/**
 * Created by Kreator 11/7/2019
 * 
 * The ENUM ShopList gives us a list of shops where the client may purchase its
 * ticket
 *
 */
public enum ShopList {

	/**
	 * List of shops
	 */
	TICKET_DEN("TicketDen", true), TICKET_PARADISE("TicketParadise", true), AT_THE_SPOT("TicketsAtTheSpot", false),
	ZITADELLE_SPANDAU("ZitadelleSpandauVenue", false);

	private String name;
	private boolean online;

	/**
	 * 
	 * @param name
	 * @param online
	 */
	private ShopList(String name, boolean online) {
		this.name = name;
		this.online = online;
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return is online
	 */
	public boolean isOnline() {
		return online;
	}

	/**
	 * method which greets the user with its corresponding shop name
	 */
	public void getGreeting() {
		System.out.println(" ************* Welcome to the " + getName()
				+ ", and thanks for checking out our offer! ************* ");
	}

}
