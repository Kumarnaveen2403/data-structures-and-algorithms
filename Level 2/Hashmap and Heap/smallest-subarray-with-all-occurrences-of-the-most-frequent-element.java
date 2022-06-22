import java.util.*;

public class Main {

    static class Pair {
        int si;
        int freq;
        int len;
        
        Pair(int si, int freq, int len){
            this.si =  si;
            this.freq = freq;
            this.len = len;
        }
    }

    public static void solution(int[] arr) {
        
        HashMap<Integer, Pair> map = new HashMap<>();
        
        int max = arr[0];
        
        int maxlen = 1;
        int maxfreq = 1;
        int startIdx = 0;
        
        for(int i = 0; i < arr.length; i++){
            int val = arr[i];

            if(map.containsKey(val) == true){
                Pair pair = map.get(val);
                pair.freq++;
                pair.len = i - pair.si + 1;
                
                if(pair.freq > maxfreq){
                    maxlen = pair.len;
                    max = val;
                    maxfreq = pair.freq;
                    startIdx = pair.si;
                } else if(pair.freq == maxfreq && pair.len < maxlen){
                    maxlen = pair.len;
                    max = val;
                    maxfreq = pair.freq;
                    startIdx = pair.si;
                } else if(pair.len == maxlen && pair.si < startIdx){
                    maxlen = pair.len;
                    max = val;
                    maxfreq = pair.freq;
                    startIdx = pair.si;
                }

            } else {
                map.put(val, new Pair(i, 1, 1));
            }
        }
        
        System.out.println(max);
        System.out.println(startIdx);
        System.out.println(maxlen - 1 + startIdx);
        
        return;
    }
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
                solution(arr);
	}

}
