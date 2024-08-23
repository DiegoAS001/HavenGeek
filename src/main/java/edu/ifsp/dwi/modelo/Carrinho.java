package edu.ifsp.dwi.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carrinho extends Entity {
	
	private List<Jogo> jogos = new ArrayList<Jogo>();
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
	
	public double valorTotalCarrinho() {
		double total = 0;
		
		for(Jogo jogo : jogos) {
			total += jogo.getPreco();
		}
		
		return total;
	}
	
	public boolean isVazio() {
		return jogos.isEmpty();
	}
	
	public void esvaziarCarrinho() {
		jogos = new ArrayList<Jogo>();
	}
}
