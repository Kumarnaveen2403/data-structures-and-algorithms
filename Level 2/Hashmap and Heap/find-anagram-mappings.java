import java.util.*;

public class Main {
	public static int[] anagramMappings(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];

        HashMap<Integer, Stack<Integer>> map = new HashMap<>();

        for(int i = 0; i <arr2.length; i++){
            int val = arr2[i];
            
            if(map.getOrDefault(val, null) != null){
                map.get(val).push(i);
            } else {
                Stack<Integer> st = new Stack<>();
                st.add(i);
                map.put(val, st);
            }
        }
        
        for(int i = arr1.length - 1; i >= 0; i--){
            int val = arr1[i];
            
            ans[i] = map.get(val).pop();
        }

		return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		for (int j = 0; j < b.length; j++) {
			b[j] = s.nextInt();
		}
		int[] res = anagramMappings(a, b);
		for (int j = 0; j < res.length; j++) {
			System.out.print(res[j] + " ");
		}
	}
}