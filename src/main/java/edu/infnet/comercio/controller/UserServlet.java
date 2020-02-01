package edu.infnet.comercio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.cj.util.StringUtils;

import edu.infnet.comercio.negocio.modelo.Usuario;
import edu.infnet.comercio.negocio.servico.UsuarioService;

@WebServlet(urlPatterns = { "/UserSrv" })
public class UserServlet extends HttpServlet {// para adicionar o serialVersion ctrl+1

	private static Logger logger = LogManager.getLogger(UserServlet.class);

	private UsuarioService service;

	public UserServlet() {
		this.service = new UsuarioService();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		logger.debug("Entrando no doPost");

		String login = (String) req.getParameter("login");
		String senha = (String) req.getParameter("senha");
		String action = (String) req.getParameter("action");

		// string nunca vai ser null
		if ("new".equals(action)) {
			// TODO VALIDAR VALORES
			if (StringUtils.isEmptyOrWhitespaceOnly(login)) {
			}
			// TODO CONVERTER OS VALORES(TUDO QUE VEM DA PÁGINA É STRING) CONVERSÃO SEMPRE É
			// FEITA NO CONTROLADOR
			// TODO APLICAR AO MODELO (FAZER O SET NO OBJETO QUE SERÁ UTILIZADO)

			// atalho..ao fim do ) ctrl+1+enter
			Usuario usuario = new Usuario(login, senha);
			// TODO EXECUTAR LOGICA DE NEGOCIO

			service.save(usuario);
		} else {
			if (service.validarUsuario(login, senha)) {
				req.getSession().setAttribute("user", login);
			}else {
				req.setAttribute("error", "Login ou senha inválidos!");
			}

		}
//		System.out.println(" O login foi " + login);
//		System.out.println(" A senha foi " + senha);
		req.getRequestDispatcher("pages/home.jsp").forward(req, resp);
		// incluir caso de o login não funcionar
	}

}
