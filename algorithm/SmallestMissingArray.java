package algorithm;

import java.util.*;
import java.math.*;

public class SmallestMissingArray {
 
  public static void main(String[] args)  {
    
    int[] a = new int[] { 1, 3, -7, 6, 8, 4, -5, 5 };
   
    int count = 0;
    for (int i=0; i<a.length; i++) {
      if (a[i] > 0) {
        ++count;
      }
    }
    System.out.println(count);
   int[] arr = new int[count+1];
   arr[0] = 0;
   int p = 1;
   for (int i=0; i<a.length; i++) {
     if (a[i] > 0) {
       arr[p] = a[i];
       ++p;
     }
     
   }
    
   int size = arr.length;
   for (int i=0; i<arr.length; i++) {
     //System.out.println(arr[i]);
     if (arr[i] >= size) {
       arr[i] = -1;
     }
   }
   
   for (int i=0; i<arr.length; i++) {
     
     
     if (arr[i] != -1 && arr[i] != i) {
       
       int temp = arr[i];
       arr[i] = -1;
       
       while (temp != -1) {
         
         int k = arr[temp];
         arr[temp] = temp;
         temp = k;
       }
       
     }
     
     
   }
   
   for(int i=0; i< arr.length; i++) {
     if (arr[i] == -1) {
       System.out.println(i);
       break;
     }
     
   }
  }
  
  
  
}



