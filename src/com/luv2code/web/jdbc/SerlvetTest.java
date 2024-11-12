package com.luv2code.web.jdbc;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.sql.DataSource;



/**
 * Servlet implementation class SerlvetTest
 */
public class SerlvetTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jbdc/car_rental")
	private DataSource dataSource;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out = response.getWriter();

	    Connection myConn = null;

	    try {
	        // Ottieni una connessione dal pool di connessioni
	        myConn = dataSource.getConnection();

	        // Test di connessione riuscito
	        out.println("Connessione al database riuscita!");

	    } catch (Exception exc) {
	        exc.printStackTrace();
	        // Stampa l'errore nel log
	        out.println("Errore di connessione al database: " + exc.getMessage());
	    } finally {
	        try {
	            if (myConn != null) myConn.close(); // Chiudi la connessione
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

}
