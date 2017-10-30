/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package algorithm;

/**
 * @author karthikeyanrajamonickam
 *
 */
public class LargestContiguousSubarray {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    int[] k = new int[] {-2, -3, 4, -1, -2, 1, 5, -3};
    
    int current_sum = 0;
    int max_sum = 0;
    
    for (int i=0; i<k.length; i++) {
      current_sum = current_sum + k[i];
      if ( current_sum < 0) {
        current_sum = 0;
      }
      max_sum = Math.max(max_sum, current_sum);
    }
    System.out.println(max_sum);
  }

}
