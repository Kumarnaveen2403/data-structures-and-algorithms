class Solution {
    public String pushDominoes(String dominoes) {
        String str = 'L' + dominoes + 'R';
        char[] arr = str.toCharArray();
        char prev = arr[0];
        int prevIdx = 0;
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == 'L'){
                if(prev == 'L'){
                    for(int j = i - 1; j > prevIdx; j--){
                        arr[j] = 'L';
                    }
                } else if(prev == 'R'){
                    int l = prevIdx, r = i;
                    while(l < r){
                        if(l != r){
                           arr[l] = 'R';
                           arr[r] = 'L';
                        }
             
                       l++;
                       r--;
                    }
                }
                
                prev = arr[i];
                prevIdx = i;
            } else if(arr[i] == 'R'){
                 if(prev == 'L'){
                    //no action
                } else if(prev == 'R'){
                    for(int j = i - 1; j > prevIdx; j--){
                        arr[j] = 'R';
                    }
                }
                
                prev = arr[i];
                prevIdx = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < arr.length - 1; i++){
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}