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
    
    printWords(0, k, unique, ustr, "", 0);
    
  }
  
    public static void printWords(int ssf, int ts, HashMap<Character, Integer> unique, String ustr, String ans, int ci){
        if(ci == ustr.length()){
            if(ssf == ts){
                System.out.println(ans);
            }
            
            return;
        }
        
        char ch = ustr.charAt(ci);
        
        for(int count = unique.get(ch); count >= 0; count--){
            String charStr = "";
            
            for(int k = count; k > 0; k--){
                charStr += ch;
            }
            
            printWords(ssf + count, ts, unique, ustr, ans + charStr, ci + 1);
        }
        
    }

}