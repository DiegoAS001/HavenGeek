package edu.ifsp.dwi.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
