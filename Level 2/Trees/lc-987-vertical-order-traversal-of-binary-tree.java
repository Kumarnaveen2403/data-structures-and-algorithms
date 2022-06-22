/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair implements Comparable<Pair>{
    TreeNode node;
    int horizontal;
    int level;
    
    Pair(TreeNode node, int horizontal, int level){
        this.node = node;
        this.horizontal = horizontal;
        this.level = level;
    }
    
    public int compareTo(Pair other){
        if(other.level == this.level){
            return this.node.val - other.node.val;
        } else {
            return this.level - other.level;
        }
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0, 0));
        
        HashMap<Integer, PriorityQueue<Pair>> map = new HashMap<>();
        
        int min = 0;
        int max = 0;
        
        while(queue.size() > 0){
            Pair temp = queue.remove();
            
            if(map.containsKey(temp.horizontal) == true){
                map.get(temp.horizontal).add(temp);
            } else {
                map.put(temp.horizontal, new PriorityQueue<Pair>());
                map.get(temp.horizontal).add(temp);
            }

            if(temp.horizontal < min){
                min = temp.horizontal;
            }

            if(temp.horizontal > max){
                max = temp.horizontal;
            }

            if(temp.node.left != null){
                queue.add(new Pair(temp.node.left, temp.horizontal - 1, temp.level + 1));
            }
            
             if(temp.node.right != null){
                queue.add(new Pair(temp.node.right, temp.horizontal + 1, temp.level + 1));
            }
            
           
        }
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = min; i <= max; i++){
            PriorityQueue<Pair> pq = map.get(i);
            List<Integer> tlist = new ArrayList<>();
            
            while(pq.size() > 0){
                tlist.add(pq.remove().node.val);
            }
            
            list.add(tlist);
        }
        
        return list;
    }
}