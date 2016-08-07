/*
	Author	: Tom Choi
	Date	: 08/07/2016

	Implementation of Selection Sort
	
*/

public class SelectionSort extends ArrayInit{
	public SelectionSort(){
		super();
	}
	
	public SelectionSort(int size){
		super(size);
	}
	
	public int[] sort(){
		int min;
		int minIndex;
		
		for(int i = 0; i < arr.length - 1; i++){
			min = arr[i];
			minIndex = i;
			for(int j = i+1; j < arr.length; j++){
				if(min > arr[j]){
					min = arr[j];
					minIndex = j;
				}
			}
			swap(i, minIndex);
		}
		return arr;
	}
	
	public static void main(String[] args){
		SelectionSort selection = new SelectionSort();
		SelectionSort selection2 = new SelectionSort(20);
		
		int[] s = selection.sort();
		print(s);
		
		int[] s2= selection2.sort();
		print(s2);
	}
}