import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str, String pattern, HashMap<Character,String> map, String op){
		
		if(pattern.length() == 0){
		    
		    if(str.length() == 0){
		        boolean[] visited = new boolean[26];
		        
		        for(int i = 0; i < op.length(); i++){
		            char c = op.charAt(i);
		            String match = map.get(c);
		            if(visited[c -'a'] == false){
		                visited[c - 'a'] = true;
        	            System.out.print(c + " -> " + match + ", ");
		            }
		            
		        }
		        
		        System.out.println(".");
		    }
		    
		    
		    return;
		}
		
		
		char ch = pattern.charAt(0);
		String ros = pattern.substring(1);
		
		if(map.containsKey(ch)){
		    String mapped = map.get(ch);
		    
		    if(str.length() >= mapped.length()){
		        String remStr = str.substring(0, mapped.length());
		        if(remStr.equals(mapped)){
		            
		            solution(str.substring(mapped.length()), ros, map, op);
		        }
		    }
		    
		} else {
		    for(int i = 0; i < str.length(); i++){
		        String left = str.substring(0, i + 1);
		        String right = str.substring(i + 1);
		        
		        map.put(ch, left);
		        
		        solution(right, ros, map, op);
		        
		        map.remove(ch);
		        
		    }
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String pattern = scn.next();
		HashMap<Character,String> map = new HashMap<>();
		solution(str,pattern,map,pattern);
	}
}