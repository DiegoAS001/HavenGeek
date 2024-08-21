package edu.ifsp.dwi.web.jogo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifsp.dwi.modelo.Jogo;
import edu.ifsp.dwi.persistencia.JogoDAO;
import edu.ifsp.dwi.web.Command;
import edu.ifsp.dwi.web.templates.Template;

public class EditarJogo implements Command {
	
       
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Jogo jogo = null;

		if (request.getParameter("id") == null) {
			jogo = new Jogo();			
		} else {
			int id = Integer.parseInt(request.getParameter("id"));
			JogoDAO dao = new JogoDAO();
			jogo = dao.buscarPeloId(id);
		}
		
		request.setAttribute("jogo", jogo);
		Template.render("jogo/editarJogo", request, response);		
	}
}
