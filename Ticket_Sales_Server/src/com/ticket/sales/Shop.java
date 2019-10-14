package com.ticket.sales;

/**
 * Created by Kreator 11/7/2019
 * 
 * Shop class is responsible for creating shops
 *
 */
public class Shop {

	private String name;
	private boolean online;

	/**
	 * @param name:   name of the shop
	 * @param online: is it an online shop or not
	 */

	/**
	 * 
	 * @return shop name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return is it online shop the attribute is set to check whether a shop is
	 *         online shop or not for future distinction between shops where
	 *         customer can also book the ticket and not only buy it
	 */
	public boolean isOnline() {
		return online;
	}

}
