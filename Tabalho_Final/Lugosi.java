/* Generated By:JavaCC: Do not edit this line. Lugosi.java */
import java.io.*;
import java.util.ArrayList;


class TIPO{
  String tipo;
  public TIPO(String tipo){
    this.tipo=tipo;
  }
public String toString(){
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

public FUNC(TIPO tipo,String id, LISTAARG argumentos, VARDECL variaveis)
{
    this.tipo = tipo;
    this.id = id;
    this.argumentos=argumentos;
    this.variaveis = variaveis;
  }
public String toString(){
  String acumulador = this.tipo.toString() + " " + this.id + "(" + this.argumentos+")"+"{" ;
  acumulador+=variaveis.toString();
  acumulador+="}";
  return acumulador;

}
}


class COMANDO{
}
class COMANDOCONTROLADO extends COMANDO{
  ArrayList<EXP> exps;
        ArrayList<String> seqcomandos;
}

class IF extends COMANDOCONTROLADO{}
class WHILE extends COMANDOCONTROLADO{}
class DOWHILE extends COMANDOCONTROLADO{}

class SEQCOMANDOS{}

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
  return fator + "GGGGGGGGG " + exps.toString();
  }
    return fator + "FATP";
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
    return this.fator.toString() + "alo";
  }
    return this.exp1.toString() + this.op.toString() + this.exp2.toString()+ "alo" ;
  }

}

class LISTAEXP{
        ArrayList<EXP> exps;
        public LISTAEXP (ArrayList<EXP> exps){
    this.exps = exps;
  }
public String toString(){
  String acumulador = "";
  for(int i = 0; i< this.exps.size(); i++){
    acumulador+= this.exps.get(i).toString();
  if(i< this.exps.size()-1){
    acumulador+=", ";
  }
  }
    return acumulador;
  }
  }

public class Lugosi implements LugosiConstants {

  public static void main(String args[]) throws ParseException,IOException {

 Lugosi analisador = new Lugosi(new FileInputStream(args[0]));
 analisador.Lugosi();
  }

  static final public void Lugosi() throws ParseException {
 Token t;
    regraMain();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FUNCTION:
      regraFunc();
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
    jj_consume_token(0);
  }

  static final public void regraMain() throws ParseException {
    jj_consume_token(MAIN);
    jj_consume_token(ACHAVES);
    regraVardecl();
    regraSeqcomandos();
    jj_consume_token(FCHAVES);
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
      regraComando();
    }
   {if (true) return new SEQCOMANDOS();}
    throw new Error("Missing return statement in function");
  }

  static final public COMANDO regraComando() throws ParseException {
 Token tPrincipal=null; EXP exp = null; SEQCOMANDOS seqcomandos = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TOKEN_ID:
      tPrincipal = jj_consume_token(TOKEN_ID);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ATTRIB:
        jj_consume_token(ATTRIB);
        exp = regraExp();
        jj_consume_token(SEMI);
        break;
      case APARENT:
        jj_consume_token(APARENT);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case APARENT:
        case TRUE:
        case FALSE:
        case TOKEN_ID:
        case TOKEN_NUMLITERAL:
          regraListaExp(new ArrayList<EXP>());
          break;
        default:
          jj_la1[4] = jj_gen;
          ;
        }
        jj_consume_token(FPARENT);
        jj_consume_token(SEMI);
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
      regraSeqcomandos();
      jj_consume_token(FCHAVES);
      jj_consume_token(SEMI);
      break;
    case WHILE:
      tPrincipal = jj_consume_token(WHILE);
      jj_consume_token(APARENT);
      exp = regraExp();
      jj_consume_token(FPARENT);
      jj_consume_token(DO);
      jj_consume_token(ACHAVES);
      regraSeqcomandos();
      jj_consume_token(FCHAVES);
      jj_consume_token(SEMI);
      break;
    case DO:
      tPrincipal = jj_consume_token(DO);
      jj_consume_token(ACHAVES);
      regraSeqcomandos();
      jj_consume_token(FCHAVES);
      jj_consume_token(WHILE);
      jj_consume_token(APARENT);
      exp = regraExp();
      jj_consume_token(FPARENT);
      jj_consume_token(SEMI);
      break;
    case RETURN:
      tPrincipal = jj_consume_token(RETURN);
      exp = regraExp();
      jj_consume_token(SEMI);
      break;
    case PRINT:
      tPrincipal = jj_consume_token(PRINT);
      jj_consume_token(APARENT);
      exp = regraExp();
      jj_consume_token(FPARENT);
      jj_consume_token(SEMI);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
 System.out.println("AAAA"+ tPrincipal.image);
 {if (true) return new COMANDO();}
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
 TIPO tipo = null; Token id = null; LISTAARG argumentos = null; VARDECL variaveis = null;
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
      regraSeqcomandos();
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
   {if (true) return new FUNC(tipo, id.image, argumentos, variaveis);}
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
