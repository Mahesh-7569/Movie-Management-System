package com.jsp.moviedb.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.TryCatchFinally;

@WebServlet("/add-movie")
public class AddMovie extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {////
	
		int movieId=Integer.parseInt(req.getParameter("movieId"));
		String movieTitle=req.getParameter("movieTitle");
		String movieGenre=req.getParameter("movieGenre");
		String movieDirector=req.getParameter("movieDirector");
		int movieRating=Integer.parseInt(req.getParameter("movieRating"));
		
		//JDBC Logic
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_moviedb?user=root&password=root");
			PreparedStatement pst= conn.prepareStatement("INSERT INTO servlet_moviedb VALUES(?,?,?,?,?)");
			
			pst.setInt(1, movieId);
			pst.setString(2, movieTitle);
			pst.setString(3, movieGenre);
			pst.setString(4, movieDirector);
			pst.setInt(5, movieRating);
			
			pst.executeUpdate();
			resp.sendRedirect("display-movies");
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
	
		

