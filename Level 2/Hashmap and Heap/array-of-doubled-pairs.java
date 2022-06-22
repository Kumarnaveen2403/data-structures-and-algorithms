class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++){
            int val = arr[i];
            
            if(val != 0){
                hm.put(val, hm.getOrDefault(val, 0) + 1);
            }
        }
        
        Arrays.sort(arr);
        
        for(int i = 0; i < arr.length; i++){
            int val = arr[i];
            
            if(val != 0){
                if(hm.getOrDefault(val, 0) > 0){
                
                if(hm.getOrDefault(val * 2, 0) > 0){
                    if(hm.get(val) == 1){
                        hm.remove(val);  
                    } else {
                        hm.put(val, hm.get(val) - 1);   
                    }
                    
                    if(hm.get(val * 2) == 1){
                        hm.remove(val * 2); 
                    } else {
                        hm.put(val * 2, hm.get(val * 2) - 1);  
                    }
                              
                }
            }   
            }
        }
        
        if(hm.size() == 0) {
            return true;
        } else {
            return false;
        } 
        
        
    }
}