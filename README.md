## Projeto de Programas: Nave Espacial

1) Usar uma matriz (10X10) para implementar o espaço;
2) Criar uma nave inimiga e posicionar de forma randômica a nave inimiga na matrix. Para isso obter a linha e coluna de forma randômica para posicionar a nave inimiga em uma determinada célula da matriz
3) Cria a nave do jogador e posicionar a nave do jogador em uma determinada célula da matrix. O jogador poder movimentar a sua nave pelo espaço, ou seja, posicionar a sua nave em uma determina célula da matriz por meio de coordenadas (linha e coluna) fornecida pelo jogador ao digitar uma determinado  comando (letra, por exemplo) que moverá a nave, por exemplo, para esquerda ou direita. 
4) A nave do jogador tem 3 vidas. Se houver uma colisão entre a nave inimiga e a nave do jogador a mesma deverá perder uma vida. A colisão pode ser obtida quando ocorre a posição sorteada da nave inimiga coincide com a posição atual da nave do jogador.
5) A nave do jogador pode atingir com um míssil uma nave inimiga. Para isso, o jogador poderá digita um determinado comando (letra, por exemplo) para o míssil seja disparado, ou seja, o míssil seja posicionado em determina célula do espaço visando atingir a nave inimiga. O míssil atinge a nave inimiga quando a posição do míssil coincide com a posição da nave inimiga.
6) A nave inimiga começa o jogo com 100% de energia e vai reduzindo 10% de energia conforme é atingida por um míssil da nave do jogador;
7) O Jogo tem como base o emprego de loop que ficará aguardando os comandos do jogador para mover sua nave, atirar e posicionar a nave inimiga;
8) As classes do programa devem ser implementadas de forma encapsulada;
9) O projeto de programa deverá ser desenvolvido em dupla ou em trio. 
10) O projeto de programa deverá ser exportado e enviado para o professor por meio dessa atividade.


## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies
- `utils`: the folder to maintain utils resources

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
