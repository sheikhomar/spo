package acASTGOFVisitor;

public class CCodeGenerator extends Visitor {

String code = "";
	
	public void emit(String c){
		code = code + c;
	}

	@Override
	void visitAssigning(Assigning n) {
		// TODO Auto-generated method stub
		emit(n.id + " = ");
		n.child1.accept(this);
		emit(";\n");
		

	}

	@Override
	void visitComputing(Computing n) {
		// TODO Auto-generated method stub
		n.child1.accept(this);
		emit(" " + n.operation + " ");
		n.child2.accept(this);
		

	}
	
	void visitConvertingToFloat(ConvertingToFloat n){
		n.child.accept(this);
		
	}
	
	@Override
	void visitFloatConsting(FloatConsting n) {
		// TODO Auto-generated method stub
		emit(" " + n.val + " ");

	}

	@Override
	void visitIntConsting(IntConsting n) {
		// TODO Auto-generated method stub
		emit(" " + n.val + " ");

	}

	@Override
	void visitPrinting(Printing n) {
		// TODO Auto-generated method stub
		if (n.type == AST.INTTYPE) emit("printf(\"%d\",");
		else emit("printf(\"%1.5f\",");
		emit(n.id);
		emit(");\n");
		

	}

	@Override
	void visitProg(Prog n) {
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

	@Override
	void visitSymDeclaring(SymDeclaring n) {
		// TODO Auto-generated method stub

	}

	@Override
	void visitFloatDcl(FloatDcl n) {
		// TODO Auto-generated method stub
		emit("float " + n.id + ";\n");
		

	}

	@Override
	void visitIntDcl(IntDcl n) {
		// TODO Auto-generated method stub
		emit("int " + n.id + ";\n");
			

	}

	@Override
	void visitSymReferencing(SymReferencing n) {
		// TODO Auto-generated method stub
		emit(" " + n.id + " ");

	}

}
