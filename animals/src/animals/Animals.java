package animals;

/**
 * Thanks to Ben Brodie for farm information
 */

import java.util.Vector;

class Animal implements ReflectiveVisitable {
	public void accept(ReflectiveVisitor v) {
		v.dispatch(this);
	}

	// How I love virtual methods

	public String toString() {
		return getClass().toString().substring(6);
	}

}

interface HayEating {
}

interface StrawBedding {
}

interface RoamBedding {
}

class Llama extends Animal implements HayEating, StrawBedding {
}

class Sheep extends Animal implements HayEating, RoamBedding {
}

class WhiteSheep extends Sheep {
}

class BlackSheep extends Sheep {
}

class Pig extends Animal implements StrawBedding {
}

class Cow extends Animal implements HayEating, RoamBedding {
}

class Horse extends Animal implements HayEating, StrawBedding {
}

public class Animals {

	/**
	 * In GoF, this is the ObjectStructure component, which understand how the
	 * objects are connected, in this case, by a Vector
	 */

	private static void applyToAll(ReflectiveVisitor visitor,
			Vector<ReflectiveVisitable> vect) {

		for (ReflectiveVisitable rv : vect) {
			rv.accept(visitor);
		}
	}

	public static void main(String[] args) {

		Vector<ReflectiveVisitable> animals = new Vector<ReflectiveVisitable>();
		animals.addElement(new Cow());
		animals.addElement(new Horse());
		animals.addElement(new WhiteSheep());
		animals.addElement(new Horse());
		animals.addElement(new BlackSheep());
		animals.addElement(new Pig());
		animals.addElement(new Llama());
		animals.addElement(new Sheep());

		System.out.println("And on this farm we have " + animals);
		applyToAll(new FeedVisitor(), animals);
		applyToAll(new BedTimeVisitor(), animals);
		applyToAll(new CleanVisitor(), animals);
	}

}
