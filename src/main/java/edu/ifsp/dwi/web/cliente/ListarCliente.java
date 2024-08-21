package edu.ifsp.dwi.web.cliente;

<<<<<<< HEAD
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifsp.dwi.web.templates.Template;

@WebServlet("/ListarCliente")
public class ListarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Template.render("cliente/listarCliente", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
=======
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifsp.dwi.modelo.Cliente;
import edu.ifsp.dwi.persistencia.ClienteDAO;
import edu.ifsp.dwi.web.Command;
import edu.ifsp.dwi.web.templates.Template;

@WebServlet("/ListarCliente")
public class ListarCliente implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ClienteDAO dao = new ClienteDAO();
		List<Cliente> clientes = dao.listarTodos();
		request.setAttribute("clientes", clientes);
		Template.render("cliente/listarCliente", request, response);		
>>>>>>> 3968309 (Criando a classe CarrinhoDAO, ListarCarrinho, CarrinhoController, listarCarrinho.html (falta terminar o mapearlinha do CarrinhoDAO))
	}

}
