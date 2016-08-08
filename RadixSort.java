import java.util.Random;

/*
	Author	: Tom Choi
	Date	: 08/08/2016
	
	Pseudocode:
	
	Create 10 buckets for each digit (0 ~ 9)
	for each digit placing
		for each element in list
			move element into respective bucket
		for each bucket, starting from smallest digit
			restore element to list
*/

public class RadixSort{
	private int[] arr;
	private Queue[] bucket;
	
	public RadixSort(int size){
		init(size);
	}
	
	private void init(int size){
		Random rand = new Random();
		bucket = new Queue[10];
		arr = new int[size];
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = rand.nextInt(100000);
		}
		
		for(int i = 0; i < bucket.length; i++){
			bucket[i] = new Queue();
		}
	}
	
	public int[] sort(){
		int maxDigit = findMaxDigit();
		
		
		// for each digit placing
		for(int i = 0; i < maxDigit; i++){
			
			// for each number, find digit move it to its corresponding bucket
			for(int j = 0; j < arr.length; j++){
				int num = arr[j];
				int digit = findDigit(num, i);
				bucket[digit].push(num);
			}
			restoreBucket();
		}
		return arr;
	}
	
	// dequeue everyting in order
	private void restoreBucket(){
		int[] temp = new int[arr.length];
		int index = 0;
		for(int i = 0; i < bucket.length; i++){
			Queue q = bucket[i];
			while(!q.isEmpty()){
				int v = q.dequeue();
				temp[index++] = v;
			}
		}
		arr = temp;
	}
	
	private int findDigit(int num, int dPoint){
		String number = String.valueOf(num);
		
		int index = number.length() - dPoint - 1;
		int digit;
		if (index < 0){
			digit = 0;
		}else{
			digit = Character.digit(number.charAt(index), 10);
		}
		return digit;
	}
	
	private int findMaxDigit(){
		int max = arr[0];
		for(int i = 0; i < arr.length; i++){
			if(max < arr[i]){
				max = arr[i];
			}
		}
		
		int digit = 0;
		while(max > 0){
			max = max/10;
			digit++;
		}
		return digit;
	}
	
	public static void print(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}System.out.println();
	}
	
	public static void main(String[] args){
		RadixSort rs = new RadixSort(1000);
		int[] s = rs.sort();
		print(s);
	}
}