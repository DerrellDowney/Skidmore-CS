package sorter;

import java.util.Collections;
import java.util.List;

public class Sorter implements Runnable{
	private List data;
	
	public void setData(List data) {
		this.data = data;
	}
	
	public void doSort(){
		synchronized(Sorter.class) {
		System.out.println("doSort start");
		Collections.sort(data);
		System.out.println("doSort end");
		}
	}
	
	public void run() {
		doSort();
	}
}
