package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CompetitionSport.model.Athlete;
import CompetitionSport.model.Compte;
import CompetitionSport.model.Journaliste;
import CompetitionSport.model.Organisateur;
import CompetitionSport.model.Spectateur;
import util.Context;

@WebServlet("/client")
public class ClientController extends HttpServlet {

	//FindById + FindAll()
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//findAll()
		if(request.getParameter("id")==null) 
		{
			List<Compte> comptes=Context.getSingleton().getDaoClient().findAll();
			request.setAttribute("listeClient", comptes);
			getServletContext().getRequestDispatcher("/WEB-INF/comptes.jsp").forward(request, response);
		}
		//findById
		else 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Compte client = Context.getSingleton().getDaoClient().findById(id);
			if(client instanceof Organisateur) 
			{
				Organisateur o = (Organisateur) client;
				request.setAttribute("organisateur", o);
				getServletContext().getRequestDispatcher("/WEB-INF/updateOrganisateur.jsp").forward(request, response);
			}
			else if(client instanceof Athlete) 
			{
				Athlete a = (Athlete) client;
				request.setAttribute("athlete", a);
				getServletContext().getRequestDispatcher("/WEB-INF/updateAthlete.jsp").forward(request, response);
			}
			else if(client instanceof Spectateur) 
			{
				Spectateur s = (Spectateur) client;
				request.setAttribute("spectateur", s);
				getServletContext().getRequestDispatcher("/WEB-INF/updateSpectateur.jsp").forward(request, response);
			}
			else if(client instanceof Journaliste) 
			{
				Journaliste j = (Journaliste) client;
				request.setAttribute("journaliste", j);
				getServletContext().getRequestDispatcher("/WEB-INF/updateJournaliste.jsp").forward(request, response);
			}
			
			
		}

		

	}


	//save / Delete
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("typeCompte"));
		if(request.getParameter("tache").equals("save")) 
		{
			if(request.getParameter("typeCompte").equals("organisateur")) 
			{

				Organisateur o = new Organisateur(request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("mail"),request.getParameter("password"),request.getParameter("numero"),request.getParameter("voie"),request.getParameter("ville"),request.getParameter("cp"),request.getParameter("raisonSoc"));
				Context.getSingleton().getDaoClient().save(o);
			}
			else if(request.getParameter("typeCompte").equals("athlete"))
			{
				Athlete a = new Athlete(request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("mail"),request.getParameter("password"),request.getParameter("numero"),request.getParameter("voie"),request.getParameter("ville"),request.getParameter("cp"),LocalDate.parse(request.getParameter("dateNaissance")));
				Context.getSingleton().getDaoClient().save(a);
			}
			else if(request.getParameter("typeCompte").equals("spectateur"))
			{
				Spectateur s = new Spectateur(request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("mail"),request.getParameter("password"),request.getParameter("numero"),request.getParameter("voie"),request.getParameter("ville"),request.getParameter("cp"),LocalDate.parse(request.getParameter("dateNaissance")));
				Context.getSingleton().getDaoClient().save(s);
			}
			else if(request.getParameter("typeCompte").equals("journaliste"))
			{
				Journaliste j = new Journaliste(request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("mail"),request.getParameter("password"),request.getParameter("numero"),request.getParameter("voie"),request.getParameter("ville"),request.getParameter("cp"),request.getParameter("entreprise"));
				Context.getSingleton().getDaoClient().save(j);
			}
			
		
				response.sendRedirect("home");
		
			
			
		}

		else if(request.getParameter("tache").equals("update")) 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			int version = Integer.parseInt(request.getParameter("version"));
			
			if(request.getClass().getSimpleName().equals("Organisateur")) 
			{
				Organisateur c = new Organisateur(id,request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("mail"),request.getParameter("password"),request.getParameter("numero"),request.getParameter("voie"),request.getParameter("ville"),request.getParameter("cp"),request.getParameter("raisonSoc"));
				c.setVersion(version);
				Context.getSingleton().getDaoClient().save(c);
			}
			else if(request.getClass().getSimpleName().equals("Athlete")) 
			{
				Athlete a = new Athlete(id,request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("mail"),request.getParameter("password"),request.getParameter("numero"),request.getParameter("voie"),request.getParameter("ville"),request.getParameter("cp"),LocalDate.parse(request.getParameter("dateNaissance")));
				a.setVersion(version);
				Context.getSingleton().getDaoClient().save(a);
			}
			else if(request.getClass().getSimpleName().equals("Spectateur")) 
			{
				Spectateur s = new Spectateur(id,request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("mail"),request.getParameter("password"),request.getParameter("numero"),request.getParameter("voie"),request.getParameter("ville"),request.getParameter("cp"),LocalDate.parse(request.getParameter("dateNaissance")));
				s.setVersion(version);
				Context.getSingleton().getDaoClient().save(s);
			}
			else if(request.getClass().getSimpleName().equals("Spectateur")) 
			{
				Journaliste j = new Journaliste(id,request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("mail"),request.getParameter("password"),request.getParameter("numero"),request.getParameter("voie"),request.getParameter("ville"),request.getParameter("cp"),request.getParameter("entreprise"));
				j.setVersion(version);
				Context.getSingleton().getDaoClient().save(j);
			}
			
			
			response.sendRedirect("client");
		}

		else if(request.getParameter("tache").equals("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Context.getSingleton().getDaoClient().delete(id);
			response.sendRedirect("client");
		}

		


	}

}
