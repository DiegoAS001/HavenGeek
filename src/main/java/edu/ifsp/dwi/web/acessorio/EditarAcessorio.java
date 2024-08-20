package edu.ifsp.dwi.web.acessorio;

<<<<<<< HEAD
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
=======
>>>>>>> b145587 (Resolveno o erro no JogoController)
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifsp.dwi.modelo.Acessorio;
import edu.ifsp.dwi.persistencia.AcessorioDAO;
import edu.ifsp.dwi.web.Command;
import edu.ifsp.dwi.web.templates.Template;

public class EditarAcessorio implements Command {
	
       
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Acessorio acessorio = null;

		if (request.getParameter("id") == null) {
			acessorio = new Acessorio();			
		} else {
			int id = Integer.parseInt(request.getParameter("id"));
			AcessorioDAO dao = new AcessorioDAO();
			acessorio = dao.buscarPeloId(id);
		}
		
		request.setAttribute("acessorio", acessorio);
		Template.render("acessorio/editarAcessorio", request, response);		
	}

}
