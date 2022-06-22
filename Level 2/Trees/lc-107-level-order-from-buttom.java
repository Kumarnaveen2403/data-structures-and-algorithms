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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            List<List<Integer>> list = new ArrayList<>();
            return list;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> tempList = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        
        while(queue.size() > 0){
            TreeNode temp = queue.remove();
            
            if(temp != null){
                tempList.add(temp.val);
                
                if(temp.left != null){
                    queue.add(temp.left);
                }
                
                if(temp.right != null){
                    queue.add(temp.right);
                }
                
            } else {
                if(queue.size() > 0){
                    queue.add(null);
                }
                
                stack.push(tempList);
                tempList = new ArrayList<>();
            }
        }
        
        while(stack.size() > 0){
            ret.add(stack.pop());
        }
        
        return ret;
    }
}