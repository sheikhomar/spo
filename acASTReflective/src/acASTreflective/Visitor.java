package acASTreflective;



public abstract class Visitor extends ReflectiveVisitor{
	
	public String toString() {
		return getClass().toString().substring(6);
	}

	

}
