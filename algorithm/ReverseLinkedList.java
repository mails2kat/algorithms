package algorithm;



public class ReverseLinkedList {
	  
	  public static void main(String[] args) {
	    
	    ListNode f1 = new ListNode(10);
	    ListNode head = f1;
	    
	    
	     ListNode f2 = new ListNode(20);
	    f1.next = f2;
	    
	    ListNode f3 = new ListNode(30);
	    f2.next = f3;
	    f3.next = null;
	    
	    ListNode result = reverse(head);
	    
	    while (result != null) {
	      System.out.println(result.val);
	      result = result.next;
	    }
	    
	    
	  }
	  
	  private static ListNode reverse(ListNode head) {
	    
	    ListNode current = head;
	    ListNode temp = null;
	    ListNode first;
	    
	    while (current != null) {
	      
	      first = current.next;
	      
	      current.next = temp;
	      temp = current;
	      current = first;
	      
	    }
	    
	    return temp;
	    
	  }
	  
	  
	  
	}

	class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int val) {
	      this.val = val;
	    }
	    
	    ListNode(int val, ListNode node) {
        this.val = val;
        this.next = node;
      }
	  
	}
