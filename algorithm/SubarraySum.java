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
public class SubarraySum {

  public static void main(String[] args) {
    //int[] INPUT = {4, -4, 5, 6, 1, -2, -4, 3, 1, 5, 7, 3, 2};
    int[] INPUT = {-2, 3, 5, -1, 4, 1};
    printSubarrays2(INPUT, 8);
}

private static void printSubarrays(int[] input, int k) {
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    List<Integer> initial = new ArrayList<Integer>();
    initial.add(-1);
    map.put(0, initial);
    int preSum = 0;

    // Loop across all elements of the array
    for(int i=0; i< input.length; i++) {
        preSum += input[i];
        //System.out.println("preSum: " + preSum);
        // If point where sum = (preSum - k) is present, it means that between that 
        // point and this, the sum has to equal k
        if(map.containsKey(preSum - k)) {   // Subarray found 
          System.out.println(preSum + " : " + k);
            List<Integer> startIndices = map.get(preSum - k);
            for(int start : startIndices) {
                System.out.println("Start: "+ (start+1)+ "\tEnd: "+ i);
            }
        }

        List<Integer> newStart = new ArrayList<Integer>();
        if(map.containsKey(preSum)) { 
            newStart = map.get(preSum);
        }
        newStart.add(i);
        map.put(preSum, newStart);
    }
}


private static void printSubarrays2(int[] input, int k) {
  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
  
  map.put(0, -1);
  int preSum = 0;

  // Loop across all elements of the array
  for(int i=0; i< input.length; i++) {
      preSum += input[i];
      //System.out.println("preSum: " + preSum);
      // If point where sum = (preSum - k) is present, it means that between that 
      // point and this, the sum has to equal k
      if(map.containsKey(preSum - k)) {   // Subarray found 
        System.out.println(preSum + " : " + k);
        Integer startIndices = map.get(preSum - k);
        System.out.println("Start: "+ (startIndices+1)+ "\tEnd: "+ i);
          
      }

      map.put(preSum, i);
  }
}

}
