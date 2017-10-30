/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package algorithm;

import java.util.Scanner;

/**
 * @author karthikeyanrajamonickam
 *
 */
public class ArrayRotation {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    //int arr[] = {11, 12, 15, 17, 20, 6, 8, 9, 10};
    int arr[] = {11, 12, 2, 4, 7, 9, 10};
    int sum = 16;
    int n = arr.length;
    System.out.println(findMin(arr));
  
    /*
    if (pairInSortedRotated(arr, n, sum))
        System.out.print("Array has two elements" +
                         " with sum 16");
    else
        System.out.print("Array doesn't have two" + 
                         " elements with sum 16 ");
                         */
                         
    
    /*
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    int n = scanner.nextInt();
    
    int a[] = new int[m];
    for (int i=0; i<m; i++) {
      a[i] = scanner.nextInt();
      System.out.println("data: " + i + " : " + a[i]);
    }
    scanner.close();
    int k = 0;
    if (n > m) {
      n = n % m;
      k = m - n - 1;
    } else {
      k = n;
    }
    
    //int k = m - n;
    
    
    //right(a, k, m);
    left(a, k, m);
   
    
    for (int i : a) {
      System.out.println(i);
    }
    
    */
  }
  
  private static void left(int[] a, int k, int m) {
    reverse(a, 0, m-1);
    reverse(a, 0, k);
    reverse(a, k+1, m-1);
  }
  
  private static void right(int[] a, int k, int m) {
    
    reverse(a, 0, k);
    reverse(a, k+1, m-1);
    reverse(a, 0, m-1);
  }

  /**
   * @param a
   * @param i
   * @param j
   */
  private static void reverse(int[] a, int i, int j) {
    while (i < j) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
      ++i;
      --j;
    }
    
  }
  
  public static int findMin(int[] nums) {
    if(nums==null || nums.length==0)
        return -1;
 
    if(nums.length==1)
        return nums[0];
 
    int left=0;
    int right=nums.length-1;
 
    //not rotated
    if(nums[left]<nums[right])
        return nums[left];
 
    while(left <= right){
        if(right-left==1){
            return nums[right];
        }
 
        int m = left + (right-left)/2;
 
        if(nums[m] > nums[right])
            left = m;
        else
            right = m;
    }
 
    return nums[left];
}
  
  public int search(int[] nums, int target) {
    int left = 0;
    int right= nums.length-1;
 
    while(left<=right){
        int mid = left + (right-left)/2;
        if(target==nums[mid])
            return mid;
 
        if(nums[left]<=nums[mid]){
            if(nums[left]<=target&& target<nums[mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }else{
            if(nums[mid]<target&& target<=nums[right]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }    
    }
 
    return -1;
}
  
  public static boolean pairInSortedRotated(int arr[], 
      int n, int x)
{
    //{11, 15, 6, 8, 9, 10}; 21
  // Find the pivot element
  int i;
  for (i = 0; i < n - 1; i++)
    if (arr[i] > arr[i+1])
      break;
  
  int l = (i + 1) % n; // l is now index of                                          
  // minimum element
  
  int r = i;       // r is now index of maximum
  //element
  
  // Keep moving either l or r till they meet
  while (l != r)
  {
  // If we find a pair with sum x, we
  // return true
  if (arr[l] + arr[r] == x)
  return true;
  
  // If current pair sum is less, move 
  // to the higher sum
  if (arr[l] + arr[r] < x)
  l = (l + 1) % n;
  
  else  // Move to the lower sum side
  r = (n + r - 1) % n;
  }
  return false;
}

}
