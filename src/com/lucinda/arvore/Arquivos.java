package com.lucinda.arvore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

public class Arquivos {
	
	/**
	 * Grava a árvore binária em um arquivo de texto usando preorder e inorder transversal
	 * @param arvore	-	árvore a ser gravada
	 */
	public static void escreverArvore(BinaryTree arvore){
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("itens_gourmet.txt"), "UTF-8"));
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
	 * Realiza a leitura de um arquivo de texto para a montagem da árvore
	 * @return	-	retorna a árvore montada após chamar a função montarArvore da classe BinaryTree
	 * @throws IOException
	 */
	public static BinaryTree lerArvore() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("itens_gourmet.txt"), "UTF-8"));
		List<String> preorder = Arrays.asList(reader.readLine().split(","));
		List<String> inorder = Arrays.asList(reader.readLine().split(","));
		reader.close();
		return BinaryTree.montarArvore(inorder, preorder);
	}
}
