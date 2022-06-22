import java.util.*;
 
 public class Main {
 
     public static List<Integer> grayCode(int n) {
 	 //Write your code here
 	 
 	 if(n == 0){
 	     List<Integer> codes = new ArrayList<>();
 	     codes.add(0);
 	     return codes;
 	 }
 	 
 	 if(n == 1){
 	     List<Integer> codes = new ArrayList<>();
 	     codes.add(0);
 	     codes.add(1);
 	     return codes;
 	 }
 	    
 	    
 	    List<Integer> prevCode = grayCode(n - 1);
 	    
 	    List<Integer> newCode = new ArrayList<>();
 	    
 	    for(Integer code : prevCode){
 	        newCode.add(code);
 	    }
 	    
 	    for(int i = prevCode.size() - 1; i >= 0; i--){
 	        int val = prevCode.get(i);
 	        
 	        int bm = 1 << n - 1;
 	        
 	        val = val | bm;
 	        
 	        newCode.add(val);
 	    }
 	    
 	    
 	    return newCode;
 	 
     }
 
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         List<Integer> ans=grayCode(scn.nextInt());
         Collections.sort(ans);
         System.out.println(ans);
     }
 }