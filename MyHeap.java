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
		int next;
		if(2*index + 2 <= size) {
			next = getMax(data,2*index + 1,2*index + 2);
		}
		else { 
			next = 2*index + 1;
		}
		while(next <= size && data[next] > data[index]) {
			swap(data,index,next);
			index = next;
			if(2*index + 2 < size) {
				next = getMax(data,2*index + 1,2*index + 2);
			}
			else { 
				next = 2*index + 1;
			}
		}
	}
	
	public static void heapify(int[] data) {
		for(int i = data.length-1; i >= 0; i--) {
			pushDown(data,data.length-1,i);
		}
	}
	
	public static void heapsort(int[] data) {
		heapify(data);
		for(int i = data.length-1; i > 0; i--) {
			pushDown(data,i,0);
			swap(data,0,i);
		}
	}
	
	
	public static void main(String[] args) {
		Random r = new Random(System.currentTimeMillis());
		int size = Integer.parseInt(args[0]);
		int[] test = new int[size];
		int[] compare = new int[size];
		for(int i = 0; i < test.length; i++) {
			test[i] = Math.abs(r.nextInt() % 100);
			compare[i] = test[i];
		}
		long x = System.currentTimeMillis();
		heapsort(test);
		System.out.println((System.currentTimeMillis() - x) + " milliseconds");
		Arrays.sort(compare);
		System.out.println(Arrays.equals(test,compare));
		
	}
	
	
}