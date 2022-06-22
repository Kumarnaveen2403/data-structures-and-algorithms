import java.util.*;

public class Main {
	
	public static void solution(int[] arr, int k){
	    	
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < arr.length; i++){
		    int val = arr[i];
		    
		    val = val % k;
		    
		    map.put(val, map.getOrDefault(val, 0) + 1);
		}
		
		int i = 1, j = k - 1;
		
		while(i <= j){
		    
		    if(i == j){
		        if(map.getOrDefault(i, 0) % 2 != 0){
    		        System.out.println(false);
    		        return;
		        }
		    } else if(map.getOrDefault(i, 0) != map.getOrDefault(j, 0)){
		        System.out.println(false);
		        return;
		    }
		    
		    i++;
		    j--;
		}
		
		if(map.getOrDefault(0, 0) % 2 != 0){
		    System.out.println(false);
		    return;
		}
		
		System.out.println(true);
		return;

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		solution(arr,k);
	}

}
