package acJavaCCwithAST;

public class IntConsting extends AST {
	String val;
	
	IntConsting(String v){
		val = v;
	}
	
	public void accept(Visitor v){v.visit(this);}
	
	public void prettyprint(){
		System.out.print(val);
	}

}
