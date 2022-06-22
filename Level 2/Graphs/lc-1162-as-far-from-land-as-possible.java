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
    
    public int maxDistance(int[][] grid) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        int maxDist = Integer.MIN_VALUE;
        
        int countLand = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    queue.add(new Pair(i, j, 0));
                    countLand++;
                }
            }
        }
        
        if(countLand == 0 || countLand == grid.length * grid[0].length){
            return -1;
        }
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        // int[][] ans = new int[mat.length][mat[0].length];
        
        while(queue.size() > 0){
            
            Pair rem = queue.remove();
            
            if(visited[rem.i][rem.j] == true){
                continue;
            }
            visited[rem.i][rem.j] = true;
            
            // ans[rem.i][rem.j] = rem.val;
            if(rem.val > maxDist){
                maxDist = rem.val;
            }
            
            addNeighbours(rem.i + 1, rem.j, rem.val, visited, queue);
            addNeighbours(rem.i - 1, rem.j, rem.val, visited, queue);
            addNeighbours(rem.i, rem.j + 1, rem.val, visited, queue);
            addNeighbours(rem.i, rem.j - 1, rem.val, visited, queue);
        }
        
        return maxDist;
    }

     public void addNeighbours(int i, int j, int val, boolean[][] visited, ArrayDeque<Pair> queue){
        if(i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || visited[i][j] == true){
            return;
        }
        
        queue.add(new Pair(i, j, val + 1));
        
        
    }
}