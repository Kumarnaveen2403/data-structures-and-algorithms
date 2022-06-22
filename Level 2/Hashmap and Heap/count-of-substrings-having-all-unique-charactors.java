import java.util.*;

public class Main {

	public static int solution(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		
		int count = 0;
		int i = 0;
		int j = -1;
		
		while(i <  str.length()){
		    
		    while(i < str.length() && map.containsKey(str.charAt(i)) == false){
		        char chi = str.charAt(i);
		        
		        map.put(chi, 1);
		        count += i - j;
		        
		        i++;
		    }
		    
		    while(i < str.length() && map.containsKey(str.charAt(i)) == true){
    	        j++;
    	        char chj = str.charAt(j);
    	        map.remove(chj);
		    }
		    
		    
		}
		
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
