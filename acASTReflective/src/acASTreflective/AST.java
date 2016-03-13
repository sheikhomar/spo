package acASTreflective;

import java.util.Hashtable;



public class AST implements ReflectiveVisitable {
	
	public void accept(ReflectiveVisitor v) {
		v.dispatch(this);
	}


	
	
	public final static int
	FLTTYPE   = 0,
	INTTYPE   = 1;
	
	public static Hashtable<String,Integer> SymbolTable = new Hashtable<String,Integer>();
	
	AST(){
		//for(int ch = 'a'; ch <= 'z'; ch++){AST.SymbolTable.put("" + ch,null);};
	}
	
	public Integer type = null;
	

}
