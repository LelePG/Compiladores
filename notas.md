## Exercício 1
* Preciso transformar a leitura de tokens em Strings, mas pra fazer isso vou ficar com um monte de coisa que vai precisar ser refatorada pro construtor. Usar outro construtor com char que converte pra string.
* Depois que eu ler um número, preciso continuar lendo até achar outra coisa que não é um número e ai submeter o par de números como um "token", lembrar que depois que eu leio o token ele some (**olhar a aula sincrona da semana passada de novo**). 
* A leitura tá acontecendo com BufferedReader [documentação](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html)
* Vou precisar de uma variável pra acumular os novos números em formato string e uma variável pra ler eles em formato char porque o método read retorna só char.

## Exercício 2
* Primeiro de tudo, tenho que adicionar os símbolos no alfabeto da linguagem (anali. lexi.)
* fazer com que a linguagem saiba interpretar esses símbolos (arv.sinta.)
* preciso adicionar os simbolos no parser também ou eles não vão ser reconhecidos corretamente
* tem que adicionar na geração de código também porque senão não vai aparecer aquelas mensagens ali que deveriam aparecer. Tá funcionando (eu acho pq não deu nenhum erro), mas não aparece as mensagens.

## Exercício 3
* A chamada pro backend tá no arquivo compilador.
* Tenho que substituir o que o codeGen tá fazendo por um interpretador
* A estratégia é mudar o que tá acontecendo dentro dos ifs do codeGen, mas não posso tirar a recursão senão não vai dar pra percorrer a árvore.