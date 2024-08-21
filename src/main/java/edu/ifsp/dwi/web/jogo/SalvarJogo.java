package edu.ifsp.dwi.web.jogo;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifsp.dwi.modelo.Jogo;
import edu.ifsp.dwi.persistencia.JogoDAO;
import edu.ifsp.dwi.web.Command;
import edu.ifsp.dwi.web.templates.Template;


public class SalvarJogo implements Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Jogo jogo = new Jogo();
		/*if (!validate(request)) {
			request.setAttribute("jogo", jogo);
			Template.render("jogo/editarJogo", request, response);
			return;
		}*/
				
		
		if (request.getParameter("id") != null) {
			jogo.setId(Integer.parseInt(request.getParameter("id")));
		}
		jogo.setNome(request.getParameter("nome"));
		jogo.setTipoMidia(request.getParameter("tipo_midia"));
		jogo.setPreco(Double.parseDouble(request.getParameter("preco")));
		jogo.setCategoria(request.getParameter("categoria"));
		jogo.setPlataforma(request.getParameter("plataforma"));
		
		JogoDAO dao = new JogoDAO();
		dao.salvar(jogo);
		response.sendRedirect("recuperar?id=" + jogo.getId());	
		
		//Template.render("jogo/listarJogo", request, response);	
	}
	
	private boolean validar(HttpServletRequest request) {
		boolean validacao = true;
		
		
		
		return validacao;
	}

}
