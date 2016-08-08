/*
	Author	: Tom Choi
	Date	: 08/07/2016
	
	Sort Practice - Selection Sort
*/

public class SelectionSort extends ArrayInit{
	public SelectionSort(){
		super();
	}
	
	public SelectionSort(int size){
		super(size);
	}
	
	public int[] sort(){
		print(arr);
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
			if(i != minIndex){
				swap(i, minIndex);
			}
		}
		return arr;
	}
	
	public static void main(String[] args){
		SelectionSort ss = new SelectionSort(30);
		int[] s = ss.sort();
		print(s);
	}
}