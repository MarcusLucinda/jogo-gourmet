package com.lucinda.arvore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Arquivos {
	
	/**
	 * Grava a �rvore bin�ria em um arquivo de texto usando preorder e inorder transversal
	 * @param arvore	-	�rvore a ser gravada
	 */
	public static void escreverArvore(BinaryTree arvore){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("itens_gourmet.txt"));
			List<String> preorder = arvore.salvarPreorder(arvore.getRaiz());
			List<String> inorder = arvore.salvarInorder(arvore.getRaiz());
			
			for (String elemento : preorder) {
				writer.write(elemento + ',');
			}
			writer.write("\r\n");
			
			for (String elemento : inorder) {
				writer.write(elemento + ',');
			}
			writer.close();
		} catch (Exception e) {
			System.exit(1);
		}
		
	}
	
	
	/**
	 * Realiza a leitura de um arquivo de texto para a montagem da �rvore
	 * @return	-	retorna a �rvore montada ap�s chamar a fun��o montarArvore da classe BinaryTree
	 * @throws IOException
	 */
	public static BinaryTree lerArvore() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("itens_gourmet.txt"));
		List<String> preorder = Arrays.asList(reader.readLine().split(","));
		List<String> inorder = Arrays.asList(reader.readLine().split(","));
		reader.close();
		return BinaryTree.montarArvore(inorder, preorder);
	}
}
