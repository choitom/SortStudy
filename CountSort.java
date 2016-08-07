/*
	Author	: Tom Choi
	Date	: 08/07/2016
	
	Implementation of Count Sort
	
*/

public class CountSort extends ArrayInit{
	public CountSort(){
		super();
	}
	
	public CountSort(int size){
		super(size);
	}
	
	public int[] sort(){
		int[] output = new int[arr.length];
		int[] count = new int[findMax()+1];
		
		// store the frequencies of each number in arr
		for(int i = 0; i < arr.length; i++){
			count[arr[i]]++;
		}
		
		// add previous and current frequencies
		for(int i = 1; i < count.length; i++){
			count[i] = count[i-1] + count[i];
		}
		
		// for each item in arr, find its corresponding index from count
		// and store it into output, and decrease the index by 1
		for(int i = 0; i < arr.length; i++){
			output[count[arr[i]]-1] = arr[i];
			count[arr[i]]--;
		}
		return output;
	}
	
	private int findMax(){
		int max = arr[0];
		for(int i = 1; i < arr.length; i++){
			if(arr[i] > max){
				max = arr[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args){
		CountSort cs = new CountSort();
		CountSort cs2 = new CountSort(20);
		
		int[] s = cs.sort();
		int[] s2 = cs2.sort();
		
		print(s);
		print(s2);
	}
}