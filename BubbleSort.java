/*
	Author	: Tom Choi
	Date	: 08/07/2016
	
	Implementation of Bubble Sort
	
*/

public class BubbleSort extends ArrayInit{
	public BubbleSort(){
		super();
	}
	
	public BubbleSort(int size){
		super(size);
	}
	
	public int[] sort(){
		boolean flag = true;
		
		while(flag){
			flag = false;
			for(int i = 1; i < arr.length; i++){
				if(arr[i-1] > arr[i]){
					swap(i-1, i);
					flag = true;
				}
			}
		}
		return arr;
	}
	
	public static void main(String[] args){
		BubbleSort bubble = new BubbleSort();
		BubbleSort bubble2 = new BubbleSort(20);
		
		int[] b1 = bubble.sort();
		print(b1);
		
		int[] b2 = bubble2.sort();
		print(b2);
	}
}