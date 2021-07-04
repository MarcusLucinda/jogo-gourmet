package com.lucinda.arvore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class BinaryTree {

	private Node raiz;
	List<String> preorder = new ArrayList<String>();
	List<String> inorder = new ArrayList<String>();
	private static HashMap<String, Integer> nodeMap = new HashMap<>();
	private static Integer indice = 0;

	/**
	 * Cria uma árvore
	 * @param node	-	nó raiz
	 */
	public BinaryTree(Node node) {
		this.raiz = node;
	}
	
	
	public Node getRaiz() {
		return raiz;
	}
	
	
	public void setRaiz(Node raiz) {
		this.raiz = raiz;
	}
	
	
	/**
	 * Salva os elementos dos nós da árvore no modo inorder
	 * @param node	-	nó raíz da árvore
	 * @return	-	retorna a lista com os elementos inorder
	 */
	public List<String> salvarInorder(Node node) {
		if(node.getEsquerda() != null) {
			salvarInorder(node.getEsquerda());
		}
		this.inorder.add(node.getElemento());
		if(node.getDireita() != null) {
			salvarInorder(node.getDireita());
		}
		return this.inorder;
	}
	
	
	/**
	 * Salva os elementos dos nós da árvore no modo preorder
	 * @param node	-	nó raíz da árvore
	 * @return	-	retorna a lista com os elementos preorder
	 */
	public List<String> salvarPreorder(Node node) {
		this.preorder.add(node.getElemento());
		if(node.getEsquerda() != null) {
			salvarPreorder(node.getEsquerda());
		}
		if(node.getDireita() != null) {
			salvarPreorder(node.getDireita());
		}
		return this.preorder;
	}
	
	
	/**
	 * Inicia a montagem da árvore a partir dos elementos inorder e preorder
	 * @param inorder	-	lista com os elementos em modo inorder
	 * @param preorder	-	lista com os elementos em modo preorder
	 * @return	-	árvore binária montada
	 */
	protected static BinaryTree montarArvore(List<String> inorder, List<String> preorder) {
		for(int i = 0; i < inorder.size(); i++) {
			nodeMap.put(inorder.get(i), i);
		}
		Node raiz = popularArvore(inorder, preorder, 0, (inorder.size() - 1));
		BinaryTree arvore = new BinaryTree(raiz);
		return arvore;
	}
	
	
	/**
	 * Médodo chamado por montarArvore que vai popular a árvore com os nós
	 * @param inorder	-	lista com os elementos em modo inorder
	 * @param preorder	-	lista com os elementos em modo preorder
	 * @param inicio	-	contador de inicio elementos inorder
	 * @param fim	-	contador de fim de elementos inorder
	 * @return
	 */
	private static Node popularArvore(List<String> inorder, List<String> preorder, int inicio, int fim) {
		if(inicio > fim) {
			return null;
		}
		String elementoAtual = preorder.get(indice++);
		Node node = new Node(elementoAtual, null, null);
		
		if(inicio == fim) {
			return node;
		}
		
		int inorderIndex = nodeMap.get(node.getElemento());
		
		node.setEsquerda(popularArvore(inorder, preorder, inicio, inorderIndex - 1));
		node.setDireita(popularArvore(inorder, preorder, inorderIndex + 1, fim));
		return node;
	}




}