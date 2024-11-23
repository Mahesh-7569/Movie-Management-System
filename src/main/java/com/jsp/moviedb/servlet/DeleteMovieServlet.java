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

@WebServlet("/DeleteMovieServlet")


public class DeleteMovieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int movieId=Integer.parseInt(req.getParameter("movieId"));

		//JDBC Logics

		Connection conn=null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_moviedb?user=root&password=root");

			PreparedStatement pst=conn.prepareStatement("DELETE FROM servlet_moviedb WHERE movieId=?");
			pst.setInt(1, movieId);
			pst.executeUpdate();

			resp.sendRedirect("display-movies");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}



