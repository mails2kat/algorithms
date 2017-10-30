package algorithm;

import java.util.Iterator;

public class Stack implements Iterable<Integer>{

	//LIFO
	SNode top = null;
	int size = 0;
	Stack() {
		
	}
	
	public Iterator<Integer> iterator() {
		return new StackIterator(this);
	}
	
	public void push(int value) {
	  SNode node = new SNode(value);
		if (top == null) {
			top = node;
			top.next = null;
		} else {
			node.next = top;
			top = node;
		}
		++size;
	}
	
	public int size() {
		return size;
	}
	
	public int pop() {
	  SNode temp = top;
		top = top.next;
		--size;
		return temp.val;
	}
	
	public int peek() {
		if (top != null) {
			return top.val;
		}
		return 0;
	}
	
	public boolean isEmpty() {
	  return (size == 0);
	}
	
	public Stack sort() {
	  
	  Stack s = new Stack();
	  
	  while (!this.isEmpty()) {
	    int temp = this.pop();
	    System.out.println("temp: " + temp);
	    while (!s.isEmpty() && s.peek() > temp) {
	      int p = s.pop();
	      System.out.println("pop: " + p);
	      this.push(p);
	    }
	    s.push(temp);
	  }
	  
	  return s;
	  
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack stack = new Stack();
		
		stack.push(10);
		stack.push(30);
		stack.push(20);
		stack.push(40);
		stack.push(60);
		stack.push(25);
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
		/*
		stack.pop();
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
		*/
		Stack result = stack.sort();
		System.out.println("*****");
		Iterator<Integer> it = result.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
	
	private static class StackIterator implements Iterator<Integer> {

	  SNode temp = null;
	  
	  StackIterator(Stack stack) {
	    temp = stack.top;
	  }
		
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
		  SNode k = temp;
			temp = temp.next;
			return k.val;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}

class SNode {
	int val;
	SNode next;
	SNode(int val) {
		this.val = val;
	}
}