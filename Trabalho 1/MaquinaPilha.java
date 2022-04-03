import java.io.*;
import java.util.Stack;

class MaquinaPilha {
      static Stack<Integer> pilha = new Stack(); //vai ser um atributo pra mim poder manipular ela diretamente em algumas funções.

  public static void main(String[] args) {
    try {
      BufferedReader buffRead = new BufferedReader(new FileReader(args[0]));
      String linha = "";
      while (true) {
        linha = buffRead.readLine(); //lê
        if(linha == null){ // verifica null
            break;
        }
        decideOQueFazer(linha);//o que fazer com a linha
      }
      buffRead.close();// depois que terminar de ler, fecha o leitor
    } catch (Exception e) {
      System.out.println("Erro:\n" + e);
    }
  }

  private static void decideOQueFazer(String linha){
      if(linha.startsWith("PUSH")){
          String numero = linha.split(" ")[1];
          pilha.push( new Integer(numero));//coloca o número na ílha
      } else if(linha.startsWith("PRINT")){
          Integer resultado = pilha.pop();
          System.out.println(resultado);//imprime
      } else{//vai entrar aqui nos casos das operações, e fora esses não tem mais nenhum previsto
          resolveOperacao(linha);
      }
  }

      private static void resolveOperacao(String operacao){
          Integer operador1 = pilha.pop();//o operador 1 é o tirado do topo, então o último adicionado
          Integer operador2 = pilha.pop();//o operador 2 é o mais antigo
            //System.out.println(operador2 +operacao+ operador2);//debug
        switch(operacao){//a operação é sempre um texto de uma palavra
            case "SUB":
                pilha.push(operador2-operador1);
                break;
            case "DIV":
                pilha.push(operador2/operador1);
                break;
            case "MULT":
                pilha.push(operador2*operador1);
                break;
            case "SUM":
                pilha.push(operador2+operador1);
                break;
        }
            //System.out.println(pilha.peek());//debug -> o que tem no topo da pilha depois de cada operação.
    }
}
