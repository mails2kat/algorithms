/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 212365826
 *
 */
public class Expression {

  /**
   * @param args
   */
  public static void main(String[] args) {

    //String exp = "[()]{}{[()()]()}";
    
    String exp = "[(])";
    
    List<Character> stack = new LinkedList<Character>();
    
    for (char c : exp.toCharArray()) {
      if (c == '[' || c == '(') {
        stack.add(c);
      } else if (c == ']') {
        Character t = stack.get(stack.size() - 1);
        if (t == '[') {
          stack.remove(stack.size() - 1);
        } else {
          System.out.println("bad expression");
          break;
        }
      } else if (c == ')') {
        Character t = stack.get(stack.size() - 1);
        if (t == '(') {
          stack.remove(stack.size() - 1);
        } else {
          System.out.println("bad expression");
          break;
        }
      }
    }
    
    System.out.println("done");

  }

}
