package cs226.arrays;

import java.util.Random;

public class Arrays {
	public int[] intArray() {
		int [] arr = new int[15];
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt();
		}
		
		return arr;
	}
	
	public Animal[] setupAnimals() {
		Animal[] animals = new Animal[6];
		Random rand = new Random();
		
		for (int i = 0; i < animals.length; i++) {
			if(rand.nextInt(2) == 0) {
				animals[i] = new Cat();
			}
			else {
				animals[i] = new Dog();
			}
		}
		return animals;
	}
	
	public static void main(String[] args) {
		Arrays instance = new Arrays();
		int[] numbers = instance.intArray();
		
		for(int i = 0; i < numbers.length; i++) {
			System.out.println("Index" + i + " = " + numbers[i]);
		}
		System.out.println("----------");
		
		Animal[] animals = instance.setupAnimals();
		for(int i = 0; i < animals.length; i++) {
			System.out.println("Index" + i + " = " + animals[i].sound());
		}
		
		System.out.println("----------");
		
		for(Animal catDog: animals) {
			System.out.println(catDog.sound());
		}
		
	}
}
