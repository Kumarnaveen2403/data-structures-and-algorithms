import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    int left = scn.nextInt();
    int right = scn.nextInt();

    int m1 = 1 << (right - left + 1);
    int m2 = m1 - 1;
    int m3 = m2 << (left - 1);
    int m4 = a & m3;
    int m5 = b | m4;
    
    System.out.println(m5);
    
  }

}