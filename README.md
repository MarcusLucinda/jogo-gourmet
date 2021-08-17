# Jogo Gourmet

## O Jogo

O jogo consiste no jogador pensar em alguma comida, então, o programa tentará adivinhar realizando algumas perguntas. 


## Funcionamento

O jogo é estruturado em uma árvore binária, onde os nós pais são perguntas e as folhas são os palpites do prato. Quando o jogador responde "sim" para uma pergunta o 
caminho da esquerda é tomado, e quando responde "não" toma-se o caminho da direita. Cada objeto de nó guarda as informações de seus filhos à esquerda e à direita.
Além disso, a árvore é armazenada em um arquivo de texto para que seja carregada posteriormente

![image](https://user-images.githubusercontent.com/51497214/124401081-c8e1a600-dcfd-11eb-911c-9887cceafa83.png)

Se o programa errar o palpite, será perguntado ao jogador em que prato ele está pensando e uma pergunta que diferencie o dito prato e o palpite do programa. O nó em que estava 
o palpite é substituído por um nó com a pergunta inserida pelo jogador, e as novas folhas serão a resposta certa na esquerda e o palpite errado na direita.

![image](https://user-images.githubusercontent.com/51497214/124400759-4b1c9b00-dcfb-11eb-864d-4e0f0da8759a.png)


## Estrutura

O jogo segue o seguinte fluxo:
![image](https://user-images.githubusercontent.com/51497214/129726856-7dd808f0-4728-4052-a7bb-8b9233595836.png)

Para que a árvore possa ser carregada posteriormente, ela é salva de duas formas. A primeira é a inorder transversal, ou varredura infixa, que percorre a árvore no sentido esquerda-raíz-direita.
![image](https://user-images.githubusercontent.com/51497214/129727450-d89a549a-f2f6-4c36-9635-d782b2f7fac2.png)

A segunda forma é a preorder transversal, ou varredura prefixa, que percorre a árvore no sentido raíz-esquerda-direita.
![image](https://user-images.githubusercontent.com/51497214/129727921-e36ac104-953e-412c-a832-d13a987766a6.png)


Para remontar a árvore, sabemos que o primeiro elemento da varredura prefixa é a raíz, e ao buscarmos esse elemento na varredura infixa obtemos quais estão à esquerda e quais à direita, então, utilizando este método recursivamente podemos reconstruir a árvore.
![image](https://user-images.githubusercontent.com/51497214/129728671-11b2d239-6606-4ca7-b8be-4eaaf2aa5512.png)
