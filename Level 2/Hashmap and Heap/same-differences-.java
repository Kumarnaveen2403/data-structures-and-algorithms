import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		for(int i = 0; i < n; i++){
            int m = s.nextInt();

            int[] arr = new int[m];

            for(int j = 0; j < m; j++){
                arr[j] = s.nextInt();
            }

            System.out.println(sameDifferences(arr));
		}
	}

    public static int sameDifferences(int[] arr){

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            int val = arr[i];

            map.put(val - i, map.getOrDefault(val - 1, 0) + 1);
        }

        int count = 0;

        for(Integer key : map.keySet()){
            int val = map.get(key);
            count += (val * (val - 1) )/ 2;
        }

        return count;
    }

}