package event;

/**
 * Created by Kreator 11/7/2019
 * 
 * Event Maker class outputs our ENUM LIST of events
 */

import java.util.ArrayList;
import java.util.List;
import static event.EventOffer.TOOL;
import static event.EventOffer.*;

public class EventMaker {

	private List<Events> allEvents = new ArrayList<>();
	EventOffer[] artists = { TOOL, SADE, ALTER_BRIDGE, TOTO, ARCTIC_MONKEYS, DAVID_BOWIE, QUEEN, SKA_P, CORRODED,
			INSOMNIUM };

	public List<Events> getEvents() {
		return allEvents;
	}

	public EventMaker() {
		// For loop which displays event offer --> maybe a drop down list or a table
		// later
		for (int i = 0; i < artists.length; i++) {
			System.out.println((i + 1) + ". " + artists[i] + " [" + artists[i].getDate() + "]");
		}
	}

}
