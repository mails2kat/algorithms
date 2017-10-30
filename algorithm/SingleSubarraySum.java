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
 * @author karthikeyanrajamonickam
 *
 */
public class SingleSubarraySum {

  public static void main(String[] args) {
    int[] INPUT = {2,7,1,9,6,3};
    printSubarrays(INPUT, 22);
}

private static void printSubarrays(int[] input, int target) {
  int sum = input[0];
  int start = 0;
  for (int i =1; i<input.length; i++) {
    
    while (sum > target) {
      sum = sum - input[start];
      ++start;
    }
    
    if (sum == target) {
      int t = i-1;
      System.out.println("target sum found: " + start  + ", " + t);
    }
    
    sum = sum + input[i];
  }
      
}

}
