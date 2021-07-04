package com.lucinda.executavel;

import com.lucinda.arvore.Arquivos;
import com.lucinda.jogo.JogoGourmet;

public class Exec {

	public static void main(String[] args) {
		JogoGourmet jogo = new JogoGourmet();
		jogo.mensagem("Pense em um prato que goste");
		do {
			jogo.iniciar();
		}while(jogo.simOuNao("Jogar novamente?"));
		Arquivos.escreverArvore(jogo.getArvore());
		System.exit(0);
	}

}
