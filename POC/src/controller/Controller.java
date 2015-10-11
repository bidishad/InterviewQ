package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import other.UserInfoSinlgeton;

public class Controller extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException{
		
		response.setContentType("text/html");
		
		if(processLogin(request,response)){
			response.sendRedirect("LogTicket.jsp");
		}
	}

	public boolean processLogin(HttpServletRequest request,HttpServletResponse response){
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		try{
			PrintWriter out = response.getWriter();
			URL url = new URL("http://localhost:8080/POC/login/post");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Media-Type", "TEXT_PLAIN");

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String status;
			while ((status = br.readLine()) != null) {
			}
			
				
			if(status.equals("TRUE")){
				UserInfoSinlgeton.getInstance().setPassword(password);
				UserInfoSinlgeton.getInstance().setUsername(username);
				return true;
			}
		}catch(Exception ex){
			
		}
		return false;
	}
}
