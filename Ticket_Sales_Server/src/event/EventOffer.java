package event;

/**
 * Created by Kreator 11/7/2019
 * 
 * <h1>ENUM LIST OF EVENTS</h1>
 * 
 * EventOffer Enumeration List is responsible for
 * creating a list of events which act as constants
 * until expiration.
 * 
 */
import java.time.LocalDate;

import com.ticket.tickets.MeetAndGreetTicket;
import com.ticket.tickets.StandardTicket;
import com.ticket.tickets.Ticket;
import com.ticket.tickets.VipTicket;

public enum EventOffer {

	TOOL("Tool", "Zitadelle Spandau", LocalDate.of(2019, 02, 03), new StandardTicket(50.50), new VipTicket(70.50),
			new MeetAndGreetTicket(120.50)),
	SADE("Sade", "Zitadelle Spandau", LocalDate.of(2019, 02, 03), new StandardTicket(50.50), new VipTicket(70.50),
			new MeetAndGreetTicket(120.50)),
	ALTER_BRIDGE("Alter Bridge", "Zitadelle Spandau", LocalDate.of(2019, 02, 03), new StandardTicket(50.50),
			new VipTicket(70.50), new MeetAndGreetTicket(120.50)),
	TOTO("TOTO", "Zitadelle Spandau", LocalDate.of(2019, 02, 03), new StandardTicket(50.50), new VipTicket(70.50),
			new MeetAndGreetTicket(120.50)),
	ARCTIC_MONKEYS("Arctic Monkeys", "Zitadelle Spandau", LocalDate.of(2019, 02, 03), new StandardTicket(50.50),
			new VipTicket(70.50), new MeetAndGreetTicket(120.50)),
	DAVID_BOWIE("David Bowie", "Zitadelle Spandau", LocalDate.of(2019, 02, 03), new StandardTicket(50.50),
			new VipTicket(70.50), new MeetAndGreetTicket(120.50)),
	QUEEN("Queen", "Zitadelle Spandau", LocalDate.of(2019, 02, 03), new StandardTicket(50.50), new VipTicket(70.50),
			new MeetAndGreetTicket(120.50)),
	SKA_P("Ska-P", "Zitadelle Spandau", LocalDate.of(2019, 02, 03), new StandardTicket(50.50), new VipTicket(70.50),
			new MeetAndGreetTicket(120.50)),
	CORRODED("Corroded", "Zitadelle Spandau", LocalDate.of(2019, 02, 03), new StandardTicket(50.50),
			new VipTicket(70.50), new MeetAndGreetTicket(120.50)),
	INSOMNIUM("Insomnium", "Zitadelle Spandau", LocalDate.of(2019, 02, 03), new StandardTicket(50.50),
			new VipTicket(70.50), new MeetAndGreetTicket(120.50));

	private String name;
	private String location;
	private LocalDate date;
	private StandardTicket sTicket;
	private VipTicket vipTicket;
	private MeetAndGreetTicket mgTicket;
	private Ticket ticket;

	/**
	 * 
	 * @param name      name of event;
	 * @param location  event venue;
	 * @param date;
	 * @param sTicket   price of standard ticket;
	 * @param vipTicket price of VIP ticket;
	 * @param mgTicket  price of Meet And Greet Ticket;
	 */
	private EventOffer(String name, String location, LocalDate date, StandardTicket sTicket, VipTicket vipTicket,
			MeetAndGreetTicket mgTicket) {
		this.name = name;
		this.location = location;
		this.date = date;
		this.sTicket = sTicket;
		this.vipTicket = vipTicket;
		this.mgTicket = mgTicket;
	}

	public Ticket getTicket() {
		return ticket;
	}

	/**
	 * 
	 * @return the name of event.
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return the name of the Venue.
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * 
	 * @return the date of event.
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * 
	 * @return the standard ticket information
	 */
	public StandardTicket getStandardTicket() {
		return sTicket;
	}

	/**
	 * 
	 * @return the Vip ticket information
	 */

	public VipTicket getVipTicket() {
		return vipTicket;
	}

	/**
	 * 
	 * @return the Meet and Greet ticket information
	 */

	public MeetAndGreetTicket getMgTicket() {
		return mgTicket;
	}

	/**
	 * 
	 * @param strInput
	 * @return
	 */

	public static String capFirst(String strInput) {
		return Character.toUpperCase(strInput.charAt(0)) + strInput.substring(1).toLowerCase();
	}

	/**
	 * 
	 * @param chosen users input (choice of the event)
	 * @return the description of chosen event; including name of chosen event,
	 *         location of chosen event, date of chosen event and prices for all
	 *         types of tickets available for the chosen event
	 * 
	 */
	public String getDescription(EventOffer chosen) {
		return chosen.getName() + " plays at " + chosen.getLocation() + " on " + chosen.getDate()
				+ "\nPrices are as follows: " + "\nStandard: " + chosen.getStandardTicket().getPrice() + "\nVIP: "
				+ chosen.getVipTicket().getPrice() + "\nMeet&Greet: " + chosen.getMgTicket().getPrice();
	}
}
