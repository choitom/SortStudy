/*
	Author	: Tom Choi
	Date	: 08/07/2016

	Implementation of Binary Search
*/

public class BinarySearch{
	private int[] arr;
	
	public BinarySearch(int[] arr){
		this.arr = arr;
	}
	
	public int search(int i){
		int index = searchHelper(i, 0, arr.length-1);
		return index;
	}
	
	private int searchHelper(int i, int low, int high){

		if (low > high){
			return -1;
		}
		
		int mid = (low + high) / 2;
		
		// if the number found return its index
		if(i == arr[mid]){
			return mid;
		}
		
		// if the number less than the current one,
		// search the lower half
		else if(i < arr[mid]){
			return searchHelper(i, low, mid-1);
		}
		
		// if the number greater than the current one,
		// search the upper half
		else{
			return searchHelper(i, mid+1, high);
		}
	}
	
	public static void main(String[] args){
		QuickSort q = new QuickSort(100);
		int[] arr = q.sort();
		
		int num = 30;
		BinarySearch b = new BinarySearch(arr);
		int index = b.search(num);
		
		if(index < 0){
			System.out.println("The number(" + num + ") you are searching is not in the list.");
		}else{
			System.out.println("The index of " + num + " is: " + index);
			
			for(int i = 0; i < arr.length; i++){
				if(i == index){
					System.out.print("[" + arr[i] + "] ");
				}else{
					System.out.print(arr[i] + " ");	
				}
			}
		}
	}
}