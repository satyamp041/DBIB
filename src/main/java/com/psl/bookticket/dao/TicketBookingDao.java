package com.psl.bookticket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psl.bookticket.entities.Ticket;

@Repository
public interface TicketBookingDao extends JpaRepository<Ticket, Integer> {

}
