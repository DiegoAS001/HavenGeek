package edu.ifsp.dwi.web.jogo;
<<<<<<< HEAD

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifsp.dwi.modelo.Acessorio;
import edu.ifsp.dwi.modelo.Jogo;
import edu.ifsp.dwi.persistencia.AcessorioDAO;
import edu.ifsp.dwi.persistencia.JogoDAO;
import edu.ifsp.dwi.web.templates.Template;
import edu.ifsp.dwi.web.Command;
=======
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifsp.dwi.modelo.Jogo;
import edu.ifsp.dwi.persistencia.JogoDAO;
import edu.ifsp.dwi.web.Command;
import edu.ifsp.dwi.web.templates.Template;
>>>>>>> b145587 (Resolveno o erro no JogoController)


public class ListarJogo implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JogoDAO dao = new JogoDAO();
		List<Jogo> jogos = dao.listarTodos();
		request.setAttribute("jogos", jogos);
		Template.render("jogo/listarJogo", request, response);		
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> b145587 (Resolveno o erro no JogoController)
