package acASTreflective;

public class TypeChecker extends Visitor {

public void defaultVisit(Object o) {
		
	}
	
public	void visit(Assigning n) {
		// TODO Auto-generated method stub
		n.child1.accept(this);
		int m = AST.SymbolTable.get(n.id);
		int t = generalize(n.child1.type,m);
		n.child1 = convert(n.child1,m);
		n.type = t;
	}

	
public	void visit(Computing n) {
		// TODO Auto-generated method stub
		n.child1.accept(this); 
		n.child2.accept(this);
		int m = generalize(n.child1.type,n.child2.type);
		n.child1 = convert(n.child1,m);
		n.child2 = convert(n.child2,m);
		n.type = m;
	}
	
public	void visit(ConvertingToFloat n){
		n.child.accept(this);
		n.type = AST.FLTTYPE;
	}

	
public	void visit(FloatConsting n) {
		// TODO Auto-generated method stub
		n.type = AST.FLTTYPE;

	}

	
public	void visit(IntConsting n) {
		// TODO Auto-generated method stub
		n.type = AST.INTTYPE;

	}

	
public	void visit(Printing n) {
		// TODO Auto-generated method stub
		//not need for dc code, but needed for C code generator
		n.type = AST.SymbolTable.get(n.id);
	}

	
public	void visit(Prog n) {
		// TODO Auto-generated method stub
		for(AST ast : n.prog){
			ast.accept(this);
		};

	}

	
public	void visit(SymDeclaring n) {
		// TODO Auto-generated method stub

	}

	
public	void visit(FloatDcl n) {
		// TODO Auto-generated method stub
		

	}

	
public	void visit(IntDcl n) {
		// TODO Auto-generated method stub
	

	}

	
public	void visit(SymReferencing n) {
		// TODO Auto-generated method stub
		n.type = AST.SymbolTable.get(n.id);

	}
	
	private void error(String message) {
		throw new Error(message);
	}
	
	/* Inlined in 
	 * private int consistent(AST c1, AST c2){
		int m = generalize(c1.type,c2.type);
		convert(c1,m);
		convert(c2,m);
		
	}*/
	
	private int generalize(int t1, int t2){
		if (t1 == AST.FLTTYPE || t2 == AST.FLTTYPE) return AST.FLTTYPE; else return AST.INTTYPE;
	}
	
	private AST convert(AST n, int t){
		if (n.type == AST.FLTTYPE && t == AST.INTTYPE) error("Illegal type conversion");
		else if (n.type == AST.INTTYPE && t == AST.FLTTYPE) return new ConvertingToFloat(n); 
		return n;
	}

}
