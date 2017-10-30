/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package algorithm;

/**
 * @author karthikeyanrajamonickam
 *
 */
public class sortBySwap {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] arr = {1, 5, 3};
    for (int i=0; i<arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println(" ");
    sortBySwap(arr, 3);
    for (int i=0; i<arr.length; i++) {
      System.out.print(arr[i] + " ");
    }

  }
  
  static void sortBySwap(int arr[], int n)
  {
      for (int i=1; i<arr.length; i++) {
        if (arr[i] < arr[i-1]) {
          swap(arr, i, i-1);
          break;
        }
      }
  }

  /**
   * @param i
   * @param j
   */
  private static void swap(int[] arr, int i, int j) {
    // TODO Auto-generated method stub
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


}
