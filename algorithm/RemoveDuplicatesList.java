package algorithm;


import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class RemoveDuplicatesList {
  public static void main(String[] args) {
   
    
    ListNode n1 = new ListNode(1);
    
    ListNode n2 = new ListNode(1);
    n1.next = n2;
    
    ListNode n3 = new ListNode(1);
    n2.next = n3;
    
    ListNode n4 = new ListNode(2);
    n3.next = n4;
    
    ListNode n5 = new ListNode(2);
    n4.next = n5;
    
    ListNode n6 = new ListNode(3);
    n5.next = n6;
    
    ListNode n7 = new ListNode(3);
    n6.next=n7;
    n7.next = null;
    
    ListNode head = n1;
    
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
    
      head = n1;
    
    
     while (head != null && head.next != null) {
     
       if (head.val == head.next.val) {
         head.next = head.next.next;
       } else {
         head = head.next;
       }
    }
    
     head = n1;
    
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
    
    
  }
}


class ListNode {
  int val;
  ListNode next;
  
  ListNode(int val) {
    this.val = val;
  }
  
}
