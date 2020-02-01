package edu.infnet.comercio.negocio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//ctrl shift o organiza os imports
import edu.infnet.comercio.negocio.MysqlConnection;
import edu.infnet.comercio.negocio.modelo.Produto;

public class ProdutoDAO {
	
	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	private Logger logger = LogManager.getLogger(ProdutoDAO.class);
	
	public ProdutoDAO() {
		this.con = MysqlConnection.getConnection();
		//Trazer edi��o do produto para poder inser e editar produto pela p�gina 
	}
	public List<Produto> findAllProdutos() {
		String sql = "select * from produto";
		List<Produto> lista = new ArrayList<Produto>();
		
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Produto prod = new Produto();
				prod.setId(rs.getInt("id"));
				prod.setDescricao(rs.getString("descricao"));
				prod.setFoto(rs.getString("foto"));
				prod.setNome(rs.getString("nome"));
				prod.setPreco(rs.getDouble("preco"));
				lista.add(prod);
			}
			return lista;
			
		} catch (Exception e) {
			logger.error("Erro ao recuperar produtos", e);
		}
		
		return null;	
	}
}
