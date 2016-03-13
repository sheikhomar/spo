package acJavaCCwithAST;

public class FloatDcl extends SymDeclaring {
	FloatDcl(String i){
		id = i;
	}
	
	public void accept(Visitor v){v.visit(this);}
	
	public void prettyprint(){
		System.out.print("float " + id );
	}

}
