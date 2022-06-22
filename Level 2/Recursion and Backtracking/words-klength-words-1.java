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

    permutations(new Character[k], 0, ustr, 0, k);
    
  }
  
  public static void permutations(Character[] strArr, int cpsf, String ustr, int charIdx, int k){
      
    if(charIdx == ustr.length()){
        if(cpsf == k){
            for(int i = 0; i < k; i++){
                System.out.print(strArr[i]);
            }
            System.out.println();
        }
        
        return;
    }
      
    char ch = ustr.charAt(charIdx);
    
    for(int i = 0; i < strArr.length; i++){
        
        if(strArr[i] == null){
            strArr[i] = ch;
            permutations(strArr, cpsf + 1, ustr, charIdx + 1, k);
            strArr[i] = null;
        }
    }
    
    permutations(strArr, cpsf, ustr, charIdx + 1, k);
    
  }

}