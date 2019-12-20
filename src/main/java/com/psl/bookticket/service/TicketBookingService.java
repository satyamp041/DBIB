package com.psl.bookticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.psl.bookticket.dao.TicketBookingDao;
import com.psl.bookticket.entities.Ticket;

@Service("ticketBookingservice")
public class TicketBookingService {
	@Autowired
	private TicketBookingDao ticketBookingDao;

	public Ticket createTicket(Ticket ticket) {
		return ticketBookingDao.save(ticket);

	}

	public Optional<Ticket> getTicketById(Integer ticketId) {
		return ticketBookingDao.findById(ticketId);
	}

	public List<Ticket> getAllTickets() {
		return (List<Ticket>) ticketBookingDao.findAll();
	}

	public void deleteTicketById(Integer ticketId) {
		ticketBookingDao.deleteById(ticketId);
	}

	public Ticket updateTicketById(Ticket ticketDetails, Integer ticketId) {
		Ticket ticket = ticketBookingDao.findById(ticketId).orElseThrow(
				() -> new ResourceAccessException("Resource Not Found"));
		ticket.setEmail(ticketDetails.getEmail());
		final Ticket updateTicketInfo = ticketBookingDao.save(ticket);
		return updateTicketInfo;

	}

}
