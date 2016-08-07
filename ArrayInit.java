import java.util.Random;

/*
	Author	: Tom Choi
	Date	: 08/07/2016
	
	Creates an array with random integers
*/

public abstract class ArrayInit{
	protected int[] arr;
	
	public ArrayInit(){
		init(10);
	}
	
	public ArrayInit(int size){
		init(size);
	}
	
	protected void swap(int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private void init(int size){
		Random rand = new Random();
		arr = new int[size];
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = rand.nextInt(101);
		}
	}
	
	public static void print(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}System.out.println();
	}
	
	public abstract int[] sort();
}