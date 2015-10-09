package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import other.UserInfoSinlgeton;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/login")
public class LoginDAO {
	
	@POST
	@Path("/post")
	@Consumes(MediaType.TEXT_PLAIN)
	public static String validate(){  
		boolean status=false;  
		
		try{  
			
			Connection con=ConnectionProvider.getCon();  
		              
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
		  
		return "FALSE";  
		  
		}  

}
