import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(solution(n));
  }
  
  public static int getJustSmaller2Power(int n){
    int pow = 0;
    
    while( (1 << pow) <= n){
        pow++;
    }
    
    return pow - 1;
    
  }

  public static int solution(int n){
    if(n == 0){
        return 0;
    }
      
    int justSmaller2sPower = getJustSmaller2Power(n);
    
    int numberOfSetBitsIn2sPower = justSmaller2sPower * ( (1 << (justSmaller2sPower - 1)));
    int firstBitsAfter = n - (1 << justSmaller2sPower) + 1;
    int remainingBits = solution(n - (1 << justSmaller2sPower));
    
    return numberOfSetBitsIn2sPower + firstBitsAfter + remainingBits;
  }

}