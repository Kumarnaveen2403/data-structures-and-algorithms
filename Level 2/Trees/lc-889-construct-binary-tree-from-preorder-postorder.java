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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < postorder.length; i++){
            map.put(postorder[i], i);
        }
        
        
        
        TreeNode root = helper(preorder, postorder, map, 0, preorder.length - 1, 0, postorder.length - 1);
        
        return root;
    }
    
    public TreeNode helper(int[] preorder, int[] postorder, HashMap<Integer, Integer> map,
                            int prelo, int prehi, int postlo, int posthi
                          ){
        if(prelo > prehi || postlo > posthi){
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[prelo]);
        
        if(prelo + 1 <= prehi){
            int index = map.get(preorder[prelo + 1]);
            int count = index - postlo + 1;

            node.left = helper(preorder, postorder, map, prelo + 1, prelo + count, postlo, postlo + count - 1);
            node.right = helper(preorder, postorder, map, prelo + count + 1, prehi, postlo + count , posthi - 1);
            
        }
            
        return node;
        
    }
}