package acASTtraditionalOO;

public class SymReferencing extends AST {
	String id;
	
	SymReferencing(String i){
		id = i;
	}
	
	
	public void prettyprint(){
		System.out.print(id);
	}
	
	public void symbolTableFilling() {
		// TODO Auto-generated method stub

	}
	
	public void typeChecking() {
		// TODO Auto-generated method stub
		type = AST.SymbolTable.get(id);

	}
	
	public void codeGeneration() {
		// TODO Auto-generated method stub
		emit("l");
		emit(id + " ");

	}

}
