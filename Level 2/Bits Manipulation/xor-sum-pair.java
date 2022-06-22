import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int[] arr){
       //write your code here
       int xor = 0;
       
       for(int ele : arr){
           xor = xor ^ ele;
       }
       
       return (xor << 1);
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
    
    
}