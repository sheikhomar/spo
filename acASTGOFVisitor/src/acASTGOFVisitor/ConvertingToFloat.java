package acASTGOFVisitor;

public class ConvertingToFloat extends AST {

	AST child;
	
	ConvertingToFloat(AST n){
		child = n;
	}
	
	@Override
    public void accept(Visitor v){v.visitConvertingToFloat(this);}
	
	

}
