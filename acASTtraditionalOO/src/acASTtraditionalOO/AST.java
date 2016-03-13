package acASTtraditionalOO;

import java.util.Hashtable;

public abstract class AST {
	
	public final static int
	FLTTYPE   = 0,
	INTTYPE   = 1;
	
	public static Hashtable<String,Integer> SymbolTable = new Hashtable<String,Integer>();
	
	AST(){
		//for(int ch = 'a'; ch <= 'z'; ch++){AST.SymbolTable.put("" + ch,null);};
	}
	
	public Integer type = null;
	
	public abstract void prettyprint();
	
	public abstract void symbolTableFilling();
	
	public abstract void typeChecking();
	
	public void error(String message) {
		throw new Error(message);
	}
	
	public int generalize(int t1, int t2){
		if (t1 == AST.FLTTYPE || t2 == AST.FLTTYPE) return AST.FLTTYPE; else return AST.INTTYPE;
	}
	
	public AST convert(AST n, int t){
		if (n.type == AST.FLTTYPE && t == AST.INTTYPE) error("Illegal type conversion");
		else if (n.type == AST.INTTYPE && t == AST.FLTTYPE) return new ConvertingToFloat(n); 
		return n;
	}
	
    public abstract void codeGeneration();
	
    String code = "";
	
	public void emit(String c){
		code = code + c;
	}
	
	

}
