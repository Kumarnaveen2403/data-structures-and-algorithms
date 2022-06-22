// using static variable
  public static int dia = 0;
  public static int diameter1(Node node) {
      if(node == null){
          return -1;
      }

      int lh = diameter1(node.left);
      int rh = diameter1(node.right);

      if(lh + rh + 2 > dia){
          dia = lh + rh + 2;
      }

      return Math.max(lh, rh) + 1;
  }

// using heapMover 
 static class DMover{
     int dia;
 }

 public static int diameter2(Node node, DMover mover){
     if(node == null){
         return -1;
     }

     int lh = diameter2(node.left, mover);
     int rh = diameter2(node.right, mover);

     if(lh + rh + 2 > mover.dia){
         mover.dia = lh + rh + 2;
     }

     return Math.max(lh, rh) + 1;
 }

 //using height function to calculate height and returning diameter at every node
 public static int diameter3(Node node){
     if(node == null){
         return 0;
     }

     int lh = height(node.left);
     int rh = height(node.right);

     int ld = diameter3(node.left);
     int rd = diameter3(node.right);

     int dia = Math.max(Math.max(ld, rd), lh + rh + 2);

    return dia;
 }

 //using heamover to return both height and diameter at the same time
 static class DiaMover{
     int height;
     int dia;
 }
 
public static DiaMover diameter4(Node node, DiaMover dm){
    if(node == null){
        DiaMover m = new DiaMover(); 
        m.height = -1;
        m.dia = 0;
        return m;
    }

    DiaMover lm = diameter4(node.left, dm);
    DiaMover rm = diameter4(node.right, dm);

    DiaMover returnMover = new DiaMover();
    returnMover.height = Math.max(lm.height, rm.height) + 1;
    returnMover.dia = Math.max(Math.max(lm.dia, rm.dia), lm.height + rm.height + 2);

    return returnMover;
}