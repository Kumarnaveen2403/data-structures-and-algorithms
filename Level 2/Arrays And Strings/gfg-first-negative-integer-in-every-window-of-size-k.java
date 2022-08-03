class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        long[] ans = new long[N - K + 1];
        int j = 0;
        
        for(int i = 0; i < ans.length; i++){
            if(j < i){
                j = i;
            }
            
            while(A[j] >= 0 && j < A.length - 1){
                j++;
            }
            
            if(j < i + K && A[j] < 0){
                ans[i] = A[j];
            } else {
                ans[i] = 0;
            }
        }
        
        return ans;
    }
}