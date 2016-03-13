package acASTreflective;

public class CCodeGenerator extends Visitor {
	
public void defaultVisit(Object o) {
		
	}

String code = "";
	
	public void emit(String c){
		code = code + c;
	}

	
public	void visit(Assigning n) {
		// TODO Auto-generated method stub
		emit(n.id + " = ");
		n.child1.accept(this);
		emit(";\n");
		

	}

	
public	void visit(Computing n) {
		// TODO Auto-generated method stub
		n.child1.accept(this);
		emit(" " + n.operation + " ");
		n.child2.accept(this);
		

	}
	
public	void visit(ConvertingToFloat n){
		n.child.accept(this);
		
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
		if (n.type == AST.INTTYPE) emit("printf(\"%d\",");
		else emit("printf(\"%1.5f\",");
		emit(n.id);
		emit(");\n");
		

	}

	
public	void visit(Prog n) {
		// TODO Auto-generated method stub
		
		emit("#include < stdio.h>\n\n");
	    emit("void main()\n{\n");
		for(AST ast : n.prog){
			ast.accept(this);
		};
		emit("return 0;");
		emit("\n}");
		
		System.out.println(code);

	}

	
public	void visit(SymDeclaring n) {
		// TODO Auto-generated method stub

	}

	
public	void visit(FloatDcl n) {
		// TODO Auto-generated method stub
		emit("float " + n.id + ";\n");
		

	}

	
public	void visit(IntDcl n) {
		// TODO Auto-generated method stub
		emit("int " + n.id + ";\n");
			

	}

	
public	void visit(SymReferencing n) {
		// TODO Auto-generated method stub
		emit(" " + n.id + " ");

	}

}
