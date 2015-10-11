package dao;

import java.util.ArrayList;

import other.Ticket;

public interface TicketDAO {
	void createNewTicket(Ticket ticket);
	ArrayList<Ticket> search();
	Ticket viewTicket(String ticketNumber);
	String updateTicketStatus(String status,Ticket ticket);
}
