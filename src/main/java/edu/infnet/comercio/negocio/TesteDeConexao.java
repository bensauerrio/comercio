package edu.infnet.comercio.negocio;

import edu.infnet.comercio.negocio.dao.UsuarioDAO;
import edu.infnet.comercio.negocio.modelo.Usuario;

public class TesteDeConexao {
	
	public static void main(String[] args) {
		
//		Teste de Conexão
//		Mysql.Connection.getConnection();
		
		
		//Teste inserir usuario no banco
//		Usuario usuario = new Usuario();
//		usuario.setLogin("usuario");
//		usuario.setSenha("senha");
//		
//		UsuarioDAO dao = new UsuarioDAO();
//		dao.save(usuario);
		
		//Teste para achar usuario via login
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.getByLogin("admin");
		System.out.println(usuario);
	
	
	}
}
