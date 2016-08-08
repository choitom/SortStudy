import java.util.Random;

/*
	Author	: Tom Choi
	Date	: 08/07/2016
	
	Sort Practice - Random Quick Sort
*/

public class RQuickSort extends ArrayInit{
	public RQuickSort(){
		super();
	}
	
	public RQuickSort(int size){
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
		// find a random pivot and move it to the front of the list
		Random rand = new Random();
		int randIndex = rand.nextInt(high - low + 1) + low;
		swap(low, randIndex);
		
		int pivot = arr[low];
		int wall = low + 1;
		for(int i = low + 1; i <= high; i++){
			if(pivot > arr[i]){
				swap(i, wall);
				wall++;
			}
		}
		swap(--wall, low);
		return wall;
	}
	
	public static void main(String[] args){
		RQuickSort rqs = new RQuickSort(30);
		int[] s = rqs.sort();
		print(s);
	}
}