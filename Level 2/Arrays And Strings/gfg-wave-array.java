
class Solution {
    public static void convertToWave(int n, int[] a) {
        
        for(int i = 0; i < a.length; i++){
            if(i % 2 == 0){
                if(i + 1 < a.length){
                    swap(a, i, i + 1);
                }
            }
        }
        
    }
    
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
        
