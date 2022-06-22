import java.util.*;

public class Main {
	
    public static void completeTask(int n, int m, int[] arr) {
		// write your code here
		boolean flag = true;
		
		HashSet<Integer> set = new HashSet<>();
		for(int val : arr){
		    set.add(val);
		}
		
		StringBuilder s1 = new StringBuilder("");
		StringBuilder s2 = new StringBuilder("");
		
		for(int i = 1; i <= n; i++){
		    if(!set.contains(i)){
		        if(flag == true){
		            s1.append(i + " ");
		            flag = !flag;
		        } else {
		            s2.append(i + " ");
		            flag = !flag;
		        }
		    }
		}
		
		System.out.println(s1);
		System.out.println(s2);

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[] num = new int[m];
		for (int i = 0; i < m; i++) {
			num[i] = scn.nextInt();
		}
		completeTask(n, m, num);
	}

}
