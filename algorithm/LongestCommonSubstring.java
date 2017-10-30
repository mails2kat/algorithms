/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package algorithm;

/**
 * @author karthikeyanrajamonickam
 *
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
/** Class  LongestCommonSubstring **/
public class  LongestCommonSubstring
{
    /** function lcs **/
    public String lcs(String str1, String str2)
    {
        int l1 = str1.length();
        int l2 = str2.length();
 
        int[][] arr = new int[l1][l2];
        int len = 0, pos = 0;
 
        for (int x = 0; x < l1; x++)
        {
            for (int y = 0; y < l2; y++)
            {
                if (str1.charAt(x) == str2.charAt(y))
                {
                  if (x==0 || y==0) {
                    arr[x][y] = 1;
                  } else {
                    arr[x][y] = arr[x - 1][y - 1] + 1;
                    if (arr[x][y] > len)
                    {
                        len = arr[x][y];
                        pos = x+1;
                    }   
                  }
                                   
                }
                
            }
        }        
        System.out.println("pos: " + pos + ", len: " + len);
        return str1.substring(pos - len, pos);
    }
 
    /** Main Function **/
    public static void main(String[] args) throws IOException
    {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Longest Common Substring Algorithm Test\n");
 
        System.out.println("\nEnter string 1");
        String str1 = br.readLine();
 
        System.out.println("\nEnter string 2");
        String str2 = br.readLine();
 
        LongestCommonSubstring obj = new LongestCommonSubstring(); 
        String result = obj.lcs(str1, str2);
 
        System.out.println("\nLongest Common Substring : "+ result);
    }
    
    
}
