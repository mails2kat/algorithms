
package algorithm;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        String english="abcdefghijklmnopqrstuvwxyz";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : english.toCharArray()) {
            map.put(c, 0);
        }
        //Scanner s = new Scanner(System.in);
        String input = "We promptly judged antique ivory buckles for the next prize";
        for (char c : input.toLowerCase().toCharArray()) {
            Integer i = map.get(c);
            if (i != null) {
                map.put(c, ++i);
            }
            
        }
        boolean ispangram = true;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
          System.out.println(entry.getKey() + " : " + entry.getValue());
            int value = entry.getValue();
            if (value == 0) {
                ispangram = false;
                break;
            }
            
        }
        if (ispangram) {
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }
    }
}

