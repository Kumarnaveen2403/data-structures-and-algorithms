/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		int[] arrA = {3, 6, 4, 8};
        int[] arrB = {4, 6, 8, 3};
        
        System.out.println(minSwaps(arrA, arrB));
	}
	
	public static int minSwaps(int[] arrA, int[] arrB){
	    HashMap<Integer, Integer> positionMap = new HashMap<>();
	    
	    int swaps = 0;
	    for(int i = 0; i < arrA.length; i++){
	        positionMap.put(arrA[i], i);
	    }
	    
	    boolean[] visited = new boolean[arrB.length];
	    for(int i = 0; i < arrB.length; i++){
	        if(visited[i] == true || positionMap.get(arrB[i]) == i){
	            continue;
	        }
	        
	        int cycle = 0;
	        int j = i;
            do {
                j = positionMap.get(arrB[j]);
                visited[j] = true;
                cycle++;
            } while(j != i);
            
            swaps += cycle - 1;
	    }
	    
	    return swaps;   
	}
	
	
	
}