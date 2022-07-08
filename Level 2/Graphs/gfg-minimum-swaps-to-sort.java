// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        
        Arrays.sort(nums);
        
        return minSwaps(nums, map);
        
    }
    
    public int minSwaps(int[] sortedArray, HashMap<Integer, Integer> map) {
        boolean[] visited = new boolean[sortedArray.length];
        int swaps = 0;        
        
        for(int i = 0; i < sortedArray.length; i++){
            if(visited[i] == true || i == map.get(sortedArray[i])){
                continue;
            }
            
            int j = i;
            int cycle = 0;
            do {
                visited[j] = true;
                j = map.get(sortedArray[j]);
                cycle++;
            } while(i != j);
            
            swaps += cycle - 1;
        }
        
        return swaps;
        
    }
}