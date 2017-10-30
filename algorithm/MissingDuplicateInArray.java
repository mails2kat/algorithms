package algorithm;


import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class MissingDuplicateInArray {
  public static void main(String[] args) {
    
    int[] a = new int[] {1,2,1,3};
    
    printTwoElements(a, 4);
  }
  
 
  
  private static void printTwoElements(int arr[], int size)
{
    int i;
    System.out.println("\n The repeating element is");
 
    for(i = 0; i < size; i++)
    {
        if(arr[Math.abs(arr[i])-1] > 0)
            arr[Math.abs(arr[i])-1] = -arr[Math.abs(arr[i])-1];
        else
            System.out.println(Math.abs(arr[i]));
    }
 
    System.out.println("\nand the missing element is ");
    for(i=0; i<size; i++)
    {
        if(arr[i]>0)
            System.out.println(i+1);
    }
}
  

}