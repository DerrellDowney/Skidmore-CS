package cs226.interfaces;

public class Jet extends Vehicle implements Flyer {
	public void drive() {
		System.out.println("Drive called on Jet");
	}
	
	public void brake() {
		System.out.println("Brake designed on Jet");
	}
	
	public void takeOff() {
		System.out.println("Jat has taken off");
	}
	public void land() {
		System.out.println("Jet has landed");
	}

	
	
}
