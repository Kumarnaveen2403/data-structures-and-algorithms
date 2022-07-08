class Solution {
    public int minDeletions(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int[] arr = new int[26];
        int maxFreq = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int index = ch - 'a';
            
            arr[index]++;
            if(arr[index] > maxFreq){
                maxFreq = arr[index];
            }
        }
        
        int deletions = 0;
        int[] dp = new int[maxFreq + 1];
        
         for(int i = 0; i < 26; i++){
            if(arr[i] > 0){
                dp[arr[i]]++;
            }
        }
        
        for(int i = dp.length - 1; i > 0; i--){
            int freq = dp[i];
            
            if(freq > 1){
                deletions += freq - 1;
                dp[i - 1] += freq - 1;
            }
        }
        
        
        return deletions;
    }
}