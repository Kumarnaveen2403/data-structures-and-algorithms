class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] board = new double[n][n][k + 1];
        board[row][column][0] = 1;
        
        int[][] dirs = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        
        for(int move = 1; move <= k; move++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j][move - 1] > 0){
                        for(int[] dir : dirs){
                            int x = i + dir[0];
                            int y = j + dir[1];
                            
                            if(x >= 0 && x < n && y >= 0 && y < n){
                                board[x][y][move] += board[i][j][move - 1] / 8;
                            }
                        }
                    }
                }
            }
        }
        
        double res = 0;
        
         for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                res += board[i][j][k];
            }
         }
                    
                    
        return res;
    }
}