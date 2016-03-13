package acASTreflective;

public class SymbolTableFilling extends Visitor {
	
public void defaultVisit(Object o) {
		
	}


public void visit(Assigning n) {
		// TODO Auto-generated method stub
		n.child1.accept(this);

	}

	
public void visit(Computing n) {
		// TODO Auto-generated method stub
		n.child1.accept(this); 
		n.child2.accept(this);

	}
	
public	void visit(ConvertingToFloat n){
		n.child.accept(this);
	}

	
	

	
	
	
	

	
public	void visit(Prog n) {
		// TODO Auto-generated method stub
		for(AST ast : n.prog){
			ast.accept(this);
		};

	}

	

	
public	void visit(FloatDcl n) {
		// TODO Auto-generated method stub
		if (AST.SymbolTable.get(n.id) == null) AST.SymbolTable.put(n.id,AST.FLTTYPE); 
		else error("variable " + n.id + " is already declared");

	}

	
public	void visit(IntDcl n) {
		// TODO Auto-generated method stub
		if (AST.SymbolTable.get(n.id) == null) AST.SymbolTable.put(n.id,AST.INTTYPE); 
		else error("variable " + n.id + " is already declared");

	}

	
	
	
	private void error(String message) {
		throw new Error(message);
	}

}
