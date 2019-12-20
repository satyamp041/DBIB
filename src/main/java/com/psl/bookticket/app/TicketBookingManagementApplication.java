package com.psl.bookticket.app;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.psl.bookticket.entities.Ticket;
import com.psl.bookticket.service.TicketBookingService;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.psl.bookticket.dao")
@EntityScan(basePackages = "com.psl.bookticket")
@ComponentScan(basePackages = { "com.psl.bookticket"})
public class TicketBookingManagementApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication
				.run(TicketBookingManagementApplication.class, args);
		TicketBookingService ticketBookingService = configurableApplicationContext
				.getBean("ticketBookingservice", TicketBookingService.class);
		Ticket ticket = new Ticket();
		ticket.setBookingDate(new Date());
		ticket.setDestination("Latur");
		ticket.setEmail("satyam@ggmail.com");
		ticket.setPassangerName("satyam patil");
		ticket.setSource("Pune");
		ticketBookingService.createTicket(ticket);
	}

}
