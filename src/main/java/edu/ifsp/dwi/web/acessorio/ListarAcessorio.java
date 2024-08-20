package edu.ifsp.dwi.web.acessorio;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifsp.dwi.modelo.Acessorio;
import edu.ifsp.dwi.persistencia.AcessorioDAO;
import edu.ifsp.dwi.web.Command;
import edu.ifsp.dwi.web.templates.Template;


public class ListarAcessorio implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AcessorioDAO dao = new AcessorioDAO();
		List<Acessorio> acessorios = dao.listarTodos();
		request.setAttribute("acessorios", acessorios);
		Template.render("acessorio/listarAcessorio", request, response);		
	}

}
