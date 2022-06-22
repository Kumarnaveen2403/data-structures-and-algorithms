import java.util.*;

public class Main {
	public static void findAnagrams(String s, String p) {
        // write your code here
	    int[] pat = new int[26];
	    
	    for(int i = 0; i < p.length(); i++){
            char ch = p.charAt(i);
            
            pat[ch - 'a']++;
	    }
	    
	    int map[] = new int[26];
	    
	    for(int i = 0; i < p.length(); i++){
            char ch = s.charAt(i);
            
            map[ch - 'a']++;
	    }
	    
	    int count = 0;
	    ArrayList<Integer> list = new ArrayList<>();
	    
        if(areAnagram(map, pat) == true){
            count++;
            list.add(0);
        }
	    
	    int i = 0, j = p.length() - 1;
	    
	    while(j < s.length() - 1){
	        char chi = s.charAt(i);
	        char chj = s.charAt(j + 1);
	        
	        map[chi - 'a']--;
	        map[chj - 'a']++;
	        
	        if(areAnagram(map, pat) == true){
	            count++;
	            list.add(i + 1);
	        }
	        
	        i++;
	        j++;
	    }
	    
	    System.out.println(count);
	    
	    for(i = 0; i < list.size(); i++){
	        System.out.print(list.get(i) + " ");
	    }
	    
	    System.out.println();
	}
	
	public static boolean areAnagram(int[] map, int[] pat){
	    
	    for(int i = 0; i < 26; i++){
            if(map[i] != pat[i]){
                return false;
            }
	    }
	    
	    return true;
	    
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String p = scn.next();
		findAnagrams(s, p);
	}

}
