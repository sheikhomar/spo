package acASTtraditionalOO;

public class Printing extends AST {
	String id;
	
	Printing(String i){
		id = i;
	}
	

	
	public void prettyprint(){
		System.out.print("print " + id);
	}
	
	public void symbolTableFilling() {
		// TODO Auto-generated method stub

	}
	
	public void typeChecking() {
		// TODO Auto-generated method stub

	}
	
	public void codeGeneration() {
		// TODO Auto-generated method stub
		emit("l");
		emit(id);
		emit(" p ");
		emit("si ");

	}

}
