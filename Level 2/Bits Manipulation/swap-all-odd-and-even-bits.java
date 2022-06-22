import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int oddMask = 0xAAAAAAAA;
    int evenMask = 0x55555555;
    
    int evenBits = n & evenMask;
    int oddBits = n & oddMask;
    
    evenBits = evenBits << 1;
    oddBits = oddBits >> 1;
    
    int ans = evenBits | oddBits;
    
    System.out.println(ans);
    
  }

}