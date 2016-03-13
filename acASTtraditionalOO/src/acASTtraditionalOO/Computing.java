package acASTtraditionalOO;

public class Computing extends AST {
	String operation;
	AST child1;
	AST child2;
	
	Computing(String op, AST ch1, AST ch2){
		child1 = ch1;
		child2 = ch2;
		operation = op;
		
	}
	
	
	public void prettyprint(){
		child1.prettyprint(); 
		System.out.print(operation);
		child2.prettyprint();
		}
	
	public void symbolTableFilling() {
		child1.symbolTableFilling(); 
		child2.symbolTableFilling();

	}
	
	public void typeChecking() {
		child1.typeChecking(); 
		child2.typeChecking();
		int m = generalize(child1.type,child2.type);
		child1 = convert(child1,m);
		child2 = convert(child2,m);
		type = m;
	}
	
	public void codeGeneration() {
		child1.codeGeneration(); 
		child2.codeGeneration();
		emit(operation);

	}
}
