/*
	Author	: Tom Choi
	Date	: 08/07/2016
	
	Sort Practice - Count Sort
*/

public class CountSort extends ArrayInit{
	public CountSort(){
		super();
	}
	
	public CountSort(int size){
		super(size);
	}
	
	public int[] sort(){
		print(arr);
		int[] output = new int[arr.length];
		int[] count = new int[findMax() + 1];
		
		// count the frequencies of each number in arr
		for(int i = 0; i < arr.length; i++){
			count[arr[i]]++;
		}
		
		// sum of counts
		for(int i = 1; i < count.length; i++){
			count[i] = count[i-1] + count[i];
		}
		
		// find the index of each number from count array
		for(int i = 0; i < output.length; i++){
			output[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		return output;
	}
	
	private int findMax(){
		int max = arr[0];
		for(int i = 0; i < arr.length; i++){
			if(max < arr[i]){
				max = arr[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args){
		CountSort cs = new CountSort(30);
		int[] s = cs.sort();
		print(s);
	}
}