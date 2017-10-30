package algorithm;


import java.util.*;
import java.math.*;

public class ArrayOne {
 
  public static void main(String[] args)  {
    
    int[] a = new int[] {-5, -3, 1, 2, 4};
    
    //System.out.println(a.length);
    
    int[] b = new int[a.length];
    int r = b.length-1;
    
    int i = 0;
    int j = a.length -1;
    
    while (i <= j) {
      
      if (Math.abs(a[i]) > Math.abs(a[j])) {
        
        b[r] = a[i] * a[i];
        ++i;
        --r;
      } else {
        b[r] = a[j] * a[j];
        --j;
        --r;
      }
      
    }
    
    for (int k : b) {
      System.out.println(k);
    }
   
  }
  
  static void minAbsSumPair(int arr[], int n)
  {
    // Variables to keep track of current sum and minimum sum
    int sum, min_sum = 999999;
    
    // left and right index variables
    int l = 0, r = n-1;
    
    // variable to keep track of the left and right pair for min_sum
    int min_l = l, min_r = n-1;
    
    /* Array should have at least two elements*/
    if(n < 2)
    {
      System.out.println("Invalid Input");
      return;
    }
    
    /* Sort the elements */
    Arrays.sort(arr);
    
    while(l < r)
    {
      sum = arr[l] + arr[r];
    
      /*If abs(sum) is less then update the result items*/
      if(Math.abs(sum) < Math.abs(min_sum))
      {
        min_sum = sum;
        min_l = l;
        min_r = r;
      }
      if(sum < 0)
        l++;
      else
        r--;
    }
    
     
    System.out.println(" The two elements whose "+
                            "sum is minimum are "+
                      arr[min_l]+ " and "+arr[min_r]);
  }
  
//Prints the pair with sum cloest to x
  static void printClosest(int arr[], int n, int x)
  {
      int res_l=0, res_r=0;  // To store indexes of result pair

      // Initialize left and right indexes and difference between
      // pair sum and x
      int l = 0, r = n-1, diff = Integer.MAX_VALUE;

      // While there are elements between l and r
      while (r > l)
      {
          // Check if this pair is closer than the closest pair so far
          if (Math.abs(arr[l] + arr[r] - x) < diff)
          {
             res_l = l;
             res_r = r;
             diff = Math.abs(arr[l] + arr[r] - x);
          }

          // If this pair has more sum, move to smaller values.
          if (arr[l] + arr[r] > x)
             r--;
          else // Move to larger values
             l++;
      }

  System.out.println(" The closest pair is "+arr[res_l]+" and "+ arr[res_r]);
}
}



