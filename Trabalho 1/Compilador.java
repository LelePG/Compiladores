class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();
		
			// Com o compilador
			CodeGen backend = new CodeGen();
			String codigo = backend.geraCodigo(arv);

			//Com o intepretador
			// Interpretador backend = new Interpretador();
			// Integer codigo = backend.interpretaCodigo(arv);
			System.out.println(codigo);

		}catch(Exception e)
		{			
			System.out.println("Erro de compilação:\n" + e);
		}



	}
}
