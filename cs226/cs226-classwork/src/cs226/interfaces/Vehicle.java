package cs226.interfaces;

public abstract class Vehicle {
	private int numWheels;
	private int maxSpeed;
	private String color;
	
	
	public int getNumWheels() {
		return numWheels;
	}
	public void setNumWheels(int numWheels) {
		this.numWheels = numWheels;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public abstract void drive();
	
	public abstract void brake();
	
	public void accelerate(double percentageDown) {
		drive();
	}
	public void decelerate(double percentageDown) {
		brake();
	}
	
}
