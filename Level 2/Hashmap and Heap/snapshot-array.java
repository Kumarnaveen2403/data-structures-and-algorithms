class SnapshotArray {
    
    int currentSnapId;
    HashMap<Integer, Integer>[] maps;

    public SnapshotArray(int length) {
        currentSnapId = 0;
        
        maps = new HashMap[length];
        
        for(int i = 0; i < length; i++){
            maps[i] = new HashMap<>();
        }
    }
    
    public void set(int index, int val) {
        maps[index].put(currentSnapId, val);
    }
    
    public int snap() {
        return currentSnapId++;
    }
    
    public int get(int index, int snap_id) {
        
        for(int sidx = snap_id; sidx >= 0; sidx--){
            if(maps[index].containsKey(sidx)){
                return maps[index].get(sidx);
            }
        }
        
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */