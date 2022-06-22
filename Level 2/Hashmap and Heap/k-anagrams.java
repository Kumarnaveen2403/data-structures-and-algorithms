import java.util.*;

public class Main {
	public static boolean areKAnagrams(String str1, String str2, int k) {
		// write your code here
	    int[] map = new int[26];
	    
	    for(int i = 0; i < str1.length(); i++){
	        char ch = str1.charAt(i);
	        
	        map[ch - 'a']++;
	    }
	    
	    
	    for(int i = 0; i < str2.length(); i++){
	        char ch = str2.charAt(i);
	        
	        if(map[ch - 'a'] > 0){
	            map[ch - 'a']--;
	        }
	    }
	    
	    int count = 0;
	    
	    for(int i = 0; i < 26; i++){
	        count += map[i];    
	    }
	    
        if(count <= k){
            return true;
        } else {
		    return false;
        }
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str1 = s.next();
		String str2 = s.next();
		int k = s.nextInt();
		System.out.println(areKAnagrams(str1, str2, k));

	}

}
