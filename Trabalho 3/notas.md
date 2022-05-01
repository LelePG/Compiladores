* Fazer o analisador sintático
* O trabalho anterior foi só reconhecer os tokens, nesse eu tenho que verificar se os tokens que vão aparecer fazem sentido, ou seja, o que eu tenho que fazer 
* as regras que podem ser derivadas em outras coisas vão virra funções pro analizados sintático e as regras que vão ter só os terminais da linguagem vão ser especificados como os terminais da linguagem
* Precisa adicionar o tipo float e void
* Aquela baita regra que tinha o nome do elemento e um println é onde eu vou rer que deletar e colocar as informações necessárias pra que o analisador entenda se o código que ele tá lendo faz sentido ou não. 
* Eliminar a recursão a esquerda: pega o terminal da regra, na parte que não tem recursão e depois dele concatena uma segunda regra que vai ter o resto da regra original

Pra rodar:
~~~
javacc Lugosi.jj
javac *.java
java Lugosi ARQUIVO-DE-ENTRADA
~~~