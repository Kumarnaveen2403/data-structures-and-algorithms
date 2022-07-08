// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}// } Driver Code Ends


class Solution
{
    int[] parent;
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        parent = new int[101];
        
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        
        Arrays.sort(arr, (Job a, Job b) -> {
            return (b.profit - a.profit);
        });
                
        int count = 0;
        int totalProfit = 0;
                
        for(int i = 0; i < arr.length; i++){
            int jobIdx = arr[i].id;
            int deadline = arr[i].deadline;
            int profit = arr[i].profit;
            
            int parIdx = find(deadline);
            
            if(parIdx > 0){
                
                parent[parIdx] = find(parIdx - 1);
                
                count++;
                totalProfit += profit;
            }
    
        }
        
        return new int[] {count, totalProfit};
    }
    
    int find(int idx){
        if(parent[idx] == idx){
            return idx;
        } else {
            parent[idx] = find(parent[idx]);
            return parent[idx];
        }
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/