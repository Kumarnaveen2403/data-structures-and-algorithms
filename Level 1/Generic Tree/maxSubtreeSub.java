static int maxSum = Integer.MIN_VALUE;
static Node maxSumNode = null;

public static int maxSubtreeSum(Node node){
    int sum = node.data;

    for(Node child : node.children){
        sum += maxSubtreeSum(child);
    }

    if(sum > maxSum){
        maxSum = sum;
        maxSumNode = node;
    }

    return sum;
}

    System.out.println(maxSumNode.data + "@" + maxSum);
