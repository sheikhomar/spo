package acASTGOFVisitor;

public abstract class Visitor {
	public void visitAST(AST n){ 
		//System.out.println ("In  AST visit\t"+n);

		n.accept(this);
	}
	
	abstract void visitAssigning(Assigning n);
	abstract void visitComputing(Computing n);
	abstract void visitConvertingToFloat(ConvertingToFloat n);
	abstract void visitFloatConsting(FloatConsting n);
	abstract void visitIntConsting(IntConsting n);
	abstract void visitPrinting(Printing n);
	abstract void visitProg(Prog n);
	abstract void visitSymDeclaring(SymDeclaring n);
	abstract void visitFloatDcl(FloatDcl n);
	abstract void visitIntDcl(IntDcl n);
	abstract void visitSymReferencing(SymReferencing n);
	


}
