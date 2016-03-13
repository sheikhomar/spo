package acASTtraditionalOO;

public class FloatDcl extends SymDeclaring {
	FloatDcl(String i){
		id = i;
	}
	

	
	public void prettyprint(){
		System.out.print("float " + id );
	}
	
	public void symbolTableFilling() {
		// TODO Auto-generated method stub
		if (AST.SymbolTable.get(id) == null) AST.SymbolTable.put(id,AST.FLTTYPE); 
		else error("variable " + id + " is already declared");

	}
	
	public void typeChecking() {
		// TODO Auto-generated method stub
		

	}
	
	public void codeGeneration() {
		// TODO Auto-generated method stub
		

	}

}
