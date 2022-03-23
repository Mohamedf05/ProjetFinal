package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CompetitionSport.model.Adresse;
import CompetitionSport.model.Discipline;
import CompetitionSport.model.Terrain;
import CompetitionSport.model.TypeTerrain;
import util.Context;

@WebServlet("/terrain")
public class TerrainController extends HttpServlet {

	//FindById + FindAll()
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//findAll()
		if(request.getParameter("id")==null) 
		{
			List<Terrain> terrains = Context.getSingleton().getDaoTerrain().findAll();
			request.setAttribute("listeTerrain", terrains );
			getServletContext().getRequestDispatcher("/WEB-INF/terrains.jsp").forward(request, response);
		}
		//findById
		else 
		{
			
			int id = Integer.parseInt(request.getParameter("id"));
			Terrain t = Context.getSingleton().getDaoTerrain().findById(id);
			request.setAttribute("terrain", t);
			getServletContext().getRequestDispatcher("/WEB-INF/updateTerrain.jsp").forward(request, response);
			
		}

		

	}


	//Update / Insert / Delete
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("tache").equals("save")) 
		{
		
			int id = Integer.parseInt(request.getParameter("id"));
			int version = Integer.parseInt(request.getParameter("version"));
			Adresse adresse = new Adresse(request.getParameter("numero"),request.getParameter("voie"),request.getParameter("ville"),request.getParameter("cp"));
			Terrain t = new Terrain(id,request.getParameter("nom"), adresse, TypeTerrain.valueOf(request.getParameter("terrains")));
			t.setVersion(version);
			Context.getSingleton().getDaoTerrain().save(t);
		}
		else if(request.getParameter("tache").equals("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Context.getSingleton().getDaoTerrain().delete(id);
		}

		response.sendRedirect("terrain");
	}

}
