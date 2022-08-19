/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
       Scanner scn = new Scanner(System.in);
	    int t = Integer.parseInt(scn.nextLine());
	    
	    while(t-- > 0){
	        int len = Integer.parseInt(scn.nextLine());
	        String s = scn.nextLine();
	        String ans = solution(s, len);
	        System.out.println(ans);
	    }
	}
	
	public static String solution(String str, int len){
	    int[] z = zAlgo(str);
	    
	    HashMap<Integer, Integer> map = new HashMap<>();
	    
	    for(int val : z){
	        if(val == 0){
	            continue;
	        }
	        
	        for(int i = 1; i <= val; i++){
	            map.put(i, map.getOrDefault(i, 0) + 1);
	        }
	    }
	    
	    int ans = 0;
	    int maxFreq = 0;
	    for(int key : map.keySet()){
	        int freq = map.get(key);
	        
	        if(freq > maxFreq){
	            maxFreq = freq;
	            ans = key;
	        } else if(freq == maxFreq){
	            if(key > ans){
	                ans = key;
	            }
	        }
	    }
	    
	    if(ans == 0){
	        return str;
	    }
	    
	    return str.substring(0, ans);
	}
	
	public static int[] zAlgo(String str){
	    
	    int[] z = new int[str.length()];
	    
	    int l = 0, r = 0;
	    
	    for(int i = 1; i < z.length; i++){
	        if(i > r){
	            r = l = i;
	            
	            while(r < z.length && str.charAt(r) == str.charAt(r - l)){
	                r++;
	            }
	            
	            r--;
	            
	            z[i] = r - l + 1;
	        } else {
	            int k = i - l;
	            
	            if(z[k] < r - i + 1){
	                z[i] = z[k];
	            } else {
	                l = i;
	                
	                while(r < z.length && str.charAt(r) == str.charAt(r - l)){
	                    r++;
    	            }
    	            
    	            r--;
    	            
    	            z[i] = r - l + 1;
	            }
	        }
	    }
	    
	    return z;
	}
}
