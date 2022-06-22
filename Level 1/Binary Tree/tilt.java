// using static variable
  static int tilt = 0;
  public static int tilt1(Node node){
      if(node == null){
          return 0;
      }

      int lsum = tilt1(node.left);
      int rsum = tilt1(node.right);

      int nodeTilt = Math.abs(lsum - rsum);

      tilt += nodeTilt;

      return lsum + rsum + node.data;
  }

// using Pair class to return two values at once
static class TPair{
    int tiltSum  = 0;
    int sum = 0;
}
  public static TPair tilt2(Node node, TPair tpair){
      if(node == null){
          TPair pair = new TPair();
          pair.tiltSum = 0;
          pair.sum = 0;
          return pair;
      }

      TPair lpair = tilt2(node.left, tpair);
      TPair rpair = tilt2(node.right, tpair);

      TPair returnPair = new TPair();
      returnPair.sum = lpair.sum + rpair.sum + node.data;
      int tilt = Math.abs(lpair.sum - rpair.sum);
      returnPair.tiltSum = lpair.tiltSum + rpair.tiltSum + tilt;

      return returnPair;
  }