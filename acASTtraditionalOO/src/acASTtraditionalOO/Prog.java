package acASTtraditionalOO;

import java.util.ArrayList;;

public class Prog extends AST {
	
	ArrayList<AST> prog;
	
	Prog(ArrayList<AST> prg){
		prog = prg;
	}
	

	
	public void prettyprint(){
		for(AST ast : prog){
			ast.prettyprint();
		};
		System.out.println();
	}
	
	public void symbolTableFilling() {
		// TODO Auto-generated method stub
		for(AST ast : prog){
			ast.symbolTableFilling();
		};

	}
	
	public void typeChecking() {
		// TODO Auto-generated method stub
		for(AST ast : prog){
			ast.typeChecking();
		};

	}
	
	public void codeGeneration() {
		// TODO Auto-generated method stub
		for(AST ast : prog){
			ast.codeGeneration();
		};
		System.out.println(code);

	}

}
