/*
	Author	: Tom Choi
	Date	: 08/07/2016
	
	Sort Practice - Merge Sort
*/

public class MergeSort extends ArrayInit{
	public MergeSort(){
		super();
	}
	
	public MergeSort(int size){
		super(size);
	}
	
	public int[] sort(){
		print(arr);
		divide(arr);
		return arr;
	}
	
	private void divide(int[] lst){
		if(lst.length > 1){
			int[] l = leftHalf(lst);
			int[] r = rightHalf(lst);
			divide(l);
			divide(r);
			merge(lst, l, r);
		}
	}
	
	// get the left half
	private int[] leftHalf(int[] lst){
		int size = lst.length/2;
		int[] l = new int[size];
		for(int i = 0; i < l.length; i++){
			l[i] = lst[i];
		}
		return l;
	}
	
	// get the right half
	private int[] rightHalf(int[] lst){
		int size = lst.length - lst.length/2;
		int[] r = new int[size];
		for(int i = 0; i < r.length; i++){
			r[i] = lst[i+(lst.length/2)];
		}
		return r;
	}
	
	// merge the left and right halves into the result
	private void merge(int[] result, int[] left, int[] right){
		int l = 0;
		int r = 0;
		int i = 0;
		
		// start copying into the result until
		// either left or right runs out of items
		while(l < left.length && r < right.length){
			if(left[l] < right[r]){
				result[i] = left[l++];
			}else{
				result[i] = right[r++];
			}i++;
		}
		
		// copy the remainder items into the result
		if(l < left.length){
			while(l < left.length){
				result[i++] = left[l++];
			}
		}else{
			while(r < right.length){
				result[i++] = right[r++];
			}
		}
	}
	
	public static void main(String[] args){
		MergeSort ms = new MergeSort(30);
		int[] s = ms.sort();
		print(s);
	}
}