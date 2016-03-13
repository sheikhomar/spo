package acASTGOFVisitor;

public class FloatDcl extends SymDeclaring {
	FloatDcl(String i){
		id = i;
	}
	
	public void accept(Visitor v){v.visitFloatDcl(this);}
	
	

}
