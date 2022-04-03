class Interpretador{

	Integer interpretaCodigo (ArvoreSintatica arv)
	{

	if (arv instanceof Mult){
		return (interpretaCodigo(((Mult) arv).arg1) * 
			interpretaCodigo(((Mult) arv).arg2));
    }

	if (arv instanceof Soma){
		return (interpretaCodigo(((Soma) arv).arg1) + 
			interpretaCodigo(((Soma) arv).arg2));
    }

	if (arv instanceof Sub){
		return (interpretaCodigo(((Sub) arv).arg1) - 
			interpretaCodigo(((Sub) arv).arg2));
    }

	if (arv instanceof Div){
		return (interpretaCodigo(((Div) arv).arg1) / 
			interpretaCodigo(((Div) arv).arg2));
    }

	if (arv instanceof Num){
		return (((Num) arv).num);
    }

	return null;
	}
}
