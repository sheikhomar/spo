package acJavaCCwithAST;

public class ConvertingToFloat extends AST {

	AST child;
	
	ConvertingToFloat(AST n){
		child = n;
	}
	
	@Override
    public void accept(Visitor v){v.visit(this);}
	
	public void prettyprint(){
		System.out.print(" i2f ");
	}

}
