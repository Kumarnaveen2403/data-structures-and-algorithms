import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = Integer.parseInt(scn.nextLine());    
    
    HashMap<String, ArrayList<String>> map = new HashMap<>();
    String root = "";
    
    for(int i = 0; i < n; i++){
        String[] parts = scn.nextLine().split(" ");
        
        String e = parts[0];
        String m = parts[1];
        
        if(e.equals(m)){
            root = parts[0];
        } else if(map.containsKey(m) == true){
            ArrayList<String> list = map.get(m);
            list.add(e);
        } else  {
            ArrayList<String> list = new ArrayList<>();
            list.add(e);
            map.put(m, list);
        }
        
    }
    
    HashMap<String, Integer> res = new HashMap<>();
    size(root, map, res);
    
    for(String key : res.keySet()){
        System.out.println(key + " " + res.get(key));
    }
    
    
  }
  
  public static int size(String root, HashMap<String, ArrayList<String>> map, HashMap<String, Integer> res){
   if(map.getOrDefault(root, null) == null){
       res.put(root, 0);
       return 1;
   }
   
   int count = 0;
   
   for(String emp : map.get(root)){
       count += size(emp, map, res);
   }
   
   res.put(root, count);
   
   return count + 1;
  }

}