package acASTGOFVisitor;

public class FloatConsting extends AST {
	String val;
	
	FloatConsting(String v){
		val = v;
	}
	
	public void accept(Visitor v){v.visitFloatConsting(this);}
	
	

}
