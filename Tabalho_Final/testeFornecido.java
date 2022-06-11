public class testeFornecido{
public static void main(String args[]) throws Exception {
boolean estaChovendoHoje;
boolean precisoCaminharHoje;
int outraCoisa;
estaChovendoHoje = true;
precisoCaminharHoje = false;
levarGuardaChuva(estaChovendoHoje, precisoCaminharHoje);
}
static int levarGuardaChuva(boolean estaChovendo,boolean precisoCaminhar){
if(estaChovendo && precisoCaminhar){
System.out.println(true);
}
return 1;
}
}