class Solution {
    
     public boolean isPowerOfTwo(int n) {
        
        if((n & (n - 1)) == 0 && n > 0){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isPowerOfFour(int n) {
        if(!isPowerOfTwo(n)) return false;
        
        int count = 0;
        
        while(n != 1){
            count++;
            n = n >>> 1;
        }
        
        return (count & 1) == 0;
    }
}