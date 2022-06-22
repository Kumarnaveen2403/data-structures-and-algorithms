import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}

	    HashSet<String> set = new HashSet<>();
	    
	    for(String key : map.keySet()){
	        set.add(key);
	    }
	    
	    for(String key : map.keySet()){
	        set.remove(map.get(key));
	    }
	    
	    String[] source = set.toArray(new String[set.size()]);

        System.out.print(source[0]);
        
        String curr = source[0];
        
	    while(true){
	        if(map.get(curr) == null){
	           break;
	        }
	        
	        System.out.print(" -> " + map.get(curr));
	        curr = map.get(curr);
	    }
	    
	    System.out.println(".");
        
	}
}
