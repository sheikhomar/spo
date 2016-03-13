package animals;

import java.lang.reflect.*;

/**
 * A reflective version of Visitor Adapted from
 * http://www.javaworld.com/javaworld/javatips/jw-javatip98.html
 */

abstract public class ReflectiveVisitor {

	public static boolean debug = false;
	private static Class<? extends Object> objectClass = Object.class;

	abstract public void defaultVisit(Object o);

	private void debugMsg(String s) {
		if (debug)
			System.err.println(s);
	}

	public final void dispatch(Object o) {
		Method m = getBestMethodFor(o);
		try {
			m.invoke(this, new Object[] { o });
		} catch (IllegalAccessException e) {
			e.printStackTrace(System.err);
			throw new Error("Method " + m + " aborting, bad access: " + e);
		} catch (InvocationTargetException e) {
			// This exception is thrown if the reflectively called method
			// throws anything for any reason
			e.printStackTrace(System.err);
			throw new Error("Method " + m + " aborting: " + e);
		}
	}

	/**
	 * Find the closest visit method that handles the supplied object
	 */

	protected Method getBestMethodFor(Object o) {
		Class<? extends Object> nodeClass = o.getClass();
		Method ans = null;

		// Try the superclasses

		for (Class<? extends Object> c = nodeClass; c != objectClass
				&& ans == null; c = c.getSuperclass()) {
			debugMsg("Looking for class match for " + c.getName());
			try {

				// Unlike GoF, all methods are "visit" and are
				// distinguished by their param type

				ans = getClass().getMethod("visit", new Class[] { c });

			} catch (NoSuchMethodException e) {
			}
		}

		// Try the interfaces. The code below will find the last
		// interface listed for
		// which "this" visitor can handle the type

		Class<? extends Object> iClass = nodeClass;
		while (ans == null && iClass != objectClass) {
			debugMsg("Looking for interface  match in " + iClass.getName());
			Class<? extends Object>[] interfaces = iClass.getInterfaces();
			for (int i = 0; i < interfaces.length; i++) {
				debugMsg("   trying interface " + interfaces[i]);
				try {
					ans = getClass().getMethod("visit",
							new Class[] { interfaces[i] });
				} catch (NoSuchMethodException e) {
				}
			}
			iClass = iClass.getSuperclass();
		}

		if (ans == null) {
			try {
				debugMsg("Giving up");
				ans = getClass().getMethod("defaultVisit",
						new Class[] { (new Object()).getClass() });
			} catch (NoSuchMethodException e) {
				// Just stop, because throwing an exception will cascade upwards
				debugMsg("Cannot happen -- could not find defaultVisit(Object)");
				e.printStackTrace(System.err);
				System.exit(-1);
			}
		}
		debugMsg("Best method for " + o + " is " + ans);
		return ans;
	}

}
