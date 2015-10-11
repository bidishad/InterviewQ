package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ConnectionProvider;
import other.Ticket;

public class TicketDAOImpl implements TicketDAO{

	@Override
	public void createNewTicket(Ticket ticket) {
			
		Connection con = null;
			try{  
				con=ConnectionProvider.getCon();  
			              
				PreparedStatement ps=con.prepareStatement(  
			    "insert into ticket values(?,?,?,?,?)");  
			  
				ps.setString(1, ticket.getTicketNumber());
				ps.setString(2, ticket.getStatus());
				ps.setString(2, ticket.getBelongsTo().getName());
				ps.setString(2, ticket.getComments().toString());
				ps.setString(2, ticket.getCreatedBy().getName());
				
				ResultSet rs=ps.executeQuery();  
				
			              
			}catch(Exception e){
				
			}
			finally{
				try{
					con.close();
				}catch(SQLException ex){
					
				}
			}
	}

	@Override
	public ArrayList<Ticket> search() {
		Connection con = null;
		Ticket ts = null;
		try{
			ArrayList<Ticket> arr = new ArrayList();
			con = ConnectionProvider.getCon();
			
			PreparedStatement ps=con.prepareStatement(  
				    "select * from ticket where ticketnumber=?"); 
			
			ResultSet rs=ps.executeQuery();
			while(rs!=null){
					ts = new Ticket();  
					ts.setTicketNumber(rs.getString(1));
					ts.setComments(new StringBuffer(rs.getString(2)));
					arr.add(ts);
			}
			
			return arr;
			
		}catch(Exception ex){
			
		}finally{
			
		}
		return null;
	}

	@Override
	public Ticket viewTicket(String ticketNumber) {
		Ticket ts = null;
		Connection con = null;
		try{  
			con =ConnectionProvider.getCon();  
		              
			PreparedStatement ps=con.prepareStatement(  
		    "select * from ticket where ticketnumber=?");  
		  
			ps.setString(1, ticketNumber);
					              
			ResultSet rs=ps.executeQuery();  
			while(rs!=null){
				ts = new Ticket();  
				ts.setTicketNumber(rs.getString(1));
				ts.setComments(new StringBuffer(rs.getString(2)));
			}
		              
		}catch(Exception e){
			
		}finally{
			try{
				con.close();
			}catch(SQLException ex){
				
			}
		}
		return ts;		   
	}

	@Override
	public String updateTicketStatus(String status, Ticket ticket) {
		String statusToSent = "FALSE";
		Connection con = null;
		ResultSet result = null;
		PreparedStatement stmt = null;
		String ticketId = null;
		try{
			con = ConnectionProvider.getCon();
			
			if(ticket!=null){
				ticketId = ticket.getTicketNumber();
			}else{
				statusToSent= "FALSE";
			}
			PreparedStatement ps=con.prepareStatement(  
				    "update ticket set status=? where ticketId = ?");
			
			ps.setString(1, status);
			ps.setString(2, ticketId);
			
			result=ps.executeQuery();
			if(result.next()){
				statusToSent = "TRUE";
			}
		}catch(Exception ex){
			
		}
		finally{
			try{
				con.close();
			}catch(SQLException ex){
				
			}
		}
		return statusToSent;
	}


}
