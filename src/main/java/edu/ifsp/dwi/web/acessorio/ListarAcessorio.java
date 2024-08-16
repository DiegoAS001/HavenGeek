package edu.ifsp.dwi.web.acessorio;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifsp.dwi.modelo.Acessorio;
import edu.ifsp.dwi.persistencia.AcessorioDAO;
import edu.ifsp.dwi.web.templates.Template;
import edu.ifsp.dwi.web.Command;


public class ListarAcessorio implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AcessorioDAO dao = new AcessorioDAO();
		List<Acessorio> acessorios = dao.listarTodos();
		request.setAttribute("acessorios", acessorios);
		Template.render("acessorio/listarAcessorio", request, response);		
	}

}
