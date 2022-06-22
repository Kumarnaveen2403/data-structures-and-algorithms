/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        Node lp = root;
        
        while(lp != null){
            Node np = lp;
            
            while(np != null){
                
                if(np.left != null){
                    np.left.next = np.right;
                }
                
                if(np.next != null && np.right != null){
                    np.right.next = np.next.left;
                }
                
                np = np.next;
            }
            
            lp = lp.left;
        }
        
        return root;
    }
}