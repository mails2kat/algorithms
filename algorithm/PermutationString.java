package algorithm;
public class PermutationString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//permutation("ABC");
		//System.out.println(singleOccurence("ABCCBD"));
	  //removeAdjacentCharacters("ABCCBAD");
	  System.out.println(reverse("kata"));

	}
	
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
		//System.out.println(prefix + "  " + str);
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
	
	public static StringBuilder singleOccurence(String s)
	{
	    StringBuilder sb = new StringBuilder();
	    if (s.length() > 0) {
	        char prev = s.charAt(0);
	        sb.append(prev);
	        for (int i = 1; i < s.length(); ++i) {
	            char cur = s.charAt(i);
	            if (cur != prev) {
	                sb.append(cur);
	                prev = cur;
	            }
	        }
	    }
	    return sb;
	}
	
public static void removeAdjacentCharacters(String  str) {
 //ABCCBAD
  //i=3
  
  for (int i = 1; i < str.length(); i++)
  {
    
      if (str.charAt(i) == str.charAt(i-1)) 
      {
      
          str = str.substring(0, i-1) + str.substring(i+1);
         
          i = 0;
      }
  }
  if (str.length() == 0) {
      System.out.println("Empty String");
  } else {            
      System.out.println (str);
  }
}


private static String reverse(String str) {
  /*
  int start = 0;
  int end = str.length() - 1;
  char[] c = str.toCharArray();
  while (start < end) {
    char temp = str.charAt(start);
    c[start] = c[end];
    c[end] = temp;
  
    ++start;
    --end;
  }
  return new String(c);
  */
  char[] s = str.toCharArray();
 
  int start = 0;
  int end = s.length -1;
  while (start < end) {
    
    s[start] ^= s[end];
    s[end] ^= s[start];
    s[start] ^= s[end];
    
    ++start;
    --end;
  }
  
  return new String(s);
  
}
}
