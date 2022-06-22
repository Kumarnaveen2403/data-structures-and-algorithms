import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> operands = new Stack<>();
    Stack<String> prefix = new Stack<>();
    Stack<String> infix = new Stack<>();
    
    for(int i = 0; i < exp.length(); i++){
        char ch = exp.charAt(i);

        if(ch >= '0' && ch <= '9'){
            operands.push(ch - '0');
            prefix.push(ch + "");
            infix.push(ch + "");
        } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            int ans = process(operands, ch);
            operands.push(ans);

            String preval2 = prefix.pop();
            String preval1 = prefix.pop();
            prefix.push(ch + preval1 + preval2);

            String inval2 = infix.pop();
            String inval1 = infix.pop();
            infix.push("(" + inval1 + ch + inval2 + ")");
        }
    }

    System.out.println(operands.peek());
    System.out.println(infix.peek());
    System.out.println(prefix.peek());
 }

 public static int process(Stack<Integer> operands, char op){
     int v2 = operands.pop();
     int v1 = operands.pop();

     if(op == '+'){
         return v1 + v2;
     } else if(op == '-'){
         return  v1 - v2;
     } else if(op == '*'){
        return  v1 * v2;
     } else {
         return v1 / v2;
     }
 }
}