package animals;


public class BedTimeVisitor extends FarmVisitor {

	public void defaultVisit(Object o) {
		out(o, "I don't know what puts you to bed");
	}

	public void visit(StrawBedding sb) {
		out(sb, "Here is some straw");
	}

	public void visit(RoamBedding rb) {
		out(rb, "You just roam around");
	}

}
