package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CompetitionSport.model.Adresse;
import CompetitionSport.model.Logement;
import CompetitionSport.model.TypeLogement;
import util.Context;

@WebServlet("/logement")
public class LogementController extends HttpServlet {

	//FindById + FindAll()
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//findAll()
		if(request.getParameter("id")==null) 
		{
			List<Logement> logements = Context.getSingleton().getDaoLogement().findAll();
			request.setAttribute("listeLogement", logements);
			getServletContext().getRequestDispatcher("/WEB-INF/logements.jsp").forward(request, response);
		}
		//findById
		else 
		{
			
			int id = Integer.parseInt(request.getParameter("id"));
			Logement t = Context.getSingleton().getDaoLogement().findById(id);
			request.setAttribute("logement", t);
			getServletContext().getRequestDispatcher("/WEB-INF/updateLogement.jsp").forward(request, response);
			
		}
	}

	//Update / Insert / Delete
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("tache").equals("save")) 
		{
		
			int id = Integer.parseInt(request.getParameter("id"));
			int version = Integer.parseInt(request.getParameter("version"));
			Adresse adresse = new Adresse (request.getParameter("numero"),request.getParameter("voie"),request.getParameter("ville"),request.getParameter("cp"));
			Logement t = new Logement(id,request.getParameter("nom"), adresse, TypeLogement.valueOf("typeLogement"));
			t.setVersion(version);
			Context.getSingleton().getDaoLogement().save(t);
		}
		else if(request.getParameter("tache").equals("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Context.getSingleton().getDaoLogement().delete(id);
		}

		response.sendRedirect("logement");
	}

}
