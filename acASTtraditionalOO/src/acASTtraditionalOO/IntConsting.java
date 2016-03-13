package acASTtraditionalOO;

public class IntConsting extends AST {
	String val;
	
	IntConsting(String v){
		val = v;
	}
	

	
	public void prettyprint(){
		System.out.print(val);
	}
	
	public void symbolTableFilling() {
		// TODO Auto-generated method stub

	}
	
	public void typeChecking() {
		// TODO Auto-generated method stub
		type = AST.INTTYPE;

	}
	
	public void codeGeneration() {
		// TODO Auto-generated method stub
		emit(" " + val + " ");

	}

}
