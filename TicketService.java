package in.jay.service;

import java.util.List;

import in.jay.binding.Passenger;
import in.jay.binding.Ticket;

public interface TicketService {
	
	public Ticket bookticket(Passenger passenger);
	
	public Ticket getTicket(Integer ticketId);
	
	public List <Ticket> getAllTicket();

}
