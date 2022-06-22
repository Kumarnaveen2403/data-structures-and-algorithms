class LRUCache {

    static class Node {
        Node prev;
        Node next;
        
        int key;
        int val;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    Node head;
    Node tail;
    int cap;
    int size;
    
    HashMap<Integer, Node> map = new  HashMap<>();
    
    private void addFirst(int key, int value){
        if(head == null){
            Node node = new Node(key, value);
            
            head = tail = node;//
        } else {
            Node node = new Node(key, value);
            node.next = head;//
            head.prev = node;
            head = node;
        }
        
        size++;
    }
    
    private void remove(Node node){
        if(head == null || node == null){
            return;
        } else if(head == tail) {
            head = tail = null;
        }else if(node == head){
            head = node.next;
            head.prev = null;
        } else if(node == tail){
            Node prevNode = tail.prev;
            prevNode.next = null;
            tail = prevNode;
        } else {
            Node np1 = node.next;
            Node nm1 = node.prev;
            nm1.next = np1;
            np1.prev = nm1;
        }
        
        size--;
    }
    
    public LRUCache(int capacity) {
        this.size = 0;
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key) == false){
            return -1;
        }
        
        Node node = map.get(key);
        
        remove(node);
        
        addFirst(node.key, node.val);
        map.put(key, head);
        
        return head.val;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key) == true){
            Node node = map.get(key);
            remove(node);
            addFirst(key, value);
            map.put(key, head);
        } else {
            if(size == cap){
                map.remove(tail.key);//
                remove(tail);
                addFirst(key, value);
                map.put(key, head);
            } else {
                addFirst(key, value);
                map.put(key, head);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */