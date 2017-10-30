package algorithm;

import java.util.*;
import java.math.*;

public class SmallestMissing {
 
  public static void main(String[] args)  {
    
    int[] a = new int[] {7, 1, 3, 5, 0, 2};
   
    
    int m = a.length -1;
    for(int i=0; i< a.length; i++) {
      if(a[i] > m) {
        a[i] = -1;
      }
    } 
    
    for(int i=0; i< a.length; i++) {
      
      
      if (a[i] != -1) {
        
        if (a[i] != i) {
          int temp = a[i];
          a[i] = -1;
          while (temp != -1) {
            
            int k = a[temp];
           
            a[temp] = temp;
            
            temp = k;
          }
          
        }
        
      } 
    }
         
      
     
    
    for(int i=0; i< a.length; i++) {
      if (a[i] == -1) {
        System.out.println(i);
        break;
      }
      
    }
   
    }
  
  
}



