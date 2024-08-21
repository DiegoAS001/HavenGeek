package edu.ifsp.dwi.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
<<<<<<< HEAD
import java.sql.SQLException;
=======
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
>>>>>>> 3968309 (Criando a classe CarrinhoDAO, ListarCarrinho, CarrinhoController, listarCarrinho.html (falta terminar o mapearlinha do CarrinhoDAO))

import edu.ifsp.dwi.modelo.Acessorio;
import edu.ifsp.dwi.modelo.Carrinho;
import edu.ifsp.dwi.modelo.Jogo;

public class CarrinhoDAO {
	
	public Carrinho save(Carrinho carrinho) {
        try (Connection conn = DatabaseConnector.connect()) {
            try {

                // Deletar itens existentes do carrinho
                PreparedStatement ps = conn.prepareStatement("DELETE FROM CARRINHO WHERE ID_CLIENTE = ?;");
                ps.setInt(1, carrinho.getCliente().getId());
                ps.executeUpdate();

                // Inserir itens do carrinho
                ps = conn.prepareStatement("INSERT INTO CARRINHO (ID_CLIENTE, ID_JOGO, ID_ACESSORIO) VALUES (?, ?, ?);");
                for (Jogo jogo : carrinho.getJogos()) {
                    ps.setInt(1, carrinho.getCliente().getId());
                    ps.setInt(2, jogo.getId());
                    ps.executeUpdate();
                }
                for (Acessorio acessorio : carrinho.getAcessorios()) {
                    ps.setInt(1, carrinho.getCliente().getId());
                    ps.setInt(2, acessorio.getId());
                    ps.executeUpdate();
                }

               
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
        	 e.printStackTrace();
        }

        return carrinho;
    }
<<<<<<< HEAD
=======
	
	public List<Carrinho> listarTodos(){
		List<Carrinho> carrinhos = new ArrayList<Carrinho>();
		
		try (Connection conn = DatabaseConnector.connect()) {
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT id, id_cliente, id_jogo, id_acesorio FROM carrinho;");
			
			while(rs.next()) {
				Carrinho carrinho = mapearLinha(rs);
				carrinhos.add(carrinho);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return carrinhos;
	}
	
	
	private Carrinho mapearLinha(ResultSet rs) throws SQLException {
		Carrinho carrinho = new Carrinho();
		
		carrinho.setId(rs.getInt("id"));
		
		return carrinho;		
	}	
	
>>>>>>> 3968309 (Criando a classe CarrinhoDAO, ListarCarrinho, CarrinhoController, listarCarrinho.html (falta terminar o mapearlinha do CarrinhoDAO))
}
