package acJavaCCwithAST;

public class FloatConsting extends AST {
	String val;
	
	FloatConsting(String v){
		val = v;
	}
	
	public void accept(Visitor v){v.visit(this);}
	
	public void prettyprint(){
		System.out.print(val);
	}

}
