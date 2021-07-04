package com.lucinda.arvore;

public class Node {

	private String elemento;
	private Node esquerda;
	private Node direita;

	/**
	 * @param elemento	-	elemento do n� atual
	 * @param esquerda	-	n� filho � esquerda do atual
	 * @param direita	-	n� filho � direita do atual
	 */
	public Node(String elemento, Node esquerda, Node direita) {
		this.elemento = elemento;
		this.esquerda = esquerda;
		this.direita = direita;
	}
	
	/**
	 * Verifica se o n� atual � uma folha
	 * @return
	 * 		True, se o n� for uma folha
	 * 		False, se o n� n�o for uma folha
	 */
	public boolean isFolha() {
		return ((this.getEsquerda() == null) && (this.getDireita() == null));                                               
	}  


	/**
	 * @return	-	retorna o elemento do n� atual
	 */
	public String getElemento() {
		return elemento;
	}

	/**
	 * @param node	-	elemento a ser inserido no n� atual
	 */
	public void setElemento(String elemento) {
		this.elemento = elemento;
	}


	/**
	 * @return	-	retorna o filho � esquerda
	 */
	public Node getEsquerda() {
		return esquerda;
	}


	/**
	 * @param esquerda	-	node a ser inserido no filho � esquerda
	 */
	public void setEsquerda(Node esquerda) {
		this.esquerda = esquerda;
	}


	/**
	 * @return	-	retorna o filho � direita
	 */
	public Node getDireita() {
		return direita;
	}

	/**
	 * @param direita	-	node a ser inserido no filho � direita
	 */
	public void setDireita(Node direita) {
		this.direita = direita;
	}
	
}
