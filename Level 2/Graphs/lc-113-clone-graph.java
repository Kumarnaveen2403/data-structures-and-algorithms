/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        HashMap<Integer, Node> map = new HashMap<>();
        // map.put(node.val, node);
        
        return dfs(node, map);
        
    }
    
    public Node dfs(Node node, HashMap<Integer, Node> map){
        Node cloneNode = new Node(node.val);
        map.put(node.val, cloneNode);
        
        for(Node nbr : node.neighbors){
            if( map.containsKey(nbr.val) ){
                cloneNode.neighbors.add(map.get(nbr.val));
            } else {
                cloneNode.neighbors.add( dfs(nbr, map) );
            }
        }
        
        return cloneNode;
    }
}