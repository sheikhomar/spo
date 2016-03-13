package acASTGOFVisitor;

public class SymbolTableFilling extends Visitor {

	@Override
	void visitAssigning(Assigning n) {
		// TODO Auto-generated method stub
		n.child1.accept(this);

	}

	@Override
	void visitComputing(Computing n) {
		// TODO Auto-generated method stub
		n.child1.accept(this); 
		n.child2.accept(this);

	}
	
	void visitConvertingToFloat(ConvertingToFloat n){
		n.child.accept(this);
	}

	@Override
	void visitFloatConsting(FloatConsting n) {
		// TODO Auto-generated method stub

	}

	@Override
	void visitIntConsting(IntConsting n) {
		// TODO Auto-generated method stub

	}

	@Override
	void visitPrinting(Printing n) {
		// TODO Auto-generated method stub

	}

	@Override
	void visitProg(Prog n) {
		// TODO Auto-generated method stub
		for(AST ast : n.prog){
			ast.accept(this);
		};

	}

	@Override
	void visitSymDeclaring(SymDeclaring n) {
		// TODO Auto-generated method stub

	}

	@Override
	void visitFloatDcl(FloatDcl n) {
		// TODO Auto-generated method stub
		if (AST.SymbolTable.get(n.id) == null) AST.SymbolTable.put(n.id,AST.FLTTYPE); 
		else error("variable " + n.id + " is already declared");

	}

	@Override
	void visitIntDcl(IntDcl n) {
		// TODO Auto-generated method stub
		if (AST.SymbolTable.get(n.id) == null) AST.SymbolTable.put(n.id,AST.INTTYPE); 
		else error("variable " + n.id + " is already declared");

	}

	@Override
	void visitSymReferencing(SymReferencing n) {
		// TODO Auto-generated method stub

	}
	
	private void error(String message) {
		throw new Error(message);
	}

}
