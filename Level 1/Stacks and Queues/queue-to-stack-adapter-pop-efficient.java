import java.io.*;
import java.util.*;

public class Main {

  public static class QueueToStackAdapter {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapter() {
      mainQ = new ArrayDeque<>();
      helperQ = new ArrayDeque<>();
    }

    int size() {
      // write your code here
      return mainQ.size();
    }

    void push(int val) {
      // write your code here

      helperQ.add(val);

      while(mainQ.size() > 0){
        helperQ.add(mainQ.remove());
      }

      mainQ = helperQ;
      helperQ = new ArrayDeque<>();

    }

    int pop() {
      // write your code here
      if(mainQ.size() == 0){
        System.out.println("Stack underflow");
        return -1;
      }

      return mainQ.remove();

    }

    int top() {
      // write your code here
      if(mainQ.size() == 0){
        System.out.println("Stack underflow");
        return -1;
      }

      return mainQ.peek();

    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    QueueToStackAdapter st = new QueueToStackAdapter();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      }
      str = br.readLine();
    }
  }
}