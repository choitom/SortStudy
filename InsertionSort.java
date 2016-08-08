/*
	Author	: Tom Choi
	Date	: 08/07/2016
	
	Sort Practice - Insertion Sort
*/

public class InsertionSort extends ArrayInit{
	public InsertionSort(){
		super();
	}
	
	public InsertionSort(int size){
		super(size);
	}
	
	public int[] sort(){
		print(arr);
		for(int i = 1; i < arr.length; i++){
			for(int j = i; j > 0; j--){
				if(arr[j] > arr[j-1]){
					break;
				}else{
					swap(j, j-1);
				}
			}
		}
		return arr;
	}
	
	public static void main(String[] args){
		InsertionSort is = new InsertionSort(30);
		int[] s = is.sort();
		print(s);
	}
}