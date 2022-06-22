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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        TreeNode root = construct(0, preorder.length - 1, 0, inorder.length - 1, preorder, map);
        return root;
    }
    
    public TreeNode construct(int pre_lo, int pre_hi, int ino_lo, int ino_hi, int[] pre, HashMap<Integer, Integer> map){
        if(pre_lo > pre_hi || ino_lo > ino_hi){
            return null;
        }
        
        TreeNode node = new TreeNode(pre[pre_lo]);
        
        int idx = map.get(pre[pre_lo]);
    
        int lhs = idx - ino_lo;
        
        node.left = construct(pre_lo + 1, pre_lo + lhs, ino_lo, idx - 1, pre, map);
        node.right = construct(pre_lo + lhs + 1, pre_hi, idx + 1, ino_hi, pre, map);
        
        return node;
    }
}