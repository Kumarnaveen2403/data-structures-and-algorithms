import java.io.*;
import java.util.*;

public class Main {

	public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
		if(cs == ts){
		    System.out.println(asf + (oddc == null ? "" : oddc) + reverse(asf));
		    return;
		}
		
		for(char ch : fmap.keySet()){
		    if(fmap.get(ch) > 0){
		        fmap.put(ch, fmap.get(ch) - 1);
		        generatepw(cs + 1, ts, fmap, oddc, asf + ch);
		        fmap.put(ch, fmap.get(ch) + 1);
		    }
		}
	}
	
	public static String reverse(String str){
	    String ans = "";
	    
	    for(int i = 0 ; i < str.length(); i++){
	        char ch = str.charAt(i);
	        
	        ans = ch + ans;
	    }
	    
	    return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
		}
		
		Character oddChar = null;
		int odds = 0;
		int length = 0;
		
		for(Character ch : fmap.keySet()){
		    int f = fmap.get(ch);
		    
		    if(f % 2 == 1){
		        oddChar = ch;
		        odds++;
		        fmap.put(ch, (f - 1) / 2 );
		        length += (f - 1) / 2;
		        
		    } else {
		        fmap.put(ch, f / 2);
		        length += f / 2;
		    }
		    
		}
		
		if(odds > 1){
            System.out.println("-1");
		} else {
    		generatepw(0, length, fmap, oddChar, "");
		}
		
	}
	
}