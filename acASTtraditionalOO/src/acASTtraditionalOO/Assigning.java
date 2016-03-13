package acASTtraditionalOO;

public class Assigning extends AST {
	String id;
	AST child1;
	
	//Note I cheated, in the book an Assign node has two children, where the first child always is a SymReferencing node
	
	Assigning(String i, AST ch1){
		id = i;
		child1 = ch1;
		
	}
	

	
	public void prettyprint(){
		System.out.print(id + " = " );
		child1.prettyprint();
	}
	
	public void symbolTableFilling() {
		
		child1.symbolTableFilling();
	}
	
	public void typeChecking() {
		
		child1.typeChecking();
		int m = AST.SymbolTable.get(id);
		int t = generalize(child1.type,m);
		child1 = convert(child1,m);
		type = t;
	}
	
	public void codeGeneration() {
		
		child1.codeGeneration();
		emit(" s");
		emit(id);
		emit(" 0 k ");

	}
	
	

}
