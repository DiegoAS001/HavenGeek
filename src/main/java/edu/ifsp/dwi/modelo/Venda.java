package edu.ifsp.dwi.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Venda extends Entity {
	private List<Carrinho> vendas = new ArrayList<>();

	public List<Carrinho> getCarrinho() {
		return Collections.unmodifiableList(vendas);
	}
}
