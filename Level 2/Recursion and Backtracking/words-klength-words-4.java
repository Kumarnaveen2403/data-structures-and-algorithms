import java.io.*;
import java.util.*;

public class Main {

  

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character, Integer> unique = new HashMap<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch, 1);
        ustr += ch;
      } else {
        unique.put(ch, unique.get(ch) + 1);
      }
    }
    
    printWords(0, k, unique, ustr, "");

  }
  
  
    public static void printWords(int cb, int tb, HashMap<Character, Integer> unique, String ustr, String ans){
        if(cb == tb){
            System.out.println(ans);
            
            return;
        }
        
        for(int i = 0; i < ustr.length(); i++){
            char ch = ustr.charAt(i);
            
            if(unique.get(ch) > 0){
                unique.put(ch, unique.get(ch) - 1);
                printWords(cb + 1, tb, unique, ustr, ans + "" + ch);
                unique.put(ch, unique.get(ch) + 1);
            }
        }
        
    }

}