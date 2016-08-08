public class Queue{
	private int[] q;
	private int size;
	
	public Queue(){
		init();
	}
	
	private void init(){
		q = new int[50];
		size = 0;
	}
	
	private void ensureCapacity(){
		int[] temp = new int[2 * q.length];
		for(int i = 0; i < q.length; i++){
			temp[i] = q[i];
		}
		q = temp;
	}
	
	private void moveLeft(){
		for(int i = 1; i < q.length; i++){
			q[i-1] = q[i];
		}
		q[q.length-1] = 0;
	}
	
	public void push(int i){
		if(size >= q.length){
			ensureCapacity();
		}
		q[size] = i;
		size++;
	}
	
	public int dequeue(){
		if(size <= 0){
			System.out.println("Queue is empty");
			return -1;
		}
		int rItem = q[0];
		moveLeft();
		size--;
		return rItem;
	}
	
	public int size(){
		return size;
	}
	
	public void print(){
		for(int i = 0; i < size; i++){
			System.out.print(q[i] + " ");
		}System.out.println();
	}
	
	public boolean isEmpty(){
		if(size == 0){
			return true;
		}else{
			return false;
		}
	}
	
	
	public static void main(String[] args){
		Queue q = new Queue();
		for(int i = 0; i < 100; i++){
			q.push(i);
		}
		q.print();
		System.out.println(q.size());
		for(int i = 0; i < 10; i++){
			int v = q.dequeue();
			System.out.println(v);
		}
		q.print();
		System.out.println(q.size());
	}
}