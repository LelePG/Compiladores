/* Generated By:JavaCC: Do not edit this line. Lugosi.java */
import java.io.*;
import java.util.ArrayList;


class TIPO{
  String tipo;
  public TIPO(String tipo){
    this.tipo=tipo;
  }
public String toString(){
  if(this.tipo.equals("bool")){
    return "boolean";
  }
    return tipo;
  }

}

class OPERADOR{
  String op;
  public OPERADOR(String op){
    this.op=op;
  }
public String toString(){
    return op;
  }

}

class VARDECL{
        ArrayList<TIPO> tipos;
        ArrayList<String> ids;

public VARDECL(ArrayList<TIPO> tipos, ArrayList<String> ids){
    this.tipos = tipos;
    this.ids = ids;
  }
public String toString(){
  String acumulador = "";
  for(int i = 0; i< this.tipos.size(); i++){
    acumulador+= this.tipos.get(i)+ " " + this.ids.get(i) +";\u005cn";
  }
    return acumulador;
  }
}

class LISTAARG{
        ArrayList<TIPO> tipos;
        ArrayList<String> ids;

public LISTAARG(ArrayList<TIPO> tipos, ArrayList<String> ids){
    this.tipos = tipos;
    this.ids = ids;
  }
public String toString(){
  String acumulador = "";
  for(int i = 0; i< this.tipos.size(); i++){
    acumulador+= this.tipos.get(i)+ " " + this.ids.get(i);
  if(i< this.tipos.size()-1){
    acumulador+=",";
  }
  }
    return acumulador;
  }
}



        class FUNC{
    TIPO tipo;
  String id;
  LISTAARG argumentos;
  VARDECL variaveis;
  SEQCOMANDOS seqcomandos;

public FUNC(TIPO tipo,String id, LISTAARG argumentos, VARDECL variaveis, SEQCOMANDOS seqcomandos)
{
    this.tipo = tipo;
    this.id = id;
    this.argumentos=argumentos;
    this.variaveis = variaveis;
    this.seqcomandos = seqcomandos;
  }
public String toString(){
  String acumulador = this.tipo.toString() + " " + this.id + "(" + this.argumentos.toString()+"){\u005cn" ;
  acumulador+=variaveis.toString();
  acumulador+=seqcomandos.toString();
  acumulador+="}\u005cn";
  return acumulador;

}
}

class IMPRIMEFUNCS{
        ArrayList<FUNC> funcs;

public IMPRIMEFUNCS(ArrayList<FUNC> funcs){
    this.funcs = funcs;
  }
public String toString(){
  String acumulador = "";
  for(int i = 0; i< this.funcs.size(); i++){
    acumulador+= this.funcs.get(i);
  }
    return acumulador;
  }
}

class COMANDO{
}
class COMANDOCONTROLADO extends COMANDO{
  EXP exp;
        SEQCOMANDOS seqcomandos;
}

class IF extends COMANDOCONTROLADO{
  public IF (EXP exp,   SEQCOMANDOS seqcomandos){
    this.exp= exp;
    this.seqcomandos = seqcomandos;
  }
  public String toString(){
    String acumulador = "if(" + this.exp.toString() + "){\u005cn";
    acumulador+= this.seqcomandos.toString() + "}\u005cn";
    return acumulador;
  }
}
class WHILE extends COMANDOCONTROLADO{
   public WHILE (EXP exp,       SEQCOMANDOS seqcomandos){
    this.exp = exp;
    this.seqcomandos = seqcomandos;
  }
  public String toString(){
    String acumulador = "while(" + this.exp.toString() + "){\u005cn";
    acumulador+= this.seqcomandos.toString() + "}\u005cn";
    return acumulador;
  }
}
class DOWHILE extends COMANDOCONTROLADO{
   public DOWHILE (EXP exp,     SEQCOMANDOS seqcomandos){
    this.exp = exp;
    this.seqcomandos = seqcomandos;
  }
  public String toString(){
    String acumulador = "do{\u005cn" + this.seqcomandos.toString();
    acumulador+= "}while(" + this.exp.toString() + ");\u005cn";
    return acumulador;
  }
}

class COMANDOSAIDA extends COMANDO{
  EXP exp;
}

class PRINT extends COMANDOSAIDA{
  public PRINT(EXP exp){
    this.exp = exp;
  }

  public String toString(){
    return "System.out.println(" + this.exp.toString()+");\u005cn";
  }
}

class RETURN extends COMANDOSAIDA{
  public RETURN(EXP exp){
    this.exp = exp;
  }

  public String toString(){
    return "return " + this.exp.toString()+";\u005cn";
  }
}

class ATRIB extends COMANDOSAIDA{
  String id;
  public ATRIB(String id, EXP exp){
    this.exp = exp;
    this.id = id;
  }

