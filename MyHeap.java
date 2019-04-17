import java.util.*;
public class MyHeap {
	
	private static int getMax(int[] data, int one, int two) {
		if(data[one] > data[two]) {
			return one;
		}
		else {
			return two;
		}
	}
	
	private static void swap(int[] data, int one, int two) {
		int temp = data[one];
		data[one] = data[two];
		data[two] = temp;
	}
	
	private static void pushDown(int[] data, int size, int index) {
		while(2*index + 1 < size && (data[index] < data[2*index + 1] || data[index] < data[2*index + 2])) {
			int next = getMax(data,2*index + 1,2*index + 2);
			swap(data,index,next);
			index = next;
		}
	}
	
	public static void heapify(int[] data) {
		for(int i = data.length-1; i >=0; i--) {
			pushDown(data,data.length-1,i);
		}
	}
	
	
	
	public static void main(String[] args) {
		Random r = new Random(System.currentTimeMillis());
		int size = Integer.parseInt(args[0]);
		int[] test = new int[size];
		for(int i = 0; i < test.length; i++) {
			test[i] = Math.abs(r.nextInt() % 100);
		}
		long x = System.currentTimeMillis();
		heapify(test);
		System.out.println((System.currentTimeMillis() - x) + " milliseconds");
		
	}
	
	
}