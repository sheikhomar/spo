package acASTGOFVisitor;

public class Prettyprinting extends Visitor {

	@Override
	void visitAssigning(Assigning n) {
		// TODO Auto-generated method stub
		System.out.print(n.id + " = " );
		n.child1.accept(this);
		System.out.print(" ");

	}

	@Override
	void visitComputing(Computing n) {
		// TODO Auto-generated method stub
		n.child1.accept(this); 
		System.out.print(" " + n.operation + " ");
		n.child2.accept(this);

	}

	void visitConvertingToFloat(ConvertingToFloat n){
		System.out.print(" i2f ");
		n.child.accept(this);
	}
	
	@Override
	void visitFloatConsting(FloatConsting n) {
		// TODO Auto-generated method stub
		System.out.print(n.val);

	}

	@Override
	void visitIntConsting(IntConsting n) {
		// TODO Auto-generated method stub
		System.out.print(n.val);

	}

	@Override
	void visitPrinting(Printing n) {
		// TODO Auto-generated method stub
		System.out.print("p " + n.id + " ");

	}

	@Override
	void visitProg(Prog n) {
		// TODO Auto-generated method stub
		for(AST ast : n.prog){
			ast.accept(this);
		};
		System.out.println();

	}

	@Override
	void visitSymDeclaring(SymDeclaring n) {
		// TODO Auto-generated method stub

	}

	@Override
	void visitFloatDcl(FloatDcl n) {
		// TODO Auto-generated method stub
		System.out.print("f " + n.id + " ");

	}

	@Override
	void visitIntDcl(IntDcl n) {
		// TODO Auto-generated method stub
			System.out.print("i " + n.id + " ");

	}

	@Override
	void visitSymReferencing(SymReferencing n) {
		// TODO Auto-generated method stub
		System.out.print(n.id);

	}

}
