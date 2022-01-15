package sorter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UseSorter {
	public static void main(String[] args) {
		List data = new ArrayList();
		List data2 = new ArrayList();
		Random rand = new Random();
		for (int i = 0; i < 1000000; i ++) {
			data.add(-1 * rand.nextInt(1000000));
		}
		for (int i = 0; i < 1000000; i ++) {
			data2.add(rand.nextInt(1000000));
		}
		
		System.out.println("Negative list");
		for(int i = 0; i < 10; i++) {
			System.out.println(data.get(i));
		}
		System.out.println("Positive list");
		for(int i = 0; i < 10; i++) {
			System.out.println(data2.get(i));
		}
		
		Sorter sorter = new Sorter();
		Sorter sorter2 = new Sorter();
		sorter.setData(data);
		sorter2.setData(data2);

		Thread thread = new Thread(sorter);
		Thread thread2 = new Thread(sorter2);
		System.out.println("Starting sort thread");
		//sorter.run();
		thread.start();
		thread2.start();
		System.out.println("Ending Sort thread");
		
		for(char x = 'A'; x < 'J'; x++) {
			System.out.println(x);
		}
		
		try {
			thread.join();
		}
		catch(Throwable t) {
			t.printStackTrace();
		}
		
		System.out.println("negative Sorted Data");
		for(int i = 0; i < 10; i++) {
			System.out.println(data.get(i));
		}
		System.out.println("positive Sorted Data");
		for(int i = 0; i < 10; i++) {
			System.out.println(data2.get(i));
		}
		
	}
}
