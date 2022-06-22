import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception{
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
    
    printWords(0, k, ustr, -1, new Character[k]);
  }
  
  public static void printWords(int cs, int ts, String ustr, int lcp, Character[] arr){
      if(cs == ts){
          for(int i = 0; i < arr.length; i++){
              System.out.print(arr[i]);
          }
          
          System.out.println();
          
          return;
      }
    
    for(int i = lcp + 1; i < ustr.length(); i++){
        arr[cs] = ustr.charAt(i);
        printWords(cs + 1, ts, ustr, i, arr);
        arr[cs] = null;
    }
      
      
  }

}