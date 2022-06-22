//approach 1 using find and complement
public static boolean find(Node node, int data){
    if(node == null){
        return false;
    }
    
    boolean ans = false;

    if(node.data == data){
        ans = true;
    } else if(node.data > data){
        ans = find(node.left, data);
    } else if(node.data < data){
        ans = find(node.right, data);
    }
    
    return ans;
}

public static void tsp(Node node, int data, Node root){
    if(node == null){
        return;
    }
    tsp(node.left, data, root);

    int comp = data - node.data;
    boolean isPairFound = find(root, comp);

    if(isPairFound == true){
        if(comp > node.data){
            System.out.println(node.data + " " + comp);
        }
    }

    tsp(node.right, data, root);
}

//aproach 2 making an arraylist by traversing inorder and applying the target sum pair
//algorithm on the array

public static ArrayList<Integer> list = new ArrayList<>();
public static void tsp(Node node, int data){
    if(node == null){;
        return;
    }
    
    tsp(node.left, data);
    list.add(node.data);
    tsp(node.right, data);
}

    int i = 0, j = myList.size() - 1;
    while(i < j){
        if(myList.get(i) + myList.get(j) == data){
            System.out.println(myList.get(i) + " " + myList.get(j));
            i++;
            j--;
        } else if(myList.get(i) + myList.get(j) < data){
            i++;
        } else if(myList.get(i) + myList.get(j) > data){
            j--;
        }
    }
    
// approach 3 using iterative inorder traversal and traversing from front back and using
// the sorted array algorithm to find target sum

public static class TSPair{
    Node node;
    int state;

    TSPair(Node node, int state){
        this.node = node;
        this.state = state;
    }
}

public static void tsp(Node node, int tar){
    Stack<TSPair> ls = new Stack<>();
    TSPair lp = new TSPair(node, 0);
    ls.push(lp);

    Stack<TSPair> rs = new Stack<>();
    TSPair rp = new TSPair(node, 0);
    rs.push(rp);

    Node left = getNextFromInorder(ls);
    Node right = getNextFromReverseInorder(rs);

    while(left.data < right.data){
        if(left.data + right.data > tar){
            right = getNextFromReverseInorder(rs);
        } else if(left.data + right.data < tar){
            left = getNextFromInorder(ls);
        } else {
            System.out.println(left.data + " " + right.data);
            right = getNextFromReverseInorder(rs);
            left = getNextFromInorder(ls);
        }
    }

}

public static Node getNextFromInorder(Stack<TSPair> stack){
    while(stack.size() > 0){
        TSPair top = stack.peek();

        if(top.state == 0){
            if(top.node.left != null){
                stack.push(new TSPair(top.node.left, 0));
            }
            top.state++;
        } else if(top.state == 1){
            if(top.node.right != null){
                stack.push(new TSPair(top.node.right, 0));
            }
            top.state++;
            return top.node;
        } else {
            stack.pop();
        }
    }

    return null;
}

public static Node getNextFromReverseInorder(Stack<TSPair> stack){
    while(stack.size() > 0){
        TSPair top = stack.peek();

        if(top.state == 0){
            if(top.node.right != null){
                stack.push(new TSPair(top.node.right, 0));
            }
            top.state++;
        } else if(top.state == 1){
            if(top.node.left != null){
                stack.push(new TSPair(top.node.left, 0));
            }
            top.state++;
            return top.node;
        } else {
            stack.pop();
        }
    }

    return null;
}