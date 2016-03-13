package animals;

public class FeedVisitor extends FarmVisitor {

	public void defaultVisit(Object o) {
		out(o, "I don't know what you eat");
	}

	public void visit(HayEating h) {
		out(h, "you eat hay");
	}

	public void visit(BlackSheep bs) {
		out(bs, "Black Sheep are my favorite, have some good stuff");
	}

	public void visit(Pig p) {
		out(p, "you eat slop");
	}

}
