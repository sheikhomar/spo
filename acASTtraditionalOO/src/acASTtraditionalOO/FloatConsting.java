package acASTtraditionalOO;

public class FloatConsting extends AST {
	String val;
	
	FloatConsting(String v){
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
		type = AST.FLTTYPE;

	}
	
	public void codeGeneration() {
		// TODO Auto-generated method stub
		emit(" " + val + " ");

	}

}
