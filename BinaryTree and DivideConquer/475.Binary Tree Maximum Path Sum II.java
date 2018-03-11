//Given a binary tree, find the maximum path sum from root.
//The path may end at any node in the tree and contain at least one node in it

public Solution{
	public int MaxPathSum(TreeNode root){
		if(root==null){
			return 0;
		}
		int left=MaxPathSum(root.left);
		int right=MaxPathSum(root.right);
		return (Math.max(0,Math.max(left,right))+root.val);
	}
}