  public String toString(){
    return this.id +" = " + this.exp.toString()+";\u005cn";
  }
}

class CHAMADA extends COMANDO{
  String id;
  LISTAEXP exps;
  public CHAMADA(String id, LISTAEXP exps){
    this.exps = exps;
    this.id = id;
  }

  public String toString(){
    if(this.exps != null){
    return this.id +"(" + this.exps.toString()+");\u005cn";
    };
        return this.id +"();\u005cn";

  }
}



class FATOR{
  String fator;
  LISTAEXP exps;
  public FATOR(String fator){
    this.fator=fator;
  }
  public FATOR(String fator, LISTAEXP exps){
    this.fator=fator;
    this.exps = exps;
  }
public String toString(){
  if(this.exps!=null){
  return fator + exps.toString();
  }
    return fator;
  }

}

class EXP{
  OPERADOR op;
  EXP exp1;
  EXP exp2;
  FATOR fator;
  public EXP(EXP exp1, OPERADOR op, EXP exp2){
    this.op=op;
    this.exp1 = exp1;
    this.exp2 = exp2;
  }
  public EXP(FATOR fator){
    this.fator=fator;
  }
public String toString(){
  if(this.fator!=null){
    return this.fator.toString();
  }
    return this.exp1.toString() + " " + this.op.toString() +" "+ this.exp2.toString() ;
  }

}

class SEQCOMANDOS{
        ArrayList<COMANDO> comandos;
        public SEQCOMANDOS (ArrayList<COMANDO> comandos){
    this.comandos = comandos;
  }
  public SEQCOMANDOS (){
    this.comandos = null;
  }
public String toString(){
  String acumulador = "";
  if(this.comandos == null){
    return "";
  }
  for(int i = 0; i< this.comandos.size(); i++){
    acumulador+= this.comandos.get(i);
  }
    return acumulador;
  }
  }


  class MAIN{
    VARDECL variaveis;
    SEQCOMANDOS seqcomandos;
    public MAIN(VARDECL variaveis, SEQCOMANDOS seqcomandos){
      this.variaveis = variaveis;
      this.seqcomandos = seqcomandos;
    }

    public String toString(){
      String acumulador = "public static void main(String args[]) throws Exception {\u005cn" + this.variaveis.toString() + this.seqcomandos.toString() +"}\u005cn";
      return acumulador;
    }
  }

  class ARVORELUGOSI{
    MAIN main;
    FUNC funcao;
    String nome = "main";
    public ARVORELUGOSI( MAIN main,FUNC funcao){
      this.main = main;
      this.funcao = funcao;
    }

    public void setNome(String nome){
      this.nome = nome;
    }
     public String toString(){
      String acumulador = "public class "+this.nome+"{\u005cn" + this.main.toString();
      if(this.funcao != null){
        acumulador+= "static "+ this.funcao.toString();
      }
      return acumulador + "}";
    }
  }

public class Lugosi implements LugosiConstants {

  public static void main(String args[]) throws ParseException,IOException {

  FileInputStream fs = new FileInputStream(new File(args[0]));
 Lugosi parser = new Lugosi(fs);
 ARVORELUGOSI arvore = parser.Lugosi();

 geraCodigo(arvore, args[0]);
  }

  public static void geraCodigo(ARVORELUGOSI prog, String arquivo){
    try{
              String[] nomeSeparado = arquivo.split("\u005c\u005c.");
              String nomeFinal = nomeSeparado[0]+".java";
prog.setNome(nomeSeparado[0]);
    FileWriter arquivoFinal = new FileWriter(nomeFinal);
      arquivoFinal.write(prog.toString());
      arquivoFinal.close();
    System.out.println("C\u00f3digo gerado com sucesso");
    } catch (IOException e){
    System.out.println("N\u00e3o foi poss\u00edvel gerar o arquivo");
      e.printStackTrace();

    }
  }

  static final public ARVORELUGOSI Lugosi() throws ParseException {
 MAIN main = null; FUNC funcao = null; ArrayList<FUNC> funcoes = new ArrayList();
    main = regraMain();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FUNCTION:
      funcao = regraFunc();
                       funcoes.add(funcao);
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
  {if (true) return new ARVORELUGOSI(main,funcao);}
    jj_consume_token(0);
    throw new Error("Missing return statement in function");
  }

  static final public MAIN regraMain() throws ParseException {
 VARDECL variaveis = null; SEQCOMANDOS seqcomandos = null;
    jj_consume_token(MAIN);
    jj_consume_token(ACHAVES);
    variaveis = regraVardecl();
    seqcomandos = regraSeqcomandos();
    jj_consume_token(FCHAVES);
   {if (true) return new MAIN(variaveis, seqcomandos);}
    throw new Error("Missing return statement in function");
  }

