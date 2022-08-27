class Solution {
    long MOD = 1000000000 + 7;
    
    long countStrings(int n) {
        long zero = 1;
        long one = 1;
        
        for(int i = 2; i <= n; i++){
            long no = zero;
            long nz = (one + zero) % MOD;
            
            one = no;
            zero = nz;
        }
        
        return (one + zero) % MOD;
    }
}