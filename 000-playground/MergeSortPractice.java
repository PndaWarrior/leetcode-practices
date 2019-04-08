
public class MergeSortPractice {
	
	public void merge(int[] array , int start, int end, int mid) {
		int leftLength = mid-start+1;
		int[] left = new int[leftLength];
		int rightLength = end-mid;
		int[] right = new int[rightLength];
		
		for(int i = 0; i < leftLength; i++) {
			left[i] = array[start + i];
		}
		
		for(int i = 0; i < rightLength; i++) {
			right[i] = array[mid + 1 + i];
		}
		
		int i = 0,
				j = 0,
				k = start;
		
		while(i < leftLength && j < rightLength) {
			
			
			if(left[i] < right[j]) {
				array[k] = left[i];
				++i;
			}
			else {
				array[k] = right[j];
				++j;
			}
			
			++k;
			
		}
		
		while(i < leftLength) {
			array[k] = left[i];
			++k;
			++i;
		}
		
		while(j < rightLength) {
			array[k] = right[j];
			++k;
			++j;
		}
		
	}
	
	public void sort(int[] array, int start, int end) {
		if(start < end) {

			int mid = (end+start) /2;
			
			sort(array, start, mid);
			sort(array, mid+1, end);
			
			merge(array, start, end, mid);
			
		} else {
//			System.out.println("Encountered where start not smaller than end, print");
//			System.out.println("curent start : " + start);
//			System.out.println("current end : " + end);
//			printArray(array);
		}

	}
	
	
	public int[] mergeSort(int[] array) {
		
		sort(array, 0, array.length-1);
		
		return array;
		
	}
	
	
	public static void main(String[] args) {
		MergeSortPractice sorter = new MergeSortPractice();
		
		int[] question = {6, 2, 8, 3, 7, 1, 4};
		
		int[] sortedArray = sorter.mergeSort(question);
		
		printArray(sortedArray);
		
	}
	
	
	public static void printArray(int[] array) {
		System.out.print("[ ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.print(" ]");
		System.out.println();
		
	}
	
	
	
	

}
