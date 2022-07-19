class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = (n + "").toCharArray();
        
        int i = arr.length - 1;
        while(i != 0 && arr[i] <= arr[i - 1]){
            i--;
        }
        
        if(i == 0){
            return -1;
        }
        
        int j = arr.length - 1;
        
        while(j != 0 && arr[j] <= arr[i -1]){
            j--;
        }
        
        swap(arr, i - 1, j);
        
        int l = arr.length - i;
        j = arr.length - 1;
        
        for(int idx = 0; idx < l / 2; idx++){
            swap(arr, i + idx, j);
            j--;
        }
        
        String num = new String(arr);
        long ans = Long.parseLong(num);
        
        return ans > Integer.MAX_VALUE ? -1 : (int)ans;
    }
    
    void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}