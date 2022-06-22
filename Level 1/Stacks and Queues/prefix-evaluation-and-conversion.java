import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code

    // Stack<Character> operations = new Stack<>();
    Stack<Integer> values = new Stack<>();
    Stack<String> inflix = new Stack<>();
    Stack<String> postfix = new Stack<>();
    
    for(int i = exp.length() - 1; i >= 0; i--){
        char ch = exp.charAt(i);

        if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){

            int res = operate(values, ch);
            values.push(res);

            String in1 = inflix.pop();
            String in2 = inflix.pop();

            inflix.push("(" + in1 + ch + in2 + ")");

            String post1 = postfix.pop();
            String post2 = postfix.pop();

            postfix.push(post1 + post2 + ch);


        } else if(ch >= '0' && ch <= '9'){
            values.push(ch - '0');
            inflix.push(ch + "");
            postfix.push(ch + "");
        }
    }

    System.out.println(values.pop());
    System.out.println(inflix.pop());
    System.out.println(postfix.pop());

 }

 public static int operate(Stack<Integer> values, char op){
     int val1 = values.pop();
     int val2 = values.pop();

     if(op == '+'){
         return val1 + val2;
     } else if(op == '-'){
         return val1 - val2;
     } else if(op == '*'){
         return val1 * val2;
     } else {
         return val1 / val2;
     }
 }

}