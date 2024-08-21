package edu.ifsp.dwi.web.jogo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifsp.dwi.modelo.Jogo;
import edu.ifsp.dwi.persistencia.JogoDAO;
import edu.ifsp.dwi.web.Command;
import edu.ifsp.dwi.web.templates.Template;


public class ListarJogo implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JogoDAO dao = new JogoDAO();
		List<Jogo> jogos = dao.listarTodos();
		request.setAttribute("jogos", jogos);
		Template.render("jogo/listarJogo", request, response);		
	}


}


