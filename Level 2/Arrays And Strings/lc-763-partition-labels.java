class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map[ch - 'a'] = i;
        }
        
        int start = 0, end = -1;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int idx = map[ch - 'a'];
            
            end = Math.max(end, idx);
            
            if(i == end){
                list.add(i - start + 1);
                start = end = i + 1;
            }
        }
        
        return list;
    }
}