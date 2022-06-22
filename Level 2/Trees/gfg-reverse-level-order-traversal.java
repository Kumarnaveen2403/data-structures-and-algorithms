        if(root == null){
            List<List<Integer>> list = new ArrayList<>();
            return list;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        Stack<List<Integer>> stack = new Stack<>();
        
        List<Integer> tempList = new ArrayList<>();
        
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
                queue.add(null);
                stack.push(tempList);
                tempList = new ArrayList<>();
            }
        }
        
        List<List<Integer>> ret = new ArrayList<>();
        
        while(stack.size() > 0){
            ret.add(stack.pop());
        }
        
        return ret;
    }