class Solution {
    
    HashSet<String> set;
    public int kSimilarity(String s1, String s2) {
        
        Queue<String> queue = new ArrayDeque<>();
        queue.add(s1);
        
        set = new HashSet<>();
        
        int swaps = 0;
        
        while(queue.size() > 0){
            int queueSize = queue.size();
            
            for(int i = 0; i < queueSize; i++){
                String rem = queue.remove();

                if(rem.equals(s2)){
                    return swaps;
                }
                set.add(rem);
                
                int idx = -1;
                for(int j = 0; j < rem.length(); j++){
                    if(rem.charAt(j) != s2.charAt(j)){
                        idx = j;
                        break;
                    }
                }

                addNeighbor(rem, s2, queue, idx);

            }
            
            swaps++;
        
        }
        
        return -1;
    }
    
    public void addNeighbor(String s1, String s2, Queue<String> queue, int idx){
        char ch = s2.charAt(idx);
        
        for(int i = idx + 1; i < s1.length(); i++){
            if(s1.charAt(i) == ch){
                String newStr = swap(s1, idx, i);
                
                if(set.contains(newStr)){
                    continue;
                }
                
                queue.add(newStr);
            }
        }
        
        
    }
    
    public String swap(String str, int i, int j){
        char chari = str.charAt(i);
        char charj = str.charAt(j);
        
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(j, chari);
        sb.setCharAt(i, charj);
        
        return sb.toString();
    }
}