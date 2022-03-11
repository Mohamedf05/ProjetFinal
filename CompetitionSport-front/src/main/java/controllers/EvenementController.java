package controllers;



import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Evenement;
import model.Statut;
import util.Context;

@WebServlet("/evenement")
public class EvenementController extends HttpServlet {

	//FindById + FindAll()
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("idO")!=null) 
		{
			int idO = Integer.parseInt(request.getParameter("idO"));
			List<Evenement> evenement=Context.getSingleton().getDaoEvenement().findAllByOrganisateur(idO);
			request.setAttribute("listeEvenement", evenement);
			System.out.println(evenement);
			getServletContext().getRequestDispatcher("/evenement.jsp").forward(request, response);
		}
		
		
		//findAll()
		if(request.getParameter("id")==null) 
		{
			List<Evenement> evenement=Context.getSingleton().getDaoEvenement().findAll();
			request.setAttribute("listeEvenement", evenement);
			System.out.println(evenement);
			getServletContext().getRequestDispatcher("/evenement.jsp").forward(request, response);
		}
			
		//findById
				else 
				{
					int id = Integer.parseInt(request.getParameter("id"));
					Evenement e = Context.getSingleton().getDaoEvenement().findById(id);
					request.setAttribute("evenement", e);
					if(request.getParameter("action")=="consulter")
					{
						
						getServletContext().getRequestDispatcher("/WEB-INF/consulterEvenement.jsp").forward(request, response);
					}
					else
					{
						getServletContext().getRequestDispatcher("/WEB-INF/updateEvenement.jsp").forward(request, response);
						
					}
				
				}
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			if(request.getParameter("tache").equals("save")) 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			int version = Integer.parseInt(request.getParameter("version"));
			Evenement e = new Evenement(id, request.getParameter("nom"), LocalDate.parse(request.getParameter("dateDebut")), LocalDate.parse(request.getParameter("dateFin")), request.getParameter("ville"), Statut.valueOf(request.getParameter("statut")));
			e.setVersion(version);
			Context.getSingleton().getDaoEvenement().save(e);
		}
		else if(request.getParameter("tache").equals("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Context.getSingleton().getDaoEvenement().delete(id);
		}

		response.sendRedirect("evenement");
	}
	

}
