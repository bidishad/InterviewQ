package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import model.ConnectionProvider;
import other.UserInfoSinlgeton;

@Path("/login")
public class LoginDAOImpl implements LoginDAO{
	
	@POST
	@Path("/post")
	@Consumes(MediaType.TEXT_PLAIN)
	@Override
	public String validate(){  
		boolean status=false;  
		Connection con = null;
		try{  
			
			con=ConnectionProvider.getCon();  
		              
			PreparedStatement ps=con.prepareStatement(  
		    "select * from userInfo where username=? and password=?");  
		  
			ps.setString(1, UserInfoSinlgeton.getUsername());
			ps.setString(2, UserInfoSinlgeton.getPassword());  
		              
			ResultSet rs=ps.executeQuery();  
			status=rs.next();
			if(status){
				return "TRUE";
			}
		              
		}catch(Exception e){}  
		
		finally{
			try{
				con.clearWarnings();
			}catch(SQLException ex){
				
			}
		}
		  
		return "FALSE";  
		 
		}  
}
