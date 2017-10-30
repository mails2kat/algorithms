package algorithm;


import java.util.*;
import java.math.*;

public class MergeArray {
 
  public static void main(String[] args)  {
    
    int[] a = new int[] {5, 10, 15, 25, 0, 0, 0};
    int[] b = new int[] {11, 17, 20};
    
    //System.out.println(a.length);
    
    merge(a, b, 4, 3);
    
    for(int k : a) {
      System.out.println(k);
    }
   
  }
  
  private static void merge(int[] a, int[] b, int i, int j) {
    
    int k = i + j - 1;
    
    int m = i - 1;
    int n = j - 1;
    
    while(m >= 0 && n >= 0) {
      
      if (a[m] < b[n]) {
        a[k] = b[n];
        --k;
        --n;
      } else {
        a[k] = a[m];
        --k;
        --m;
      }
      
    }
    
    while (n >= 0) {
      a[k] = b[n];
      --k;
      --n;
    }
    
  }
}



