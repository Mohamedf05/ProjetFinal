package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CompetitionSport.model.Adresse;
import CompetitionSport.model.Discipline;
import CompetitionSport.model.Epreuve;
import CompetitionSport.model.TypeTerrain;
import util.Context;

@WebServlet("/epreuve")
public class EpreuveController extends HttpServlet {

	//FindById + FindAll()
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//findAll()
		if(request.getParameter("id")==null) 
		{
			List<Epreuve> epreuves = Context.getSingleton().getDaoEpreuve().findAll();
			request.setAttribute("listeEpreuve", epreuves);
			getServletContext().getRequestDispatcher("/WEB-INF/epreuves.jsp").forward(request, response);
		}
		//findById
		else
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Epreuve e = Context.getSingleton().getDaoEpreuve().findById(id);
			request.setAttribute("epreuve", e);
			getServletContext().getRequestDispatcher("/WEB-INF/updateEpreuve.jsp").forward(request, response);
		}

		

	}


	//Update / Insert / Delete
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("tache").equals("save")) 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			int maxParticipant = Integer.parseInt(request.getParameter("maxParticipant"));
			int version = Integer.parseInt(request.getParameter("version"));
			Epreuve t = new Epreuve(maxParticipant, LocalDate.parse(request.getParameter("dateDebut")), LocalDate.parse(request.getParameter("dateFin")), Discipline.valueOf(request.getParameter("discipline")), TypeTerrain.valueOf(request.getParameter("terrain")));
			t.setVersion(version);
			Context.getSingleton().getDaoEpreuve().save(t);
		}
		else if(request.getParameter("tache").equals("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Context.getSingleton().getDaoEpreuve().delete(id);
		}
		response.sendRedirect("epreuve");
	}

}
