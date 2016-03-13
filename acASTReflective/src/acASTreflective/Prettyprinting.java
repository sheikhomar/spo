package acASTreflective;

public class Prettyprinting extends ReflectiveVisitor {

	
	public void defaultVisit(Object o) {
		System.out.print("Applying default Prettyprint visitor");
	}
	

	
	public void visit(Assigning n) {
		System.out.print(n.id + " = " );
		n.child1.accept(this);
		System.out.print(" ");

	}

	
	public void visit(Computing n) {
		// TODO Auto-generated method stub
		n.child1.accept(this); 
		System.out.print(" " + n.operation + " ");
		n.child2.accept(this);

	}

	public void visit(ConvertingToFloat n){
		System.out.print(" i2f ");
		n.child.accept(this);
	}
	
	
	public void visit(FloatConsting n) {
		// TODO Auto-generated method stub
		System.out.print(n.val);

	}

	
	public void visit(IntConsting n) {
		// TODO Auto-generated method stub
		System.out.print(n.val);

	}

	
	public void visit(Printing n) {
		// TODO Auto-generated method stub
		System.out.print("p " + n.id + " ");

	}

	
	public void visit(Prog n) {
		// TODO Auto-generated method stub
		for(AST ast : n.prog){
			ast.accept(this);
		};
		System.out.println();

	}

	
	public void visit(SymDeclaring n) {
		// TODO Auto-generated method stub

	}

	
	public void visit(FloatDcl n) {
		// TODO Auto-generated method stub
		System.out.print("f " + n.id + " ");

	}

	
	public void visit(IntDcl n) {
		// TODO Auto-generated method stub
			System.out.print("i " + n.id + " ");

	}

	
	public void visit(SymReferencing n) {
		// TODO Auto-generated method stub
		System.out.print(n.id);

	}

}
