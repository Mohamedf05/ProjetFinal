package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Reservation;
import model.Adresse;
import model.Discipline;
import util.Context;
//AAAAAAAAAAAAAAAA FFFFFFFFAAAAAAAAAAAAAAAIIIIIIIIIIIIIIIIIRRRRRRRRRRRREEEEEEEEEEEEE
@WebServlet("/reservation")
public class ReservationController extends HttpServlet {

	//FindById + FindAll()
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//findAll()
		if(request.getParameter("id")==null) 
		{
			List<Reservation> reservations = Context.getSingleton().getDaoReservation().findAll();
			request.setAttribute("listeReservation", reservations );
			getServletContext().getRequestDispatcher("/WEB-INF/reservations.jsp").forward(request, response);
		}
		//findById
		else 
		{
			
			int id = Integer.parseInt(request.getParameter("id"));
			Reservation t = Context.getSingleton().getDaoReservation().findById(id);
			request.setAttribute("reservation", t);
			getServletContext().getRequestDispatcher("/WEB-INF/updateReservation.jsp").forward(request, response);
			
		}

		

	}


	//Update / Insert / Delete
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("tache").equals("save")) 
		{
		
			int id = Integer.parseInt(request.getParameter("id"));
			int version = Integer.parseInt(request.getParameter("version"));
			Reservation t = new Reservation();
			t.setVersion(version);
			Context.getSingleton().getDaoReservation().save(t);
		}
		else if(request.getParameter("tache").equals("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Context.getSingleton().getDaoReservation().delete(id);
		}

		response.sendRedirect("reservation");
	}

}
