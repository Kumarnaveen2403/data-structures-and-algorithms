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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        TreeNode root = construct(0, postorder.length - 1, 0, inorder.length - 1, postorder, map);
        return root;
    }
    
    public TreeNode construct(int post_lo, int post_hi, int in_lo, int in_hi, int[] post, HashMap<Integer, Integer> map){
        if(post_lo > post_hi || in_lo > in_hi){
            return null;
        }
        
        TreeNode node = new TreeNode(post[post_hi]);
        
        int idx = map.get(post[post_hi]);
    
        int lhs = idx - in_lo;
        
        node.left = construct(post_lo, post_lo + lhs - 1, in_lo, idx - 1, post, map);
        node.right = construct(post_lo + lhs, post_hi - 1, idx + 1, in_hi, post, map);
        
        return node;
    }
}