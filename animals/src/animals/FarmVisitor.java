package animals;


abstract public class FarmVisitor extends ReflectiveVisitor {

	public String toString() {
		return getClass().toString().substring(6);
	}

	protected void out(Object o, String s) {
		System.out.println("Visitor " + this + " visiting " + o + ": \"" + s
				+ "\"");
	}

}
