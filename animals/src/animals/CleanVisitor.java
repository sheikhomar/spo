package animals;


public class CleanVisitor extends FarmVisitor {

	public void defaultVisit(Object o) {
		out(o, "I don't know how to clean you up");
	}

	public void visit(Animal a) {
		out(a, "I will clean your space now");
	}

	public void visit(Pig p) {
		out(p, "You need a lot of cleaning");
	}

}
