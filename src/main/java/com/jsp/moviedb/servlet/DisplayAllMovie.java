package com.jsp.moviedb.servlet;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/display-movies")


public class DisplayAllMovie extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//JDBC Logics
		
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_moviedb?user=root&password=root");
			PreparedStatement pst=conn.prepareStatement("SELECT* FROM servlet_moviedb");
			ResultSet rs=pst.executeQuery();
			req.setAttribute("resultSet", rs);
			RequestDispatcher rd= req.getRequestDispatcher("display.jsp");
			rd.forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}



