class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < deck.length; i++){
            int val = deck[i];
            
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        int gcd = map.get(deck[0]);
        
        for(int key : map.keySet()){
            gcd = getGCD(map.get(key), gcd);
        }
        
        if(gcd >= 2){
            return true;
        } else {
            return false;
        }
    } 
    
    public int getGCD(int a, int b){
        int rem = -1;
        
        while(rem != 0){
            
            rem = a % b;
            
            if(rem == 0){
                break;
            }
            
            a = b;
            b = rem;
        }
        
        return b;
    }
}