package acASTGOFVisitor;

public class IntConsting extends AST {
	String val;
	
	IntConsting(String v){
		val = v;
	}
	
	public void accept(Visitor v){v.visitIntConsting(this);}
	
	

}
