import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code

    Stack<Integer> nums = new Stack<>();
    Stack<Character> ops = new Stack<>();

    for(int i = 0; i < exp.length(); i++){
      char ch = exp.charAt(i);

      if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
        while(ops.size() > 0 && ops.peek() != '(' && precedence(ops.peek()) >= precedence(ch)){
          int ans = calculate(nums, ops);
          nums.push(ans);
        }

        ops.push(ch);
      } else if(ch >= '0' && ch <= '9'){
        nums.push(ch - '0');
      } else if(ch == '('){
        ops.push(ch);
      } else if(ch == ')'){
        while(ops.size() > 0 && ops.peek() != '('){
          int ans = calculate(nums, ops);
          nums.push(ans);
        }
        ops.pop();
      }
    }

    while(ops.size() > 0){
          int ans = calculate(nums, ops);
          nums.push(ans);
    }

    System.out.println(nums.peek());
    
 }

 public static int calculate(Stack<Integer> nums, Stack<Character> ops){
   int v2 = nums.pop(); 
   int v1 = nums.pop(); 
   char op = ops.pop();

    if(op == '+'){
     return v1 + v2;
   } else if(op == '-'){
     return v1 - v2;
   } else if(op == '/'){
     return v1 / v2;
   } else {
     return v1 * v2;
   }
 }

 public static int precedence(char ch){
   if(ch == '+' || ch == '-'){
     return 1;
   } else {
     return 2;
   }
 }
}