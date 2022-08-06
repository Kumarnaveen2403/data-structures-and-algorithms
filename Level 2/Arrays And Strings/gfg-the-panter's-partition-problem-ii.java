class Solution{
    static long minTime(int[] arr,int n,int k){
        long lo = Integer.MIN_VALUE;
        long hi = 0;
        
        for(int num : arr){
            hi += num;
            lo = Math.max(lo, num);
        }
        
        while(lo < hi){
            long limit = (lo + hi) / 2;
            
            int parts = 1;
            int totalTime = 0;
            for(int num : arr){
                if(totalTime + num <= limit){
                    totalTime += num;
                } else {
                    totalTime = num;
                    parts++;
                }
            }
            
            if(parts > k){
                lo = limit + 1;
            } else {
                hi = limit;
            }
            
        }
        
        return lo;
    }
}