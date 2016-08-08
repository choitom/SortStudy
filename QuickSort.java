/*
	Author	: Tom Choi
	Date	: 08/07/2016
	
	Sort Practice - Quick Sort
*/

public class QuickSort extends ArrayInit{
	public QuickSort(){
		super();
	}
	
	public QuickSort(int size){
		super(size);
	}
	
	public int[] sort(){
		print(arr);
		quickSort(0, arr.length-1);
		return arr;
	}
	
	private void quickSort(int low, int high){
		if(low < high){
			int p = partition(low, high);
			quickSort(low, p-1);
			quickSort(p+1, high);
		}
	}
	
	private int partition(int low, int high){
		int pivot = arr[low];
		int wall = low + 1;
		
		for(int i = low + 1; i <= high; i++){
			if(arr[i] < pivot){
				swap(wall, i);
				wall++;
			}
		}
		swap(--wall, low);
		return wall;
	}
	
	public static void main(String[] args){
		QuickSort qs = new QuickSort(30);
		int[] s = qs.sort();
		print(s);
	}
}