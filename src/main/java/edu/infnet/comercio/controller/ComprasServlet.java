package edu.infnet.comercio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.infnet.comercio.negocio.dao.JpaDAO;
import edu.infnet.comercio.negocio.dao.ProdutoDAO;
import edu.infnet.comercio.negocio.dao.ProdutoJPADAO;
import edu.infnet.comercio.negocio.modelo.Produto;

@WebServlet(urlPatterns = { "/ComprasSrv" })
public class ComprasServlet extends HttpServlet {// para adicionar o serialVersion ctrl+1

	private ProdutoDAO dao;
	private JpaDAO jpadao;

	public ComprasServlet() {
		this.dao = new ProdutoDAO();
		this.jpadao = new ProdutoJPADAO();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Produto produto = new Produto("TV 4k", "televis�o samsung", 7999.69, "tv8k.jpg");

		//this.jpadao.save(produto);

		//List<Produto> produtos = dao.findAllProdutos();
		List<Produto> produtos = jpadao.findAll();
		req.setAttribute("lista_produto", produtos);
//fazer para casa a pagina de gestao de produto com a tabela usando bootstrap e o for each que foi usado na pagina de catalogo		

		req.getRequestDispatcher("pages/catalogo.jsp").forward(req, resp);

	}

}
