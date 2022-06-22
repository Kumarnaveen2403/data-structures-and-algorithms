import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Character> operations = new Stack<>();
    Stack<String> postfix = new Stack<>();
    Stack<String> prefix = new Stack<>();

    for(int i = 0; i < exp.length(); i++){
        char ch = exp.charAt(i);

        if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            while(operations.size() > 0 && precedence(operations.peek()) >= precedence(ch) && operations.peek() != '('){
                process(operations, postfix, prefix);
            }
            operations.push(ch);
        } else if(ch == '('){
            operations.push(ch);
        } else if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z'){
            postfix.push(ch + "");
            prefix.push(ch + "");
        } else if(ch == ')'){
            while(operations.size() > 0 && operations.peek() != '('){
                process(operations, postfix, prefix);
            }
            operations.pop();
        }

    }

    while(operations.size() > 0){
        process(operations, postfix, prefix);
    }

    System.out.println(postfix.peek());
    System.out.println(prefix.peek());
 }

 public static int precedence(char op){
     if(op == '+' || op == '-'){
         return 1;
     } else {
         return 2;
     }
 }

 public static void process(Stack<Character> operations, Stack<String> postfix, Stack<String> prefix){
     char ch = operations.pop();

     //postfix

     String postVal2 = postfix.pop();
     String postVal1 = postfix.pop();

    postfix.push(postVal1 + postVal2 + ch);

    //prefix
     String pretVal2 = prefix.pop();
     String preVal1 = prefix.pop();

    prefix.push(ch + preVal1 + pretVal2);
     
 }
}