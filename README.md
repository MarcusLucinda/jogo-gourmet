# Jogo Gourmet

## O Jogo

O jogo consiste no jogador pensar em alguma comida, então, o programa tentará adivinhar realizando algumas perguntas. 


## Funcionamento

O jogo é estruturado em uma árvore binária, onde os nós pais são perguntas e as folhas são os palpites do prato. Quando o jogador responde "sim" para uma pergunta o 
caminho da esquerda é tomado, e quando responde "não" toma-se o caminho da direita. Cada objeto de nó guarda as informações de seus filhos à esquerda e à direita.

![image](https://user-images.githubusercontent.com/51497214/124401081-c8e1a600-dcfd-11eb-911c-9887cceafa83.png)

Se o programa errar o palpite, será perguntado ao jogador em que prato ele está pensando e uma pergunta que diferencie o dito prato e o palpite do programa. O nó em que estava 
o palpite é substituído por um nó com a pergunta inserida pelo jogador, e as novas folhas serão a resposta certa na esquerda e o palpite errado na direita.

![image](https://user-images.githubusercontent.com/51497214/124400759-4b1c9b00-dcfb-11eb-864d-4e0f0da8759a.png)

