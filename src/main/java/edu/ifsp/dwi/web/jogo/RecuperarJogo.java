package edu.ifsp.dwi.web.jogo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifsp.dwi.modelo.Jogo;
import edu.ifsp.dwi.persistencia.JogoDAO;
import edu.ifsp.dwi.web.Command;
import edu.ifsp.dwi.web.templates.Template;


public class RecuperarJogo implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id = Integer.parseInt(request.getParameter("id"));
		JogoDAO dao = new JogoDAO();
		Jogo jogo = dao.buscarPeloId(id);
		request.setAttribute("jogo", jogo);
		Template.render("jogo/detalharJogo", request, response);	
		
	}

}
