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
 
/** Class  LongestCommonSubsequence **/
public class  LongestCommonSubsequence
{    
    /** function lcs **/
    public String lcs(String str1, String str2)
    {
        int l1 = str1.length();
        int l2 = str2.length();
 
        int[][] dp = new int[l1 + 1][l2 + 1];
 
        for(int i=0; i<=l1; i++){
          for(int j=0; j<=l2; j++){
            if(i==0 || j==0){
              dp[i][j]=0;
            }else if(str1.charAt(i-1)==str2.charAt(j-1)){
              dp[i][j] = 1 + dp[i-1][j-1];
            }else{
              dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
          }
        }
 
        int i = 0, j = 0;
        StringBuffer sb = new StringBuffer();
        while (i < l1 && j < l2) 
        {
            if (str1.charAt(i) == str2.charAt(j)) 
            {
                sb.append(str1.charAt(i));
                i++;
                j++;
            }
            else if (dp[i - 1][j] >= dp[i][j - 1]) 
                i++;
            else
                j++;
        }
        return sb.toString();
    }
 
    /** Main Function **/
    public static void main(String[] args) throws IOException
    {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Longest Common Subsequence Algorithm Test\n");
 
        System.out.println("\nEnter string 1");
        String str1 = br.readLine();
 
        System.out.println("\nEnter string 2");
        String str2 = br.readLine();
 
        LongestCommonSubsequence obj = new LongestCommonSubsequence(); 
        String result = obj.lcs(str1, str2);
 
        System.out.println("\nLongest Common Subsequence : "+ result);
    }
}
