package acASTGOFVisitor;

public class SymDeclaring extends AST {
	String id;
	
	public void accept(Visitor v){v.visitSymDeclaring(this);}
	
	

}
