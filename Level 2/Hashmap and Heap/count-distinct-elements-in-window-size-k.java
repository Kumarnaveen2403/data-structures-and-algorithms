import java.util.*;

public class Main {

	public static ArrayList<Integer> solution(int[] arr, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < k; i++){
		    int val = arr[i];
		    map.put(val, map.getOrDefault(val, 0) + 1);
		}
		
		list.add(map.size());
		
		int i = 0, j = k;
		
		while(j < arr.length){
		    
		    if(map.getOrDefault(arr[i], 0) == 1){
		       map.remove(arr[i]);
		    } else {
		        map.put(arr[i], map.get(arr[i]) - 1);
		    }
		    
		    map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
		    
		    list.add(map.size());
		    
		    i++;
		    j++;
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		ArrayList<Integer> ans = solution(arr,k);
		for(int a : ans){
			System.out.print(a + " ");
		}
	}


}
