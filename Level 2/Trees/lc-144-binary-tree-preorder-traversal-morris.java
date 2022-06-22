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
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode curr = root;
        
        List<Integer> list = new ArrayList<>();
        
        while(curr != null){
            if(curr.left != null){
                TreeNode iop = curr.left;
                
                while(iop.right != null && iop.right != curr){
                    iop = iop.right;
                }
                
                if(iop.right == null){
                    list.add(curr.val);
                    iop.right = curr;
                    curr = curr.left;
                } else {
                    iop.right = null;
                    curr = curr.right;
                }
                    
            } else {
                list.add(curr.val);
                curr = curr.right;
            }
        }
        
        return list;
    }
}