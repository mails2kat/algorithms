package algorithm;


import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class CyclicLinkedList {
  public static void main(String[] args) {
   
    
    ListNode n1 = new ListNode(1);
    
    ListNode n2 = new ListNode(2);
    n1.next = n2;
    
    ListNode n3 = new ListNode(3);
    n2.next = n3;
    
    ListNode n4 = new ListNode(4);
    n3.next = n4;
    
    ListNode n5 = new ListNode(5);
    n4.next = n5;
    
    ListNode n6 = new ListNode(6);
    n5.next = n6;
    
    ListNode n7 = new ListNode(7);
    n6.next=n7;
    n7.next = n4;
    
    ListNode head = n1;
    /*
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
    */
   //boolean isCyclic = hasLoop(head);
     // System.out.println(isCyclic);
    
    System.out.println(cyclicNode(head).val);
    
    
  }
  
  
  private static boolean hasLoop(ListNode head) {
    
   
    ListNode slow = head;
    ListNode fast = head;
    
    while (slow!=null && fast!=null) {
      
      fast = fast.next;
      
      if (fast == null) {
        return false;
      }
      
      if (slow == fast) {
        return true;
      }
      
      fast = fast.next;
      
      if (slow == fast) {
        return true;
      }
      
      slow = slow.next;
      
    }
    
    return false;
    
  }
  
   private static ListNode cyclicNode(ListNode head) {
    
     ListNode cycle = null;
   
    ListNode slow = head;
    ListNode fast = head;
    boolean value = false;
      System.out.println("isCyclic:" + value);
    while (slow!=null && fast!=null) {
      
      fast = fast.next;
      
      if (fast == null) {
        value = false;
         break;
      }
      
      if (slow == fast) {
        value = true;
        break;
      }
      
      fast = fast.next;
      
      if (slow == fast) {
        value = true;
         break;
      }
      
      slow = slow.next;
      
    }
    System.out.println("isCyclic:" + value);
    if (value) {
      slow = head;
      while (slow != fast) {
        System.out.println(slow.val);
        slow = slow.next;
        //fast = fast.next;
      }
      cycle= slow;
    }
    return cycle;
  }
}


class ListNode {
  int val;
  ListNode next;
  
  ListNode(int val) {
    this.val = val;
  }
  
}