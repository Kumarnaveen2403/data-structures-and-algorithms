class Solution {
    class Pair{
        String config;
        int level;
        
        Pair(String config, int level){
            this.config = config;
            this.level = level;
        }
    }
    
    public int slidingPuzzle(int[][] board) {
        Queue<Pair> queue = new ArrayDeque<Pair>();
        queue.add(new Pair(boardToString(board), 0));
        
        HashSet<String> set = new HashSet<>();
        
        String solvedConfig = "123450";
        
        int[][] dirs = { {1,3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4} };
        
        while(queue.size() > 0){
            Pair rem = queue.remove();
            
            if(set.contains(rem.config)){
                continue;
            }
            set.add(rem.config);
            
            if(rem.config.equals(solvedConfig)){
                return rem.level;
            }
            
            int idx = -1;
            for(int i = 0; i < rem.config.length(); i++){
                if(rem.config.charAt(i) == '0'){
                    idx = i;
                    break;
                }
            }
            
            int[] dir = dirs[idx];
            
            for(int i : dir){
                String newStr = swap(rem.config, i, idx);
                queue.add(new Pair(newStr, rem.level + 1));
            }
        }
        
        return -1;
    }
    
    public String swap(String str, int i, int j){
        char chari = str.charAt(i);
        char charj = str.charAt(j);
        
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(j, chari);
        sb.setCharAt(i, charj);
        
        return sb.toString();
    }
    
    public String boardToString(int[][] board){
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                sb.append(board[i][j]);
            }
        }
        
        return sb.toString();
    }
}