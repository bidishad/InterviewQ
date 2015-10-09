package other;

import java.util.ArrayList;
import java.util.Iterator;

import model.TicketDAO;

import constants.CommonConstants;

public class Employee extends Person{
	private static String employeeID ;
	private static ArrayList<Ticket> ticketAssigned;
	
	public static void createNewTicket(Ticket ticket){
		
		if(ticket!=null){
			TicketDAO.createNewTicket(ticket);
		}
    }
	
	public static boolean searchTicket(String ticketNumber){
		if(ticketNumber!=null){
			Ticket ticket = TicketDAO.search(ticketNumber);
			
			if(ticket!=null){
				return true;
			}
		}
		
		return false;
	}
	public static boolean changeTicketStatus(Ticket ticketStatusChange){
		if(ticketAssigned!=null){
			Iterator itr = ticketAssigned.iterator();
			
			while(itr.hasNext()){
				Ticket ticket =(Ticket) itr.next();
				if (ticket.getTicketNumber().equals(ticketStatusChange.getTicketNumber())){
					if(ticket.getStatus().equals(CommonConstants.getNew())){
						ticket.setStatus(CommonConstants.OPEN);
					}else if(ticket.getStatus().equals(CommonConstants.getOpen())){
						ticket.setStatus(CommonConstants.CLOSED);
					}
					return true;
				}
			}
		}
		return false;
	}
	

}
