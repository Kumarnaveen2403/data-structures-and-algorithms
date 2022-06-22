import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int n, int k){
    if(n == 1){
        return 0;
    }
    
    int nm1 = solution(n - 1, k);
    
    int mapped = (nm1 + k) % n;
    
    return mapped;
    
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();
    System.out.println(solution(n,k));
  }
  

}
