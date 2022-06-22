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
    
    selectWords(0, 0, k, unique, ustr, "");

   
  }
  
  public static void selectWords(int ci, int ssf, int ts, HashMap<Character, Integer> unique, String ustr, String ans){
    
    if(ci == ustr.length()){
        if(ssf == ts){
            System.out.println(ans);
        }
        
        return;
    }
    
    char ch = ustr.charAt(ci);
    
    for(int j = unique.get(ch); j >= 0; j--){
        String chars = "";
        
        for(int k = j; k > 0; k--){
            chars += ch;
        }
        
        
        selectWords(ci + 1, ssf + j, ts, unique, ustr, ans + chars);
    }
        
        
    
    
  }

}