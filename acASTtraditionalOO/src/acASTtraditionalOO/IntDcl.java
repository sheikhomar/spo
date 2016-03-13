package acASTtraditionalOO;

public class IntDcl extends SymDeclaring {
	
	IntDcl(String i){
		id = i;
	}
	

	
	public void prettyprint(){
		System.out.print("int " + id );
	}
	
	public void symbolTableFilling() {
		// TODO Auto-generated method stub
		if (AST.SymbolTable.get(id) == null) AST.SymbolTable.put(id,AST.INTTYPE); 
		else error("variable " + id + " is already declared");

	}
	
	public void typeChecking() {
		// TODO Auto-generated method stub
	

	}
	
	public void codeGeneration() {
		// TODO Auto-generated method stub
			

	}

}
