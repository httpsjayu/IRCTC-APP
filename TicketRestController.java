package in.jay.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.jay.binding.Passenger;
import in.jay.binding.Ticket;
import in.jay.service.TicketService;

@RestController
public class TicketRestController {
	
	@Autowired
	private TicketService service;
	
	@PostMapping(value = "/Ticket",produces = "application/json",consumes = "application/json")
	public ResponseEntity <Ticket> bookTicket(@RequestBody Passenger p){
		Ticket ticket = service.bookticket(p);
		return new ResponseEntity<>(ticket,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/ticket/{ticketId}",produces = "application/json")
	public ResponseEntity <Ticket> getTicket(@PathVariable("ticketId") Integer ticketId){
		Ticket t = service.getTicket(ticketId);
		return new ResponseEntity<>(t,HttpStatus.OK);
	}
	
	@GetMapping(value = "/tickets" ,produces = "application/json")
	public ResponseEntity <List<Ticket>> getAllTicket(){
		List <Ticket> tickets = service.getAllTicket();
		return new ResponseEntity <>(tickets,HttpStatus.OK);
	}

}
