class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < answers.length; i++){
            map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
        }
        
        int count = 0;
        
        for(int key : map.keySet()){
            int val = map.get(key);
            
            count += (int)Math.ceil( (val * 1.0) / (key + 1) * 1.0) * (key + 1);
            
        }
        
        return count;
    }
}