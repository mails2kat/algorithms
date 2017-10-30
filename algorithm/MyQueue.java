/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author karthikeyanrajamonickam
 *
 */
public class MyQueue {
  
  Queue<Integer> queue1 = new LinkedList<Integer>();
  Queue<Integer> queue2 = new LinkedList<Integer>();
  // 5 3 10 4 2 5
  // 10
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    MyQueue q = new MyQueue();
    q.enqueue(5);
    //System.out.println(q.maximum());
    q.enqueue(3);
    //System.out.println(q.maximum());
    q.enqueue(10);
    //System.out.println(q.maximum());
    q.dequeue();
    q.dequeue();
    //System.out.println(q.maximum());
    q.enqueue(4);
    //System.out.println(q.maximum());
    q.enqueue(2);
    //System.out.println(q.maximum());
    q.enqueue(5);
    //System.out.println(q.maximum());
    q.dequeue();
    //System.out.println(q.maximum());
    q.dequeue();
    System.out.println(q.maximum());

  }
  
  public void enqueue(int k) {
    queue1.offer(k);
    if (queue2.isEmpty()) {
      queue2.offer(k);
    } else {
      if (queue2.peek() < k) {
        while (!queue2.isEmpty()) {
          queue2.poll();
        }
        queue2.offer(k);
      } else {
        int s = queue2.size();
        for (int i = 0; i<s; i++) {
          int p = queue2.poll();
          if (p >= k) {
            queue2.offer(p);
          }
        }
        queue2.offer(k);
      }
    }
  }

  public int dequeue() {
    int k = queue1.poll();
    if (k == queue2.peek()) {
      queue2.poll();
    }
    return k;
  }
  
  public int maximum() {
    return queue2.peek();
  }
}
