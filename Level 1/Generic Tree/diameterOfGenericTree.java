static int diameter = Integer.MIN_VALUE;

  public static int deepestChildHeight(Node node){
	  int deepestChildHeight = -1;
	  int secondDeepstChildHeight = -1;

	  for(Node child : node.children){
		  int childHeight = deepestChildHeight(child);
		  if(childHeight > deepestChildHeight){
			  secondDeepstChildHeight = deepestChildHeight;
			  deepestChildHeight = childHeight;
		  } else if(childHeight > secondDeepstChildHeight){
			  secondDeepstChildHeight = childHeight;
		  }
	  }

	  if(deepestChildHeight + secondDeepstChildHeight + 2 > diameter){
		  diameter = deepestChildHeight + secondDeepstChildHeight  + 2;
	  }

	return deepestChildHeight + 1;
}