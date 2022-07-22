class Solution {
    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                int diag = i - j;
                
                if(map.containsKey(diag)){
                    map.get(diag).add(mat[i][j]);
                } else {
                    map.put(diag, new PriorityQueue<>());
                    map.get(diag).add(mat[i][j]);
                }
            }
        }
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                int diag = i - j;
                
                mat[i][j] = map.get(diag).remove();
            }
        }
        
        return mat;
    }
}