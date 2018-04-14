

public ArrayList<ArrayList<Integer>> printInLayer(TreeNode root){
	ArrayList<ArrayList<Integer>> layerList=new ArrayList<ArrayList<Integer>>();
	if(root==null){
		return layerList;
	}
	Queue<TreeNode> queue=new LinkedList<TreeNode>();
	queue.offer(root);
	int count=1;
	while(!queue.isEmpty()){
		int nextCount=0;
		ArrayList<Integer> layer=new ArrayList<Integer>();
		while(count!=0){
			TreeNode temp=queue.poll();
			count--;
			if(temp.left!=null){
				queue.offer(temp.left);
				nextCount++;
			}
			if(temp.right!=null){
				queue.offer(temp.right);
				nextCount++;
			}
			layer.add(temp.val);
		}
		layerList.add(layer);
		count=nextCount;
	}
	return layerList;
}