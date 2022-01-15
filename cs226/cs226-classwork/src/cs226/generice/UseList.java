package cs226.generice;

import java.util.List;
import java.util.ArrayList;

public class UseList {
	public static void main(String[] args) {
	List media = new ArrayList();
	
	Object[] albums = new Object[3];
	albums[1] = new Video();
	
	media.add(new Album());
	media.add(new Album());
	
	media.add(new Video());
	
	for (int i = 0; i < media.size(); i++) {
		System.out.println(media.get(i));
	}
	
	}
}
