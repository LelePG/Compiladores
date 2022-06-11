public class testeFornecido{
public static void main(String args[]) throws Exception {
boolean estaChovendoHoje;
boolean precisoCaminharHoje;
int outraCoisa;
estaChovendoHoje = true;
precisoCaminharHoje = false;
int a = levarGuardaChuva(estaChovendoHoje, precisoCaminharHoje);
System.out.println(a);
}
static int levarGuardaChuva(boolean estaChovendo,boolean precisoCaminhar){
if(estaChovendo && precisoCaminhar){
System.out.println(true);
}
return 1;
}
}