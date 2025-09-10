package in.jay.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jay.binding.Passenger;
import in.jay.binding.Ticket;
import in.jay.repo.TicketRepo;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepo repo;

	@Override
	public Ticket bookticket(Passenger passenger) {
		Ticket t = new Ticket();
		BeanUtils.copyProperties(passenger, t);
		t.setTicketStatus("Confirmed");
		Ticket savedTicket = repo.save(t);
		return savedTicket;
	}

	@Override
	public Ticket getTicket(Integer ticketId) {
		 repo.findById(ticketId).orElseThrow();
		 return null;
	}

	@Override
	public List<Ticket> getAllTicket() {
		return repo.findAll();	}

}
