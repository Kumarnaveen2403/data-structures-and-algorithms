import java.io.*;
import java.util.*;

public class Main {

 
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }

    permutations(0, k, ustr, new boolean[ustr.length()], "");
   
  }
  
  public static void permutations(int spot, int k, String ustr, boolean[] usedChars, String asf){
      if(spot == k){
          System.out.println(asf);
          
          return;
      }
      
      for(int i = 0; i < ustr.length(); i++){
        char ch = ustr.charAt(i);
        if(usedChars[i] == false){
            usedChars[i] = true;
            permutations(spot + 1, k, ustr, usedChars, asf + ch);
            usedChars[i] = false;
        }
      }
  }

}