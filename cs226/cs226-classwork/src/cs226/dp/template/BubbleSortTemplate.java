package cs226.dp.template;

public abstract class BubbleSortTemplate {
	void sort() {
		boolean didSort;
		
		do {
			didSort = false;
			
			for (int i = 0; i < .length - 1; ++i) {
				if (compare(i) > 0) {
					swap(i);
					didSwap = true;
					}
				}
			}
		while(didSort);
	}
	
	public int compare(int index) {
		return compare(index, index + 1);
	}
	
	public abstract int length() {
		
	}
	
	public abstract int swap(int index_first, int index_second) {
		
	}
}
