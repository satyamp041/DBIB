package com.psl.bookticket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.bookticket.entities.Ticket;
import com.psl.bookticket.service.TicketBookingService;

@RestController
@RequestMapping(value = "/api")
public class TicketBookingController {

	@Autowired
	private TicketBookingService ticketBookingService;

	@PostMapping(value = "/create")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return ticketBookingService.createTicket(ticket);
	}

	@GetMapping(value = "/ticket/{ticketId}")
	public Optional<Ticket> getTicket(@PathVariable("ticketId") Integer ticketId) {
		return ticketBookingService.getTicketById(ticketId);

	}

	@GetMapping(value = "/tickets")
	public List<Ticket> getAllTickets() {

		return ticketBookingService.getAllTickets();
	}

	@DeleteMapping(value = "/delete/{tid}")
	public String deleteTicketById(@PathVariable("tid") Integer ticketId) {
		ticketBookingService.deleteTicketById(ticketId);
		return "Ticket data deleted successfully";
	}

	@PutMapping(value = "/update/{ticketId}")
	public String updateTicketdata(@RequestBody Ticket ticketDetails,
			@PathVariable Integer ticketId) {
		ticketBookingService.updateTicketById(ticketDetails, ticketId);
		return "Ticket Data updated Successfully";

	}

}
