/*
	Author	: Tom Choi
	Date	: 08/07/2016

	Implementatino of Insertion Sort
*/

public class InsertionSort extends ArrayInit{
	public InsertionSort(){
		super();
	}
	
	public InsertionSort(int size){
		super(size);
	}
	
	public int[] sort(){
		// choose an item to be sorted
		for(int i = 1; i < arr.length; i++){
			
			// compare it to the rest of the items on its left
			for(int j = i; j > 0; j--){
				if(arr[j-1] > arr[j]){
					swap(j-1, j);
				}
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args){
		InsertionSort is = new InsertionSort();
		InsertionSort is2 = new InsertionSort(20);
		
		int[] i = is.sort();
		print(i);
		
		int[] i2 = is2.sort();
		print(i2);
	}
}