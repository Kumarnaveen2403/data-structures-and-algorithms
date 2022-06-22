import java.io.*;
import java.util.*;

public class Main {
    static class Pair implements Comparable<Pair>{
        int start; 
        int end;

        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int compareTo(Pair p){
            if(this.start != p.start){
                return this.start - p.start;
            } else {
                return this.end - p.end;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time

        Pair[] pair = new Pair[arr.length];

        for(int i = 0; i < arr.length; i++){
            pair[i] = new Pair(arr[i][0], arr[i][1]);
        }

        Arrays.sort(pair);

        Stack<Pair> st = new Stack<>();
        st.push(pair[0]);

        for(int i = 1; i < arr.length; i++){

            Pair curr = pair[i];
            Pair top = st.peek();

            if ( top.end >= curr.start ){

                st.pop();

                st.push( new Pair( top.start, Math.max( curr.end, top.end ) ) );

            } else if ( top.start == curr.start ) {

                st.pop();

                st.push( new Pair( top.start, Math.max( top.end, curr.end ) ) );

            } else if ( top.end < curr.start ) {

                st.push( new Pair( curr.start, curr.end ) );
            }
        }

        Stack<Pair> temp = new Stack<>();

        while ( st.size() > 0 ) {

            temp.push( st.pop() );
        }

        while(temp.size() > 0){
            System.out.println(temp.peek().start + " " + temp.peek().end);
            temp.pop();
        }


    }

}