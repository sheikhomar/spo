package acASTGOFVisitor;

import java.io.CharArrayReader;

// $Id: Main.java 26 2010-01-07 17:14:40Z cytron $

public class Main {

	/**
	 * Exercise the parser and scanner on some examples.
	 * @param args
	 */
	
	public static void functionalprettyprinter (AST ast){
		if (ast instanceof Assigning) {
			Assigning n = (Assigning)ast;
			System.out.print(n.id + " = " );
			functionalprettyprinter(n.child1);
			System.out.print(" ");

		}
		else if (ast instanceof Computing) {
			Computing n = (Computing)ast;
			functionalprettyprinter(n.child1); 
			System.out.print(" " + n.operation + " ");
			functionalprettyprinter(n.child2);

		}
		else if(ast instanceof ConvertingToFloat){
			ConvertingToFloat n = (ConvertingToFloat) ast;
			System.out.print(" i2f ");
			functionalprettyprinter(n.child);
		}
		else if(ast instanceof FloatConsting) {
			// TODO Auto-generated method stub
			FloatConsting n = (FloatConsting) ast;
			System.out.print(n.val);

		}
		else if(ast instanceof IntConsting) {
			// TODO Auto-generated method stub
			IntConsting n = (IntConsting) ast;
			System.out.print(n.val);

		}
		else if(ast instanceof Printing) {
			// TODO Auto-generated method stub
			Printing n = (Printing) ast;
			System.out.print("p " + n.id + " ");

		}
		else if(ast instanceof Prog) {
			// TODO Auto-generated method stub
			Prog n = (Prog) ast;
			for(AST ast1 : n.prog){
				functionalprettyprinter(ast1);
			};
			System.out.println();

		}
		else if(ast instanceof FloatDcl) {
			// TODO Auto-generated method stub
			FloatDcl n = (FloatDcl) ast;
			System.out.print("f " + n.id + " ");

		}
		else if(ast instanceof IntDcl) {
			// TODO Auto-generated method stub
			IntDcl n = (IntDcl) ast;
				System.out.print("i " + n.id + " ");

		}
		else if(ast instanceof SymReferencing) {
			// TODO Auto-generated method stub
			SymReferencing n = (SymReferencing) ast;
			System.out.print(n.id);

		}

	}
	
	
	public static void main(String[] args) throws Throwable {
		//
		// Add more examples to this array
		//   Each will be tried through the parser
		//
		String[] examples = new String[] {
		/* 1 */ 		"f b   i a   a = 5   b = a + 3.2  p b",
		/* 2 */	        "i d d = 3.2",
		/* 3  */		"a a",
		/* 4 */ 		"f f",
		/* 5  */		"a = 5  f b",
		/* 6 */ 		"% %" 
		};

		
		for (String example : examples) {
			try {
				System.out.println("Parsing: " + example);
				CharArrayReader reader = new CharArrayReader(example.toCharArray());
				CharStream s = new CharStream(reader);

				ASTParser p = new ASTParser(s);
				AST ast = p.Prog();
				//functionalprettyprinter(ast);
				System.out.println("   Parse successful");
				ast.accept(new Prettyprinting());
				System.out.println(" Pretty Printing successful");
				ast.accept(new SymbolTableFilling());
				System.out.println(" Symbol Table filling successful");
				System.out.println(AST.SymbolTable.toString());
				//ast.accept(new TypeChecker());
				//System.out.println(" Type Checking successful");
				//ast.accept(new Prettyprinting());
				//System.out.println(" Pretty Printing successful");
				//ast.accept(new CodeGenerator());
				//System.out.println(" Code Generation successful");
				//ast.accept(new CCodeGenerator());
				//System.out.println(" C Code Generation successful");
				//AST.SymbolTable.clear();
				//SinglePassParser spp = new SinglePassParser(s);
				//spp.Prog();
				//System.out.println("ssp code: " + spp.code);
				//spp.SymbolTable.clear();
				//System.out.println(" Single Pass Compilation Successful");
			}
			catch (Throwable t) {
				System.out.println("   Compiler ended with error: " + t);
				System.out.println("Stack trace: ");
				t.printStackTrace(System.out);
			}
		}

	}

}
