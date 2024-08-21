package edu.ifsp.dwi.web.carrinho;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifsp.dwi.modelo.Carrinho;
import edu.ifsp.dwi.persistencia.CarrinhoDAO;
import edu.ifsp.dwi.web.Command;
import edu.ifsp.dwi.web.templates.Template;

/**
 * Servlet implementation class ListarCarrinho
 */
@WebServlet("/ListarCarrinho")
public class ListarCarrinho implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CarrinhoDAO dao = new CarrinhoDAO();
		List<Carrinho> carrinhos = dao.listarTodos();
		request.setAttribute("carrinhos", carrinhos);
		Template.render("carrinho/listarCarrinho", request, response);		
	}

}
