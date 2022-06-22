class Solution {
    class Pair{
        int i;
        int j;
        int val;

        Pair(int i, int j, int val){
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
    
    public int[][] updateMatrix(int[][] mat) {
     
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    queue.add(new Pair(i, j, 0));
                }
            }
        }
        
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        int[][] ans = new int[mat.length][mat[0].length];
        
        while(queue.size() > 0){
            
            Pair rem = queue.remove();
            
            if(visited[rem.i][rem.j] == true){
                continue;
            }
            visited[rem.i][rem.j] = true;
            
            ans[rem.i][rem.j] = rem.val;
            
            addNeighbours(rem.i + 1, rem.j, rem.val, visited, queue);
            addNeighbours(rem.i - 1, rem.j, rem.val, visited, queue);
            addNeighbours(rem.i, rem.j + 1, rem.val, visited, queue);
            addNeighbours(rem.i, rem.j - 1, rem.val, visited, queue);
        }
        
        return ans;
    }
    
    public void addNeighbours(int i, int j, int val, boolean[][] visited, ArrayDeque<Pair> queue){
        if(i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || visited[i][j] == true){
            return;
        }
        
        queue.add(new Pair(i, j, val + 1));
        
        
    }
    
}