import java.util.*;

public class Main {

	public static boolean isIsomorphic(String s, String t) {
		// write your code here
	    HashMap<Character, Character> map = new HashMap<>();
	    HashSet<Character> set = new HashSet<>();
	    
	    for(int i = 0; i < s.length(); i++){
	        char chs = s.charAt(i);
	        char cht = t.charAt(i);
	        
	        if(map.containsKey(chs)){
	            if(map.get(chs) != cht){
	                return false;
	            }
	        } else {
    	        if(set.contains(cht)){
    	            return false;
    	        } else {
	                map.put(chs, cht);
	                set.add(cht);
	        
    	        }
	        }
	            
	    }

		return true;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String A = scn.next();
		String B = scn.next();
		System.out.print(isIsomorphic(A, B));
	}

}
