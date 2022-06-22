class Solution {
    public class Pair{
        int x;
        int y;
        int t;
        
        Pair(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        
        Queue<Pair> queue = new ArrayDeque<>();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i, j, 0));
                } else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        
        int time = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        while(queue.size() > 0){
            Pair rm = queue.remove();
            
            if(visited[rm.x][rm.y] == true){
                continue;
            }
            
            visited[rm.x][rm.y] = true;
            
            time = rm.t;
            
            if(grid[rm.x][rm.y] == 1){
                fresh--;
            }
            
            addToQueue(rm.x + 1, rm.y, rm.t, grid, queue, visited);
            addToQueue(rm.x - 1, rm.y, rm.t, grid, queue, visited);
            addToQueue(rm.x, rm.y + 1, rm.t, grid, queue, visited);
            addToQueue(rm.x, rm.y - 1, rm.t, grid, queue, visited);

        }
        
        if(fresh == 0){
            return time;
        } else {
            return -1;
        }
        
    }
    
    public void addToQueue(int i, int j, int t, int[][] grid, Queue<Pair> queue, boolean[][] visited){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        } else if(grid[i][j] == 0){
            return;
        } else if(visited[i][j] == true){
            return;
        }
        
        if(grid[i][j] == 1){
            queue.add(new Pair(i, j, t + 1));
        }
        
    }
}