/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package algorithm;

/**
 * @author karthikeyanrajamonickam
 *
 */
public class ReverseLinkedListInGroup {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    Node n1 = new Node(10);
    Node n2 = new Node(20);
    Node n3 = new Node(30);
    Node n4 = new Node(40);
    Node n5 = new Node(50);
    Node n6 = new Node(60);
    Node n7 = new Node(70);
    
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = n7;
    n7.next = null;
    
    Node head = n1;
    
    //Node prev = reverse(head, 3);
    Node prev = reverse(head, 2);
    
    while (prev != null) {
      System.out.println(prev.value);
      prev = prev.next;
    }

  }

  /**
   * @param head
   * 10 -> 20 -> 30 -> 40 -> 50
   * 
   * 30 - 20 - 10 - 50 - 40
   */
  private static Node reverse(Node head, int count) {
    
    Node current = head;
    Node prev = null;
    Node first;
    
    int t = 0;
    while (current != null && t < count) {
      first = current.next;
      current.next = prev;
      prev = current;
      current = first;
      ++t;
    }
    if (current != null) {
      head.next = reverse(current, count);
    }
    return prev;
  }

}


class Node {
  int value;
  Node next;
  
  Node(int value) {
    this.value = value;
  }
}