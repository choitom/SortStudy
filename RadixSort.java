import java.util.Random;

/*
	Author	: Tom Choi
	Date	: 08/08/2016
	
	Impelementation of Radix Sort that sorts numbers by digits
	
	Pseudocode
	1. Create an array with random numbers
	2. Create a bucket that holds a queue for each digit (0 ~ 9)
	3. Starting from 1's digit to the max digit
		For each number in the array, find the digit and store it into
		its corresponding bucket
		
		Dequeue everything from the bucket in order from 0 to 9
		and put them back into the array
		
	
	Analysis
		Let k: maxDigit, n: size of array
		-> O(k*n) = O(n)
*/

public class RadixSort{
	private int[] arr;
	private Queue[] bucket;
	
	public RadixSort(int size, int range){
		init(size, range);
	}
	
	public int[] sort(){
		int maxDigit = findMaxDigit();
		
		// for each digit
		for(int i = 0; i < maxDigit; i++){
			
			// for each number in the arr
			for(int j = 0; j < arr.length; j++){
				
				// find the digit, put it into its corresponding bucket
				int num = arr[j];
				int digit = findDigit(num, i);
				bucket[digit].push(num);
			}
			
			// restore the bucket
			restoreBucket();
		}
		return arr;
	}
	
	private void restoreBucket(){
		int temp[] = new int[arr.length];
		int index = 0;
		for(int i = 0; i < bucket.length; i++){
			Queue q = bucket[i];
			while(!q.isEmpty()){
				temp[index++] = q.dequeue();
			}
		}
		arr = temp;
	}
	
	private int findDigit(int num, int i){
		String numStr = String.valueOf(num);
		int index = numStr.length() - i - 1;
		int digit;
		if(index < 0){
			digit = 0; 
		}else{
			digit = Character.digit(numStr.charAt(index), 10);
		}
		return digit;
	}
	
	private int findMaxDigit(){
		int max = arr[0];
		for(int i = 1; i < arr.length; i++){
			if(arr[i] > max){
				max = arr[i];
			}
		}
		int maxDigit = 0;
		while(max > 0){
			max = max / 10;
			maxDigit++;
		}
		return maxDigit;
	}
	
	private void init(int size, int range){
		arr = new int[size];
		bucket = new Queue[10];
		Random rand = new Random();
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = rand.nextInt(range + 1);
		}
		
		for(int i = 0; i < bucket.length; i++){
			bucket[i] = new Queue();
		}
	}
	
	
	public static void print(int[] lst){
		for(int i = 0; i < lst.length; i++){
			System.out.print(lst[i] + " ");
		}System.out.println();
	}
	
	public static void main(String[] args){
		RadixSort rs = new RadixSort(100, 10000000);
		int[] s = rs.sort();
		print(s);
	}
}