class Solution {
    public int findKthNumber(int m, int n, int k) { 
        int lo = 1;
        int hi = m * n;
        
        while(lo < hi){
            int mid = (lo + hi) / 2;
            
            int smaller = 0;
            int j = n;
            for(int i = 1; i <= m; i++){
                while(j >= 1 && i * j > mid){
                    j--;
                }
                smaller += j;
            }
            
            if(smaller < k){
                lo = mid + 1;
            } else {
                hi = mid;
            }
            
        }
        
        return lo;
    }
}