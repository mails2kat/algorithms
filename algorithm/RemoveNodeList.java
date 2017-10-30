package algorithm;


import java.util.*;
public class RemoveNodeList {
  
 static  ListNode head;
  public static void main(String[] args)  {
    
    
    ListNode node1 = new ListNode(6);
    head = node1;
    
    ListNode node2 = new ListNode(4);
    node1.next = node2;
    
     ListNode node3 = new ListNode(6);
    node2.next = node3;
    
     ListNode node4 = new ListNode(5);
    node3.next = node4;
    
     ListNode node5 = new ListNode(6);
    node4.next = node5;
    
    while (head!=null) {
      System.out.println(head.value);
      head = head.next;
    }
    head = node1;
    
    ListNode temp = remove(6);
    while (temp!=null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
    
  }
  
  private static ListNode remove(int k) {
    
    ListNode temp = new ListNode(0);
    
    temp.next = head;
    
    ListNode current = temp;
    
    while (current!= null && current.next != null) {
     // System.out.println(current.next.value);
      if (current.next.value == k) {
        current.next = current.next.next;
      } else {
        current = current.next;
      }
      
      
    }
    return temp.next;
    
    
  }
  
  
}



class ListNode {
  
  int value;
  ListNode next;
  
  ListNode(int value) {
    this.value = value;
  }
  
}
