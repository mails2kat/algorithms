package algorithm;


import java.util.*;
public class SortHashMap {
  
  public static void main(String[] args)  {
    
    Map<String, Integer> map = new HashMap<String, Integer>();
    
    map.put("Ten", 10);
        map.put("one", 1);
        map.put("three", 3);
        map.put("two", 2);
        map.put("four", 4);
        map.put("five", 5);
    
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      
      System.out.println(entry.getKey() + ":" + entry.getValue());
    }
    
    List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
    
    
    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
      public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        return e1.getValue().compareTo(e2.getValue());
      }
    });
    
    
    Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
    
    
    for (Map.Entry<String, Integer> entry : list) {
        sortedMap.put(entry.getKey(), entry.getValue());
    }
    
    for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
      
      System.out.println(entry.getKey() + ":" + entry.getValue());
    }
    
  }
  
  
  
}


