package com.lucinda.executavel;

import com.lucinda.arvore.Arquivos;
import com.lucinda.arvore.BinaryTree;
import com.lucinda.gourmet.JogoGourmet;


public class Exec {

	public static void main(String[] args) {
		BinaryTree arvore;
		JogoGourmet.mensagem("Pense em um prato que goste");
		arvore = JogoGourmet.carregarArvore();
		do {
			JogoGourmet.iniciar(arvore);
		}while(JogoGourmet.simOuNao("Jogar novamente?"));
		Arquivos.escreverArvore(arvore);
		System.exit(0);
	}


}
