public class Solution {
    public int books(ArrayList<Integer> A, int B) {
        if(A.size() < B){
            return -1;
        }
        
        int lo = Integer.MIN_VALUE;
        int hi = 0;
        
        for(int num : A){
            lo = Math.max(lo, num);
            hi += num;
        }
        
        while(lo < hi){
            int mid = (lo + hi) / 2;
            
            int total = 0;
            int parts = 1;
            for(int num : A){
                if(total + num <= mid){
                    total += num;
                } else {
                    total = num;
                    parts++;
                }
            }
            
            if(parts > B){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        return lo;
    }
}
