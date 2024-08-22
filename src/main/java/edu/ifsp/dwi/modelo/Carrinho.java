package edu.ifsp.dwi.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carrinho extends Entity {
	
	/*LEMBRAR DE IMPLEMENTAR 
	 * 
	 * REMOVER ITEM
	 * ESVAZIAR CARRINHO
	 * VALOR TOTAL
	 * */
	
	
	private List<Jogo> jogos = new ArrayList<>();
	private Cliente cliente;
	
	public List<Jogo> getJogos() {
		return Collections.unmodifiableList(jogos);
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void adicionarJogo(Jogo jogo) {
		jogos.add(jogo);
	}
	
	public int tamanhoCarrinho() {
		return jogos.size();
	}
		
}