  static final public VARDECL regraVardecl() throws ParseException {
 ArrayList<TIPO> tipos = new ArrayList(); ArrayList<String> ids = new ArrayList(); TIPO tipo = null; Token id = null;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VAR:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      jj_consume_token(VAR);
      tipo = regraTipo();
      id = jj_consume_token(TOKEN_ID);
      jj_consume_token(SEMI);
                                                    tipos.add(tipo); ids.add(id.image);
    }
   {if (true) return new VARDECL(tipos, ids);}
    throw new Error("Missing return statement in function");
  }

  static final public TIPO regraTipo() throws ParseException {
 Token t = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      t = jj_consume_token(INT);
      break;
    case BOOL:
      t = jj_consume_token(BOOL);
      break;
    case FLOAT:
      t = jj_consume_token(FLOAT);
      break;
    case VOID:
      t = jj_consume_token(VOID);
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
   {if (true) return new TIPO(t.image);}
    throw new Error("Missing return statement in function");
  }

  static final public SEQCOMANDOS regraSeqcomandos() throws ParseException {
 ArrayList<COMANDO> comandos = new ArrayList(); COMANDO com = null;
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case WHILE:
      case DO:
      case RETURN:
      case PRINT:
      case TOKEN_ID:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      com = regraComando();
                         comandos.add(com);
    }
   {if (true) return new SEQCOMANDOS(comandos);}
    throw new Error("Missing return statement in function");
  }

  static final public COMANDO regraComando() throws ParseException {
 Token tPrincipal=null; EXP exp = null; SEQCOMANDOS seqcomandos = null; COMANDO com = null; LISTAEXP exps = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TOKEN_ID:
      tPrincipal = jj_consume_token(TOKEN_ID);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ATTRIB:
        jj_consume_token(ATTRIB);
        exp = regraExp();
        jj_consume_token(SEMI);
                                                               com = new ATRIB(tPrincipal.image,exp);
        break;
      case APARENT:
        jj_consume_token(APARENT);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case APARENT:
        case TRUE:
        case FALSE:
        case TOKEN_ID:
        case TOKEN_NUMLITERAL:
          exps = regraListaExp(new ArrayList<EXP>());
          break;
        default:
          jj_la1[4] = jj_gen;
          ;
        }
        jj_consume_token(FPARENT);
        jj_consume_token(SEMI);
                                                                                                                                                                                    com = new CHAMADA(tPrincipal.image,exps);
        break;
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case IF:
      tPrincipal = jj_consume_token(IF);
      jj_consume_token(APARENT);
      exp = regraExp();
      jj_consume_token(FPARENT);
      jj_consume_token(ACHAVES);
      seqcomandos = regraSeqcomandos();
      jj_consume_token(FCHAVES);
      jj_consume_token(SEMI);
                                                                                                                        com = new IF(exp,seqcomandos);
      break;
    case WHILE:
      tPrincipal = jj_consume_token(WHILE);
      jj_consume_token(APARENT);
      exp = regraExp();
      jj_consume_token(FPARENT);
      jj_consume_token(DO);
      jj_consume_token(ACHAVES);
      seqcomandos = regraSeqcomandos();
      jj_consume_token(FCHAVES);
      jj_consume_token(SEMI);
                                                                                                                               com = new WHILE(exp,seqcomandos);
      break;
    case DO:
      tPrincipal = jj_consume_token(DO);
      jj_consume_token(ACHAVES);
      seqcomandos = regraSeqcomandos();
      jj_consume_token(FCHAVES);
      jj_consume_token(WHILE);
      jj_consume_token(APARENT);
      exp = regraExp();
      jj_consume_token(FPARENT);
      jj_consume_token(SEMI);
                                                                                                                              com = new DOWHILE(exp,seqcomandos);
      break;
    case RETURN:
      tPrincipal = jj_consume_token(RETURN);
      exp = regraExp();
      jj_consume_token(SEMI);
                                                 com = new RETURN(exp);
      break;
    case PRINT:
      tPrincipal = jj_consume_token(PRINT);
      jj_consume_token(APARENT);
      exp = regraExp();
      jj_consume_token(FPARENT);
      jj_consume_token(SEMI);
                                                                    com = new PRINT(exp);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
 {if (true) return com;}
    throw new Error("Missing return statement in function");
  }

  static final public EXP regraExp() throws ParseException {
 FATOR f=null; OPERADOR op=null; EXP exp1=null; EXP exp2=null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TRUE:
    case FALSE:
    case TOKEN_ID:
    case TOKEN_NUMLITERAL:
      f = regraFator();
      break;
    case APARENT:
      jj_consume_token(APARENT);
      exp1 = regraExp();
      op = regraOp();
      exp2 = regraExp();
      jj_consume_token(FPARENT);
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
   if(f==null){
    {if (true) return new EXP(exp1,op,exp2);}
    } else{
    {if (true) return new EXP(f);}
    }
    throw new Error("Missing return statement in function");
  }

  static final public FATOR regraFator() throws ParseException {
 Token t; LISTAEXP regras = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TOKEN_ID:
      t = jj_consume_token(TOKEN_ID);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case APARENT:
        jj_consume_token(APARENT);
        regras = regraListaExp(new ArrayList<EXP>());
        jj_consume_token(FPARENT);
        break;
      default:
        jj_la1[8] = jj_gen;
        ;
      }
      break;
    case TOKEN_NUMLITERAL:
      t = jj_consume_token(TOKEN_NUMLITERAL);
      break;
    case TRUE:
      t = jj_consume_token(TRUE);
      break;
    case FALSE:
      t = jj_consume_token(FALSE);
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
   {if (true) return new FATOR(t.image, regras);}
    throw new Error("Missing return statement in function");
  }

  static final public OPERADOR regraOp() throws ParseException {
 Token t = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OPSOMA:
      t = jj_consume_token(OPSOMA);
      break;
    case OPSUB:
      t = jj_consume_token(OPSUB);
      break;
    case OPMULT:
      t = jj_consume_token(OPMULT);
      break;
    case OPDIV:
      t = jj_consume_token(OPDIV);
      break;
    case OPAND:
      t = jj_consume_token(OPAND);
      break;
    case OPOR:
      t = jj_consume_token(OPOR);
      break;
    case OPMENORQ:
      t = jj_consume_token(OPMENORQ);
      break;
    case OPMAIORQ:
      t = jj_consume_token(OPMAIORQ);
      break;
    case OPIGUAL:
      t = jj_consume_token(OPIGUAL);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
   {if (true) return new OPERADOR(t.image);}
    throw new Error("Missing return statement in function");
  }

  static final public LISTAEXP regraListaExp(ArrayList<EXP> exps) throws ParseException {
  EXP exp = null;
    exp = regraExp();
                    exps.add(exp);
    regraListaExpAux(exps);
 {if (true) return new LISTAEXP(exps);}
    throw new Error("Missing return statement in function");
  }

  static final public void regraListaExpAux(ArrayList<EXP> exps) throws ParseException {
 EXP exp = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OPCOMMA:
      jj_consume_token(OPCOMMA);
      exp = regraExp();
                               exps.add(exp);
      regraListaExpAux(exps);
      break;
    default:
      jj_la1[11] = jj_gen;
      ;
    }
  }

  static final public FUNC regraFunc() throws ParseException {
 TIPO tipo = null; Token id = null; LISTAARG argumentos = null; VARDECL variaveis = null; SEQCOMANDOS seqcomandos;
    label_3:
    while (true) {
      jj_consume_token(FUNCTION);
      tipo = regraTipo();
      id = jj_consume_token(TOKEN_ID);
      jj_consume_token(APARENT);
      argumentos = regraListaArg(new ArrayList<TIPO>(),new ArrayList<String>());
      jj_consume_token(FPARENT);
      jj_consume_token(ACHAVES);
      variaveis = regraVardecl();
      seqcomandos = regraSeqcomandos();
      jj_consume_token(FCHAVES);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FUNCTION:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_3;
      }
    }
   {if (true) return new FUNC(tipo, id.image, argumentos, variaveis, seqcomandos);}
    throw new Error("Missing return statement in function");
  }

  static final public LISTAARG regraListaArg(ArrayList<TIPO> tiposParam, ArrayList<String> idsParam) throws ParseException {
 TIPO tipo = null; Token id = null;
    tipo = regraTipo();
    id = jj_consume_token(TOKEN_ID);
                                       tiposParam.add(tipo); idsParam.add(id.image);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OPCOMMA:
      jj_consume_token(OPCOMMA);
      regraListaArg(tiposParam, idsParam);
      break;
    default:
      jj_la1[13] = jj_gen;
      ;
    }
   {if (true) return new LISTAARG(tiposParam, idsParam);}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public LugosiTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[14];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x100,0x3c00,0x3e0000,0xc08000,0xc000,0x3e0000,0xc08000,0x8000,0xc00000,0xff000000,0x0,0x0,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x4,0x0,0x0,0x8,0x18,0x0,0x8,0x18,0x0,0x18,0x1,0x2,0x4,0x2,};
   }

  /** Constructor with InputStream. */
  public Lugosi(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Lugosi(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new LugosiTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Lugosi(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new LugosiTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Lugosi(LugosiTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(LugosiTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[44];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 14; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 44; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
