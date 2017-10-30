package algorithm;


import java.util.*;
public class LRUCache {
  
  public static void main(String[] args)  {
    
    LRUCache cache = new LRUCache(5);
    
    cache.put("one", "1");
        cache.put("two", "2");
        cache.put("three", "3");
        cache.put("four", "4");
        cache.put("five", "5");
    
    System.out.println(cache.get("five"));
    
    cache.put("six", "6");
    
    System.out.println(cache.get("one"));
    
  }
  
  
  
}

class LRUCache {
  
  
  Map<String, ListNode> map;
  ListNode head = null;
  ListNode tail = null;
  int capacity = 0;
  int size = 0;
  
  LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<String, ListNode>();
    
  }
  
  public void put(String key, String value) {
      ListNode node = new ListNode(key, value);
    
      map.put(key, node);
      movetoHead(node);
      
     if (map.size() > capacity) {
       map.remove(tail.key);
       removeNode(tail);
     }
      
  }
  
  public void removeNode(ListNode node) {
   
   ListNode prev = node.prev;
    ListNode next = node.next;
    
    if (prev != null) {
      prev.next = next;
    } else {
      head = node.next;
    }
    
    if (next != null) {
      next.prev = prev;
    } else {
      tail = node.prev;
    }
    
    
    
 }
  
 public void movetoHead(ListNode node) {
   
   if (head == null) {
     node.next = null;
     node.prev= null;
     head = node;
     tail = node;
   } else {
     node.next = head;
     head.prev = node;
     head = node;
   }
 }
  
  
  public String get(String key) {
    ListNode node = map.get(key);
    if (node != null) {
      movetoHead(node);
      return node.value;
    }
    return null;
  }
  
}

class ListNode {
  
  String key;
  String value;
  ListNode prev;
  ListNode next;
  
  ListNode(String key, String value) {
    this.key = key;
    this.value = value;
  }
  
}
