import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        
        if(row == tq){
            if(qpsf == tq){
                System.out.println(asf);
            }
            
            return;
        }
        
        int nrow;
        int ncol;
        boolean changeRow;
        
        if(col == tq - 1){
            ncol = 0;
            nrow = row + 1;
            changeRow = true;
            
        } else {
            ncol = col + 1;
            nrow = row;
            changeRow = false;
        }
        
        queensCombinations(qpsf + 1, tq, nrow, ncol, changeRow == true ? asf + "q\n" : asf + "q");
        queensCombinations(qpsf, tq, nrow, ncol, changeRow == true ? asf + "-\n" : asf + "-");
        
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}