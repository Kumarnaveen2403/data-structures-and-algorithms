class Solution {
    class Pair implements Comparable<Pair>{
        int coordinate;
        int height;
        
        Pair(int coordinate, int height){
            this.coordinate = coordinate;
            this.height = height;
        }
    
        public int compareTo(Pair other){
            if(this.coordinate == other.coordinate){
                return this.height - other.height;
            } else {
                 return this.coordinate - other.coordinate;
            }
        }
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        ArrayList<Pair> pairs = new ArrayList<>();
        
        for(int i = 0; i < buildings.length; i++){
            int start = buildings[i][0];
            int end = buildings[i][1];
            int height = buildings[i][2];
            
            pairs.add(new Pair(start, height * -1));
            pairs.add(new Pair(end, height));
        }
        
        Collections.sort(pairs);
        
        List<List<Integer>> sol = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        int currHeight = 0;
        queue.add(0);
        
        for(Pair p : pairs){
            if(p.height < 0){
                queue.add(p.height * -1);
            } else {
                queue.remove(p.height);   
            }
            
            if(currHeight < queue.peek()){
                currHeight = queue.peek();
                
                List<Integer> list = new ArrayList<>();
                list.add(p.coordinate);
                list.add(currHeight);
                    
                sol.add(list);
            } else if(currHeight > queue.peek()){
                currHeight = queue.peek();
                
                List<Integer> list = new ArrayList<>();
                list.add(p.coordinate);
                list.add(currHeight);
                
                sol.add(list);
            }
            
        }
        
        return sol;
    }
}