/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Codec {
    public class Pair {
        TreeNode node;
        int state = 0;
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        String str = helper(root);
        
        return str;
    }
    
    public String helper(TreeNode node){
        if(node == null){
            return ".";
        }
        
        String left = helper(node.left);
        String right = helper(node.right);
        
        return node.val + " " + left + " " + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("") || data.equals(".")){
            return null;
        }
        
        String[] darray = data.split(" ");
        
        Stack<Pair> st = new Stack<>();
        
        int rootVal = Integer.parseInt(darray[0]);
        
        Pair rootp = new Pair();
        rootp.node = new TreeNode(rootVal);
        st.push(rootp);
        
        int index = 0;            
        while(st.size() > 0) {
            Pair top = st.peek();
            
            if(top.state == 0){
                
                top.state++;
                index++;
                
                if(darray[index].equals(".") == true){
                    continue;
                }
                
                int val = Integer.parseInt(darray[index]);
                Pair lpair = new Pair();
                lpair.node = new TreeNode(val);
                
                top.node.left = lpair.node;
                st.push(lpair);
                    
            } else if (top.state == 1){
                top.state++;
                index++;
                
                if(darray[index].equals(".") == true){
                    continue;
                }          
                
                int val = Integer.parseInt(darray[index]);
                
                Pair rpair = new Pair();
                rpair.node = new TreeNode(val);
                
                top.node.right = rpair.node;
                st.push(rpair);
                
            } else if(top.state == 2){
                st.pop();
            }
        }
        
        return rootp.node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));