package algorithm;


import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class BinaryIterator {
  public static void main(String[] args) {
    
    TreeNode root = new TreeNode(50);
    
    TreeNode n1 = new TreeNode(30);
    TreeNode n2 = new TreeNode(70);
    
    root.left = n1;
    root.right = n2;
    
    
    
    TreeNode n3 = new TreeNode(10);
    TreeNode n4 = new TreeNode(40);
    
    n1.left = n3;
    n1.right = n4;
    
    TreeNode n5 = new TreeNode(60);
    TreeNode n6 = new TreeNode(80);
    
     n2.left = n5;
    n2.right = n6;
    
    BinaryIterator it = new BinaryIterator(root);
    while (it.hasNext()) {
      System.out.println(it.next());
    }
    
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int val) {
    this.val = val;
  }
}

class BinaryIterator {
  
  Stack<TreeNode> stack = null;
  BinaryIterator(TreeNode head) {
    stack = new Stack<TreeNode>();
    while (head != null) {
      stack.push(head);
      head = head.left;
    }
  }
  
  public boolean hasNext() {
    return !stack.isEmpty();
  }
  
  public int next() {
    TreeNode output = stack.pop();
    if (output.right!=null) {
      TreeNode node = output.right;
      while (node != null) {
         stack.push(node);
         node = node.left;
      }
    }
    
    
    return output.val;
  }
  
}