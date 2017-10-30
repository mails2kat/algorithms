package algorithm;

import java.util.Iterator;

public class Queue implements Iterable<Integer>{

	//LIFO
	static Node first = null;
	static Node last = null;
	static int size = 0;
	Queue() {
		
	}
	
	public Iterator<Integer> iterator() {
		return new QueueIterator();
	}
	
	public void enqueue(int value) {
		Node node = new Node(value);
		if (first == null) {
			first = node;
			last = node;
		} else {
			last.next = node;
			last = node;
		}
		++size;
	}
	
	public int size() {
		return size;
	}
	
	public int dequeue() {
		Node temp = first;
		first = first.next;
		return temp.val;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue queue = new Queue();
		
		queue.enqueue(10);
		queue.enqueue(30);
		queue.enqueue(20);
		queue.enqueue(40);
		queue.enqueue(60);
		queue.dequeue();
		
		queue.dequeue();
		
		Iterator<Integer> it = queue.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
	
	private static class QueueIterator implements Iterator<Integer> {

		Node temp = first;
		
		@Override
		public boolean hasNext() {
			if (temp != null) {
				return true;
			}
			return false;
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			Node k = temp;
			temp = temp.next;
			return k.val;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
