import java.util.Random;

/*
	Author	: Tom Choi
	Date	: 08/07/2016

	Implementation of Random Quick Sort
	
*/

public class RQuickSort extends ArrayInit{
	private Random rand = new Random();
	
	public RQuickSort(){
		super();
	}
	
	public RQuickSort(int size){
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
		// find a random index for pivot and move it to the very front
		int randIndex = rand.nextInt(high - low + 1) + low;
		swap(low, randIndex);
		int pivot = arr[low];
		
		// move all the items less than the pivot to the left side of the wall
		int wall = low + 1;
		for(int i = low + 1; i <= high; i++){
			if(arr[i] < pivot){
				swap(i, wall);
				wall++;
			}
		}
		swap(--wall, low);
		return wall;
	}
	
	public static void main(String[] args){
		RQuickSort rqs = new RQuickSort();
		RQuickSort rqs2 = new RQuickSort(20);
		
		int[] s = rqs.sort();
		int[] s2 = rqs2.sort();
		
		print(s);
		print(s2);
	}
}