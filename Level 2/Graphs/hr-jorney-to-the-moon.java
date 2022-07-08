import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */
    static int[] parent;
    static int[] size;
    
    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
    // Write your code here
        parent = new int[n];
        size = new int[n];
        
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        for(List<Integer> list : astronaut){
            for(int i = 0; i < list.size() - 1; i++){
                int leadA = find(list.get(i));
                int leadB = find(list.get(i + 1));
                
                if(leadA != leadB){
                    union(leadA, leadB);
                }
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == i){
                temp.add(size[i]);
            }
        }
        
        int ans = 0;
        for(int i = 0; i < temp.size(); i++){
            for(int j = i + 1; j < temp.size(); j++){
                ans += temp.get(i) * temp.get(j);
            }
        }
        
        return ans;
    }
    
    static void union(int a, int b){
        if(size[a] < size[b]){
            parent[b] = a;
            size[a] += size[b];
        } else if(size[b] < size[a]){
            parent[a] = b;
            size[b] += size[a];
        } else {
            parent[b] = a;
            size[a] += size[b];
        }
    }
    static int find(int x){
        if(parent[x] == x){
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
