package other;

import java.util.ArrayList;
import java.util.Iterator;


import constants.CommonConstants;
import dao.TicketDAO;

public class Employee extends Person{
	private String employeeID ;
	private ArrayList<Ticket> ticketAssigned;
	private TicketDAO ticketDAO; 
	
	public void createNewTicket(Ticket ticket){
		try{
			if(ticket!=null){
				ticketDAO.createNewTicket(ticket);
			}
		}catch(Exception ex){
			
		}
    }
	
	public ArrayList<Ticket> searchTicket(){
		try{
			ArrayList<Ticket> arrTickets = ticketDAO.search();
			
			if(arrTickets!=null){
				return arrTickets;
			}
		}catch(Exception ex){
			
		}		
		return null;
	}
	
	public Ticket viewTicket(String ticketId) {
		return ticketDAO.viewTicket(ticketId);
	}
	
	public boolean changeTicketStatus(String status, Ticket ticket){
		if(ticketDAO.updateTicketStatus(status, ticket).equalsIgnoreCase("TRUE")){
			return true;
		}else{
			return false;
		}
	}
	

}
