import java.io.*;
import java.util.*;

public class Main {


	public static void solution(int[] arr, int vidx,int n , int k,int[] subsetSum,int es, ArrayList<ArrayList<Integer>> ans) {
		//write your code here
		if(vidx == arr.length){
		    if(es == 0){
		        boolean allSame = true;
		        int val = subsetSum[0];
		        for(int i = 1; i < subsetSum.length; i++){
		            if(val != subsetSum[i]){
		                allSame = false;
		                break;
		            }
		        }
		        
		        if(allSame){
		            for(ArrayList<Integer> list: ans){
		                System.out.print(list + " ");
		            }
		            System.out.println();
		        }
		    }
		    return;
		}
		
		for(int i = 0; i < ans.size(); i++){
		    ArrayList<Integer> list = ans.get(i);
		    
		    if(list.size() == 0){
		        list.add(arr[vidx]);
		        subsetSum[i] += arr[vidx];
		        solution(arr, vidx + 1, n, k, subsetSum, es - 1, ans);
		        subsetSum[i] -= arr[vidx];
		        list.remove(list.size() - 1);
		        break;
		    } else {
		        list.add(arr[vidx]);
		        subsetSum[i] += arr[vidx];
		        solution(arr, vidx + 1, n, k, subsetSum, es, ans);
		        subsetSum[i] -= arr[vidx];
		        list.remove(list.size() - 1);
		    }
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for(int i =  0 ; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			sum += arr[i];
		}
		int k = scn.nextInt();
		// if k is equal to 1, then whole array is your answer 
		if(k == 1) {
			System.out.print("[");
			for(int i = 0 ; i  < arr.length; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println("]");
			return;
		}
		//if there are more subsets than no. of elements in array or sum of all elements is not divisible by k
		if(k > n || sum % k != 0) {
			System.out.println("-1");
			return;
		}
		int[] subsetSum = new int[k];
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(arr,0,n,k,subsetSum,k,ans);
	}
	
	

}