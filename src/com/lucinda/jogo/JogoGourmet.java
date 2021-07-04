package com.lucinda.jogo;

import java.io.IOException;
import javax.swing.JOptionPane;
import com.lucinda.arvore.Arquivos;
import com.lucinda.arvore.BinaryTree;
import com.lucinda.arvore.Node;

public class JogoGourmet {
	
	private BinaryTree arvore;

	/**
	 * Carrega árvore binária de um arquivo existente, se não existir cria uma padrão.
	 * @return	-	árvore com as perguntas e respostas a serem utilizadas no jogo
	 */
	public JogoGourmet() {
		try {
			// busca por arquivo com elementos para construir arvore
			this.arvore = Arquivos.lerArvore();
		} catch (IOException e) {
			// cria arvore caso arquivo de elementos não seja encontrado
			String perguntaRaiz = "É doce?";
			String perguntaEsquerda = "É fruta?";
			String perguntaDireita = "É massa?";
			String banana = "Banana";
			String churros = "Churros";
			String lasanha = "Lasanha";
			String frango = "Frango";

			Node raiz = new Node(perguntaRaiz, null, null);

			Node filhaEsquerda = new Node(perguntaEsquerda, null, null);
			filhaEsquerda.setEsquerda(new Node(banana, null, null));
			filhaEsquerda.setDireita(new Node(churros, null, null));
			raiz.setEsquerda(filhaEsquerda);

			Node filhaDireita = new Node(perguntaDireita, null, null);
			filhaDireita.setEsquerda(new Node(lasanha, null, null));
			filhaDireita.setDireita(new Node(frango, null, null));
			raiz.setDireita(filhaDireita);

			this.arvore = new BinaryTree(raiz);
		}
	}
	
	
	public BinaryTree getArvore() {
		return arvore;
	}


	/**
	 * Dá início ao jogo após o carregamento das perguntas e respostas
	 * @param arvore	-	árvore binária com as perguntas e respostas
	 */
	public void iniciar() {
		Node nodeAtual = this.arvore.getRaiz();

		while(!nodeAtual.isFolha()){
			if(simOuNao(nodeAtual.getElemento())) {
				nodeAtual = nodeAtual.getEsquerda( );
			}else {
				nodeAtual = nodeAtual.getDireita( );
			}
		}

		if(!simOuNao("Você pensou em " + nodeAtual.getElemento() + "?")) {
			novoPrato(nodeAtual);
		}else {
			mensagem("Acertei! :)");
		}
	}


	/**
	 * Pergunta ao jogador qual prato ele pensou após um palpite errado, também adiciona uma
	 * 	pergunta que diferencia o palpite da resposta certa.
	 * @param current	-	nó atual que contém o palpite errado
	 */
	public void novoPrato(Node nodeAtual) {
		String palpite;
		String respostaCerta;
		String novaPergunta;

		//adiciona uma nova pergunta e o prato
		palpite = nodeAtual.getElemento();
		respostaCerta = perguntar("Desisto, em qual prato você pensou?");
		novaPergunta = "É " + perguntar(respostaCerta + " é ________ mas " + palpite + " não");

		nodeAtual.setElemento(novaPergunta);
		nodeAtual.setEsquerda(new Node(respostaCerta, null, null));
		nodeAtual.setDireita(new Node(palpite, null, null));
	}


	/**
	 * Exibe painel padrão para perguntas com resposta sim ou não
	 * @param pergunta	-	pergunta com resposta sim ou não
	 * @return	-	true se a resposta for sim, e false se for não
	 */
	public boolean simOuNao(String pergunta) {
		if(JOptionPane.showConfirmDialog(null, pergunta, "Jogo Gourmet", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}

	/**
	 * Exibe painel com pergunta em que o jogador precisa digitar a resposta
	 * @param pergunta	-	pergunta ao jogador
	 * @return	-	a resposta inserida pelo jogador
	 */
	public String perguntar(String pergunta) {
		String resposta = "";
		while(resposta.equals("")) {
			resposta = JOptionPane.showInputDialog(pergunta);
			if(resposta == null) {
				System.exit(0);
			}
		}
		return resposta;
	}


	/**
	 * Exibe painel de mensagem
	 * @param msg	-	mensagem a ser exibita
	 */
	public void mensagem(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Jogo Gourmet", JOptionPane.INFORMATION_MESSAGE);
	}

}
