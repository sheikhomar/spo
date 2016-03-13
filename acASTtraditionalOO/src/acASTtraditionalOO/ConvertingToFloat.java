package acASTtraditionalOO;

public class ConvertingToFloat extends AST {

	AST child;
	
	ConvertingToFloat(AST n){
		child = n;
	}
	

	
	public void prettyprint(){
		System.out.print(" i2f ");
	}
	
	public void symbolTableFilling(){
		child.symbolTableFilling();
	}
	
	public void typeChecking(){
		child.typeChecking();
		type = AST.FLTTYPE;
	}
	
	public void codeGeneration(){
		child.codeGeneration();
		emit(" 5 k ");
		
	}

}
