package acASTGOFVisitor;

public class CodeGenerator extends Visitor {
	
	String code = "";
	
	public void emit(String c){
		code = code + c;
	}

	@Override
	void visitAssigning(Assigning n) {
		// TODO Auto-generated method stub
		n.child1.accept(this);
		emit(" s");
		emit(n.id);
		emit(" 0 k ");

	}

	@Override
	void visitComputing(Computing n) {
		// TODO Auto-generated method stub
		n.child1.accept(this); 
		n.child2.accept(this);
		emit(n.operation);

	}
	
	void visitConvertingToFloat(ConvertingToFloat n){
		n.child.accept(this);
		emit(" 5 k ");
		
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
		emit("l");
		emit(n.id);
		emit(" p ");
		emit("si ");

	}

	@Override
	void visitProg(Prog n) {
		// TODO Auto-generated method stub
		for(AST ast : n.prog){
			ast.accept(this);
		};
		System.out.println(code);

	}

	@Override
	void visitSymDeclaring(SymDeclaring n) {
		// TODO Auto-generated method stub

	}

	@Override
	void visitFloatDcl(FloatDcl n) {
		// TODO Auto-generated method stub
		

	}

	@Override
	void visitIntDcl(IntDcl n) {
		// TODO Auto-generated method stub
			

	}

	@Override
	void visitSymReferencing(SymReferencing n) {
		// TODO Auto-generated method stub
		emit("l");
		emit(n.id + " ");

	}


}
