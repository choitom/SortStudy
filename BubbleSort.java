/*
	Author	: Tom Choi
	Date	: 08/07/2016
	
	Sort Practice - Bubble Sort
*/

public class BubbleSort extends ArrayInit{
	public BubbleSort(){
		super();
	}
	
	public BubbleSort(int size){
		super(size);
	}
	
	public int[] sort(){
		print(arr);
		boolean sorted;
		do{
			sorted = true;
			for(int i = 1; i < arr.length; i++){
				if(arr[i] < arr[i-1]){
					swap(i, i-1);
					sorted = false;
				}
			}		
		}while(!sorted);
		return arr;
	}
	
	public static void main(String[] args){
		BubbleSort bs = new BubbleSort(30);
		int[] s = bs.sort();
		print(s);
	}
}