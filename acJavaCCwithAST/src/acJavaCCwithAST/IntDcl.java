package acJavaCCwithAST;

public class IntDcl extends SymDeclaring {
	
	IntDcl(String i){
		id = i;
	}
	
	public void accept(Visitor v){v.visit(this);}
	
	public void prettyprint(){
		System.out.print("int " + id );
	}

}
