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
class Solution {
    static int count = 0;
    
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        count = 0;
        pathSumRec(root, 0, targetSum, map);
        return count;
    }
    
    public void pathSumRec(TreeNode node, int ssf, int ts, HashMap<Integer, Integer> map){
        if(node == null){
            return;
        }
        
        if(map.containsKey(ssf + node.val - ts) == true){
            count += map.get(ssf + node.val - ts);
        }
        
        map.put(ssf + node.val, map.getOrDefault(ssf + node.val, 0) + 1);
        
        if(node.left != null){
            pathSumRec(node.left, ssf + node.val, ts, map);
        }
        
        if(node.right != null){
            pathSumRec(node.right, ssf + node.val, ts, map);
        }
        
        map.put(ssf + node.val, map.getOrDefault(ssf + node.val, 0) - 1);
        
    }
}