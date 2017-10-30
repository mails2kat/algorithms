/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author karthikeyanrajamonickam
 *
 */
public class LargestNumber {
  
  public static void main(String[] args) {
    LargestNumber n = new LargestNumber();
    int[] nums = new int[] {3, 30, 34, 5, 9};
    String str = n.largestNumber(nums);
    System.out.println(str);
  }

  public String largestNumber(int[] nums) {
    String[] arr = new String[nums.length];
    for(int i=0; i<nums.length; i++){
        arr[i]=String.valueOf(nums[i]);
    }
 
    Arrays.sort(arr, new Comparator<String>(){
        public int compare(String a, String b){
            return (b+a).compareTo(a+b);
          //return (b).compareTo(a);
        }
    });
 
    StringBuilder sb = new StringBuilder();
    for(String s: arr){
        sb.append(s);
    }
 
    /*
    while(sb.charAt(0)=='0'&&sb.length()>1)
        sb.deleteCharAt(0);
        */
 
    return sb.toString();
}
}

