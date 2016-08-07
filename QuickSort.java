/*
	Author	: Tom Choi
	Date	: 08/07/2016

	Implementation of Quick Sort
*/

public class QuickSort extends ArrayInit{
	public QuickSort(){
		super();
	}
	
	public QuickSort(int size){
		super(size);
	}
	
	public int[] sort(){
		sortHelper(0, arr.length-1);
		return arr;
	}
	
	private void sortHelper(int low, int high){
		if(low < high){
			int p = partition(low, high);
			sortHelper(low, p-1);
			sortHelper(p+1, high);
		}
	}
	
	private int partition(int low, int high){
		int pivot = arr[low];
		int wall = low + 1;
		
		for(int i = low + 1; i <= high; i++){
			//compare the rest of the items with the pivot
			if(pivot > arr[i]){
				swap(i, wall);
				wall++;
			}
		}
		swap(--wall, low);
		return wall;
	}
	
	public static void main(String[] args){
		QuickSort qs = new QuickSort();
		QuickSort qs2 = new QuickSort(20);
		
		int[] q = qs.sort();
		int[] q2 = qs2.sort();
		
		print(q);
		print(q2);
	}
}