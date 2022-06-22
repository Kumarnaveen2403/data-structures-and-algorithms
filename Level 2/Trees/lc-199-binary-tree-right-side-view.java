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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        List<Integer> list = new ArrayList<>();
        
        while(queue.size() > 0){
            int levelSize = queue.size();
            
            for(int i = 0; i < levelSize; i++){
                TreeNode node = queue.remove();
                
                if(node.left != null){
                    queue.add(node.left);
                }
                
                if(node.right != null){
                    queue.add(node.right);
                }
                
                if(i == levelSize - 1){
                    list.add(node.val);
                }
            }
        }
        
        return list;
    }
}