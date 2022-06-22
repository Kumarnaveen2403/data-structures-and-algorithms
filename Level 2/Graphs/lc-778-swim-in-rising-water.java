class Solution {
    class Pair implements Comparable<Pair>{
        int i;
        int j;
        int tsf;
        
        Pair(int i, int j, int tsf){
            this.i = i;
            this.j = j;
            this.tsf = tsf;
        }
        
        public int compareTo(Pair other){
            return this.tsf - other.tsf;
        }
    }
    
    public int swimInWater(int[][] grid) {
        
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0, 0, grid[0][0]));
        
        int minTime = 0;
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        while(queue.size() > 0){
            
            Pair rem = queue.remove();
            
            if(visited[rem.i][rem.j] == true){
                continue;
            }
            visited[rem.i][rem.j] = true;
            
            // minTime = rem.tsf;
            
            if(rem.i == grid.length - 1 && rem.j == grid[0].length - 1){
                return rem.tsf;
            }
            
            addNeighbour(rem.i + 1, rem.j, rem.tsf, queue, visited, grid);
            addNeighbour(rem.i - 1, rem.j, rem.tsf, queue, visited, grid);
            addNeighbour(rem.i, rem.j + 1, rem.tsf, queue, visited, grid);
            addNeighbour(rem.i, rem.j - 1, rem.tsf, queue, visited, grid);

        }
        
        
        return minTime;
    }
    
    public void addNeighbour(int i, int j, int tsf, PriorityQueue<Pair> queue, boolean[][] visited, int[][] grid){
        if(i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || visited[i][j] == true){
            return;
        }
        
        queue.add(new Pair(i, j, Math.max(tsf, grid[i][j])));
    }
}