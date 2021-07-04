package com.lucinda.arvore;

public class Node {

	private String elemento;
	private Node esquerda;
	private Node direita;

	/**
	 * @param elemento	-	elemento do nó atual
	 * @param esquerda	-	nó filho à esquerda do atual
	 * @param direita	-	nó filho à direita do atual
	 */
	public Node(String elemento, Node esquerda, Node direita) {
		this.elemento = elemento;
		this.esquerda = esquerda;
		this.direita = direita;
	}
	
	/**
	 * Verifica se o nó atual é uma folha
	 * @return
	 * 		True, se o nó for uma folha
	 * 		False, se o nó não for uma folha
	 */
	public boolean isFolha() {
		return ((this.getEsquerda() == null) && (this.getDireita() == null));                                               
	}  


	/**
	 * @return	-	retorna o elemento do nó atual
	 */
	public String getElemento() {
		return elemento;
	}

	/**
	 * @param node	-	elemento a ser inserido no nó atual
	 */
	public void setElemento(String elemento) {
		this.elemento = elemento;
	}


	/**
	 * @return	-	retorna o filho à esquerda
	 */
	public Node getEsquerda() {
		return esquerda;
	}


	/**
	 * @param esquerda	-	node a ser inserido no filho à esquerda
	 */
	public void setEsquerda(Node esquerda) {
		this.esquerda = esquerda;
	}


	/**
	 * @return	-	retorna o filho à direita
	 */
	public Node getDireita() {
		return direita;
	}

	/**
	 * @param direita	-	node a ser inserido no filho à direita
	 */
	public void setDireita(Node direita) {
		this.direita = direita;
	}
	
}
