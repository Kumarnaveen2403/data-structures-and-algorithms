import java.io.*;
import java.util.*;

public class Main {
  static int counter = 1;

  public static void solution(int i, int n, boolean[] used, String asf) {
      
    if(i > n){
        System.out.println(asf);
        return;
    }
      
    used[i] = true;
    solution(i + 1, n, used, asf + "(" + i + ") ");
    // used[i] = false;
      
    for(int num = 1; num < used.length; num++){
        if(used[num] == false){
            used[num] = true;
            // used[i] = true;
            solution(num, n, used, asf + "(" + i + "," + num + ") ");
            used[i] = false;
            used[num] = false;
        }
        
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] used = new boolean[n + 1];
    solution(1, n, used, "");
  }
}
