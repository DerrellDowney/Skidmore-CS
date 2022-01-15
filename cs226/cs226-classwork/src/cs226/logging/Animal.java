package cs226.logging;

import org.apache.log4j.Logger;
public class Animal {
	private static final Logger LOG;
	public int x;
	
	static {
		LOG = java.util.logging.Logger.getLogger(Animal.class);
	}
	public Animal() {
		LOG.info("Animal created");
		x = 5;
	}
	
	public static void main(String[] args ) {
		new Animal();
	}
}
