package acSinglePass;




import static acSinglePass.Token.ASSIGN;
import static acSinglePass.Token.EOF;
import static acSinglePass.Token.FLTDCL;
import static acSinglePass.Token.FNUM;
import static acSinglePass.Token.ID;
import static acSinglePass.Token.INTDCL;
import static acSinglePass.Token.INUM;
import static acSinglePass.Token.MINUS;
import static acSinglePass.Token.PLUS;
import static acSinglePass.Token.PRINT;
import static acSinglePass.Token.*;

import java.util.Hashtable;

	// $Id: Parser.java 25 2010-01-07 17:03:40Z cytron $

	/**
	 * Recursive-descent parser based on the grammar given
	 *   in Figure 2.1
	 * @author cytron
	 *
	 */
public class SinglePassParser {	

		private TokenStream ts;
		

		public SinglePassParser(CharStream s) {
			ts = new TokenStream(s);
		}
		
		public final static int
		FLTTYPE   = 0,
		INTTYPE   = 1;
		
		public static Hashtable<String,Integer> SymbolTable = new Hashtable<String,Integer>();
		
		String code = "";
		
		public void emit(String c){
			code = code + c;
		}


		public void Prog() {
			if (ts.peek() == FLTDCL || ts.peek() == INTDCL || ts.peek() == ID || ts.peek() == PRINT || ts.peek() == EOF) {
				Dcls();
				Stmts();
				expect(EOF);
			}
			else error("expected floatdcl, intdcl, id, print, or eof");
			System.out.println(code);
		}

		public void Dcls() {
			if (ts.peek() == FLTDCL || ts.peek() == INTDCL) {
				Dcl();
				Dcls();
			}
			else if (ts.peek() == ID || ts.peek() == PRINT || ts.peek() == EOF) {
				// Do nothing for lambda-production
			}
			else error("expected floatdcl, intdcl, id, print, or eof");
		}

		public void Dcl() {
			if (ts.peek() == FLTDCL) {
				expect(FLTDCL);
				Token t = expect(ID);
				if (SinglePassParser.SymbolTable.get(t.val) == null) SinglePassParser.SymbolTable.put(t.val,FLTTYPE); 
				else error("variable " + t.val + " is already declared");
			}
			else if (ts.peek() == INTDCL) {
				expect(INTDCL);
				Token t = expect(ID);
				if (SinglePassParser.SymbolTable.get(t.val) == null) SinglePassParser.SymbolTable.put(t.val,INTTYPE); 
				else error("variable " + t.val + " is already declared");
			}
			else error("expected float or int declaration");
		}

		/**
		 * Figure 2.7 code
		 */
		public void Stmts() {
			if (ts.peek() == ID || ts.peek() == PRINT) {
				Stmt();
				Stmts();
			}
			else if (ts.peek() == EOF) {
				// Do nothing for lambda-production
			}
			else error("expected id, print, or eof");

		}

		public void Stmt() {
			if (ts.peek() == ID) {
				Token t = expect(ID);
				expect(ASSIGN);
				int tid = SymbolTable.get(t.val);
				int vt = Val();
				if (tid == FLTTYPE && vt == INTTYPE) {emit(" 5 k "); vt = FLTTYPE;};
				int et = Expr(vt);
				if (tid == INTTYPE && et == FLTTYPE) error("Illegal type conversion");
				emit(" s");
				emit(t.val);
				emit(" 0 k ");
			}
			else if (ts.peek() == PRINT) {
				expect(PRINT);
				Token t = expect(ID);
				emit("l");
				emit(t.val);
				emit(" p ");
				emit("si ");
			}
			else error("expected id or print");

		}

		public int Expr(int te) {
			int ty = -1;
			if (ts.peek() == PLUS) {
				expect(PLUS);
				int vt = Val();
				if (te == FLTTYPE && vt == INTTYPE) {emit(" 5 k "); vt = FLTTYPE;};
				int et = Expr(vt);
				emit(" + ");
				ty = et;
			}
			else if (ts.peek() == MINUS) {
				expect(MINUS);
				int vt = Val();
				if (te == FLTTYPE && vt == INTTYPE) {emit(" 5 k "); vt = FLTTYPE;};
				int et = Expr(vt);
				emit(" - ");
				ty = et;

			}
			else if (ts.peek() == ID || ts.peek() == PRINT || ts.peek() == EOF) {
				// Do nothing for lambda-production
				ty = te;
			}
			else error("expected plus, minus, id, print, or eof");
			return ty;

		}

		public int Val() {
			int ty = -1;
			if (ts.peek() == ID) {
				Token t = expect(ID);
				ty = SymbolTable.get(t.val);
				emit("l");
				emit(t.val + " ");
			}
			else if (ts.peek() == INUM) {
				Token t = expect(INUM);
				ty = INTTYPE;
				emit(t.val + " ");
			}
			else if (ts.peek() == FNUM) {
				Token t = expect(FNUM);
				ty = FLTTYPE;
				emit(t.val + " ");
			}
			else error("expected id, inum, or fnum");
			return ty;

		}

		private Token expect(int type) {
			Token t = ts.advance();
			if (t.type != type) {
				throw new Error("Expected type " 
						+ Token.token2str[type]
						                  + " but received type "
						                  + Token.token2str[t.type]);

			};
			return t;
		}

		private void error(String message) {
			throw new Error(message);
		}

	}
