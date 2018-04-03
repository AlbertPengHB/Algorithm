/* 
请实现两个函数，分别用来序列化和反序列化二叉树
 */


/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    private int index=-1;
	//序列化二叉树的时候，采用StringBuilder添加字符串流，最后返回的时候将其转化为String类型
	//递归思路
    String Serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        if(root==null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
	
	//反序列化的时候，将其转化为一个字符串数组，进行逐个字符比对
    TreeNode Deserialize(String str) {
        index++;
        String[] strMatrix=str.split(","); 
        TreeNode root=null;
		//字符串的比对需要用equals比较具体值，不能用=
        if(!strMatrix[index].equals("#")){
            root=new TreeNode(Integer.valueOf(strMatrix[index]));
			//反序列化左右子树
            root.left=Deserialize(str);
            root.right=Deserialize(str);
        }
        return root;
    }
}