package in.jay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.jay.binding.Ticket;

public interface TicketRepo extends JpaRepository <Ticket,Integer>{

}
