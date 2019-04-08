
public class QuickSortPractice {
	
	public static void printArray(int[] array) {
		System.out.print("[ ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.print(" ]");
		System.out.println();
		
	}
	
	public void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public int partition(int[] array, int start, int end) {
		int pivot = array[end];
		
//		i  is being used to keep track of where the most left item is for all the items that are bigger than the pivot.
//		for example, [4,5,6,2,3], pivot is 3, and there are 3 items that are bigger than 3, when j reaches the number 2, I need to swap 2 to the left
//		of all the items that are bigger than 3, and i is at -1, so I move i over 1 and swap.  
//		i needs to be to the left of j at all times.  By doing so, I know that i+1 is always going to be bigger than pivot.
		
		int i = start-1;
		
		for(int j = start; j < end; j++ ) {
			
			if(array[j] <= pivot) {
				++i;
				swap(array, i, j);
			}
		}
		
		//I need to do one more swap at the end, because I need to swap the pivot to be right after i
		swap(array, i+1, end);
		
		return i+1;
	}
	
	public void sort(int[] array, int start, int end) {
		if(start < end) {
			int pivotIndex = partition(array, start, end);
			
			sort(array, start, pivotIndex - 1);
			sort(array, pivotIndex + 1, end);
			
		} else {
//			System.out.println("Encountered where start not smaller than end, print");
//			System.out.println("curent start : " + start);
//			System.out.println("current end : " + end);
//			printArray(array);
		}
		
		
		
	}
	
	public int[] quickSort(int[] array) {
		
		
		sort(array, 0, array.length-1);
		
		return array;
	}
	

	public static void main(String[] args) {

		QuickSortPractice sorter = new QuickSortPractice();

		int[] question = {6, 2, 8, 3, 7, 1, 4};
		
		int[] sortedArray = sorter.quickSort(question);
		
		printArray(sortedArray);

	}

}
