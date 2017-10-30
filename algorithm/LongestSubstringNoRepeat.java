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
import java.util.HashSet;
import java.util.Set;
import java.io.IOException;
 
/** Class  LongestSubstringNoRepeat **/
public class  LongestSubstringNoRepeat
{
   
 
    /** Main Function **/
    public static void main(String[] args) throws IOException
    {    
      String str = "abcabcbbabcdeijklmnbcdefgh";
        System.out.println(str);
        Set<Character> set = new HashSet<Character>();
        int max = 0;
        for (int i=0; i<str.length(); i++) {
          char c = str.charAt(i);
          if (!set.contains(c)) {
            set.add(c);
          } else {
            int size = set.size();
            System.out.println("size: " + size);
            max = Math.max(size, max);
            set.clear();
            set.add(c);
          }
        }
        if (!set.isEmpty()) {
          int size = set.size();
          max = Math.max(size, max);
        }
        
        System.out.println(max);
    }
}
