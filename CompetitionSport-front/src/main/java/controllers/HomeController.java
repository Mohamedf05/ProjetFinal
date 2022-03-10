package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Athlete;
import model.Client;
import model.Journaliste;
import model.Organisateur;
import model.Spectateur;
import util.Context;

@WebServlet("/home")
public class HomeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		
 	Client connected=Context.getSingleton().getDaoClient().seConnecter(mail,password);
		
		request.getSession().setAttribute("connected", connected);
		
		if(connected instanceof Organisateur) {response.sendRedirect("organisateur.jsp");}

		else if(connected instanceof Athlete) {response.sendRedirect("athlete.jsp");}

		else if(connected instanceof Spectateur) {response.sendRedirect("spectateur.jsp");}

		else if(connected instanceof Journaliste) {response.sendRedirect("journaliste.jsp");}

		else 
		{
			request.setAttribute("error", "Identifiants invalides");
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} 
		


	}
	

}
