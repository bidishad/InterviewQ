package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import other.Ticket;
import other.UserInfoSinlgeton;

public class TicketDAO {
	public static Ticket search(String ticketnumber){  
			
		Ticket ts = null;
		try{  
			Connection con=ConnectionProvider.getCon();  
		              
			PreparedStatement ps=con.prepareStatement(  
		    "select * from ticket where ticketnumber=?");  
		  
			ps.setString(1, ticketnumber);
					              
			ResultSet rs=ps.executeQuery();  
			ts = new Ticket();  
			ts.setTicketNumber(rs.getString(1));
			ts.setComments(new StringBuffer(rs.getString(2)));
		              
		}catch(Exception e){}
		return ts;		    
	}
	
	public static void createNewTicket(Ticket ticket){  
		
		try{  
			Connection con=ConnectionProvider.getCon();  
		              
			PreparedStatement ps=con.prepareStatement(  
		    "insert into ticket values(?,?)");  
		  
			ps.setString(1, ticket.getTicketNumber());
			ps.setString(2, ticket.getStatus());
			
			ResultSet rs=ps.executeQuery();  
			
		              
		}catch(Exception e){}
				    
	}

}
