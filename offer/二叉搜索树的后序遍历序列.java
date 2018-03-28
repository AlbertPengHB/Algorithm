/* 
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */

//采用递归的方式
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length<=0){
            return false;
        }
        return IsTreeBST(sequence, 0, sequence.length-1);
    }
    public boolean IsTreeBST(int[] sequence,int start,int end){
        if(start>=end){
            return true;
        }
        int i=start;
		//判断出左子树的位置
		//此时i的输出位置为第一个右子树根结点
        for(;i<end;i++){
            if(sequence[i]>sequence[end]){
                break;
            }
        }
		//判断右子树的位置是否都大于根结点
        for(int j=i;j<end;j++){
            if(sequence[j]<sequence[end]){
                return false;
            }
        }
		//进行递归调用分别判定左右子树
        return IsTreeBST(sequence,start,i-1)&&IsTreeBST(sequence,i,end-1);
    }
}