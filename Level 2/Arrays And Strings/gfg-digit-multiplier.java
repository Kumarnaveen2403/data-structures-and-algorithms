class Solution {
    static String getSmallest(Long N) {
        StringBuilder ans = new StringBuilder();
        if(N < 10){
            return N + "";
        }
        
        for(int i = 9; i >= 2; i--){
            while(N % i == 0){
                N = N / i;
                ans.insert(0, i);
            }
        }
        
        if(N >= 10){
            return "-1";
        } else {
            return ans.toString();
        }
        
     }
};