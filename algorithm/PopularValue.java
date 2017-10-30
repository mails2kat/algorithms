/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 212365826
 *
 */
public class PopularValue<T> {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String str = "daaaaaabbbbccceeaaaaaaddggeefffffff";
   
    PopularValue<String> popularValue = new  PopularValue<String>();
    List<String> input = new ArrayList<String>();
    input.add("a");
    input.add("b");
    input.add("c");
    input.add("c");
    input.add("a");
    input.add("d");
    input.add("a");
    
    System.out.println("Most popular: " + popularValue.popular(input));

  }
  
  
  private T popular(List<T> input) {
    
    Map<T, Integer> map = new HashMap<T, Integer>();
    for (T c : input) {
      Integer count = null;
      if (map.get(c) == null) {
        count = new Integer(1);
      } else {
        count = map.get(c);
        ++count;
      }
      map.put(c, count);
    }
    int t = 0;
    T output = null;
    for (Map.Entry<T, Integer> entry : map.entrySet()) {
      T popular = entry.getKey();
      Integer count = entry.getValue();
      if (count > t) {
        output = popular;
        t = count;
      }
    }
    return output;
  }

}
