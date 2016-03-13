package acASTreflective;

public class CodeGenerator extends Visitor {
	
public void defaultVisit(Object o) {
		
	}
	
	String code = "";
	
	public void emit(String c){
		code = code + c;
	}

	
public	void visit(Assigning n) {
		// TODO Auto-generated method stub
		n.child1.accept(this);
		emit(" s");
		emit(n.id);
		emit(" 0 k ");

	}

	
public	void visit(Computing n) {
		// TODO Auto-generated method stub
		n.child1.accept(this); 
		n.child2.accept(this);
		emit(n.operation);

	}
	
public	void visit(ConvertingToFloat n){
		n.child.accept(this);
		emit(" 5 k ");
		
	}
	
	
public	void visit(FloatConsting n) {
		// TODO Auto-generated method stub
		emit(" " + n.val + " ");

	}

	
public	void visit(IntConsting n) {
		// TODO Auto-generated method stub
		emit(" " + n.val + " ");

	}

	
public	void visit(Printing n) {
		// TODO Auto-generated method stub
		emit("l");
		emit(n.id);
		emit(" p ");
		emit("si ");

	}

	
public	void visit(Prog n) {
		// TODO Auto-generated method stub
		for(AST ast : n.prog){
			ast.accept(this);
		};
		System.out.println(code);

	}

	
public	void visit(SymDeclaring n) {
		// TODO Auto-generated method stub

	}

	
public	void visit(FloatDcl n) {
		// TODO Auto-generated method stub
		

	}

	
	void visit(IntDcl n) {
		// TODO Auto-generated method stub
			

	}

	
	void visit(SymReferencing n) {
		// TODO Auto-generated method stub
		emit("l");
		emit(n.id + " ");

	}


}
