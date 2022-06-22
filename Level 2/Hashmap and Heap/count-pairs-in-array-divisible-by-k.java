// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    int k = Integer.parseInt(br.readLine().trim());
		    
		    Solution ob= new Solution();
		    System.out.println(ob.countKdivPairs(arr, n, k));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int countKdivPairs(int arr[], int n, int k)
    {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++){
            int val = arr[i];
            hm.put(val % k, hm.getOrDefault(val % k , 0) + 1);
        }
        
        
        int i = 1, j = k - 1;
        int count = 0;
        
        while(i <= j){
            if(i == j){
                count += (hm.getOrDefault(i, 0) * (hm.getOrDefault(i, 0) - 1)) / 2;
            } else {
                count += hm.getOrDefault(i, 0) * hm.getOrDefault(j, 0);
            }
            
            i++;
            j--;
        }
        
        count += (hm.getOrDefault(0, 0) * (hm.getOrDefault(0, 0) - 1)) / 2;
        
        return count;
    }
} 