class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int[] minArr = new int[arr.length];
        
        int min = Integer.MAX_VALUE;
        for(int i = arr.length - 1; i >= 0; i--){
             if(arr[i] < min){
                 min = arr[i];
             }
            
             minArr[i] = min;
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] > max){
                max = arr[i];
            }
            
            if(max <= minArr[i + 1]){
                chunks++;
            }
        }
        
        return chunks + 1;
    }
}