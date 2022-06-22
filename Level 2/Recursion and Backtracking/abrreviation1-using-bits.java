import java.io.*;
import java.util.*;

public class Main {

    public static void solve(String str){
        int n = ( 1 << str.length() );
        
        for(int i = 0; i < n; i++){
            int count = 0;
            String ans = "";
            
            for(int j = str.length() - 1; j >= 0; j--){
                int jthbit = (1 << j) & i;
                
                if(jthbit > 0){
                    count++;
                } else {
                    if(count > 0){
                        ans += count;
                        count = 0;
                    }
                    ans += str.charAt(str.length() - j - 1);
                }
                
            }
            
            if(count > 0){
                ans += count;
            }
            
            System.out.println(ans);
            
        }
        
        
        
    }
    
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solve(str);
    }
}