import java.util.Arrays;
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
		int[] test = {1,6,3,2,87,4,2,31,165,16,4,16,14,15,31,1};
		heapify(test);
		System.out.println(Arrays.toString(test));
		
		
	}
	
	
}