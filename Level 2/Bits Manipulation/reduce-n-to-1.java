import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int N) {
        int steps = 0;
        long n = N;
        while(n != 1){
            if((n & 1) == 0) n /= 2;
            else if(n == 3) n--;
            else if((n & 3) == 1 ) n--;
            else if((n & 3) == 3) n++;
            
            steps++;
        }
        
        return steps;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        System.out.println(solution(n));
    }
	
	
}