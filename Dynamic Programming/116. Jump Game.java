//给出一个非负整数数组，你最初定位在数组的第一个位置。数组中的每个元素代表你在那个位置可以跳跃的最大长度。判断你是否能到达数组的最后一个位置。

public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        // write your code here
        if(A==null||A.length==0){
            return false;
        }
        int length=A.length;
        boolean[] result=new boolean[length];
		//初始化第一个数组元素为true
        result[0]=true;
		//循环判定
        for(int i=1;i<length;i++){
            for(int j=0;j<i;j++){
				//当第j个元素可达时，如果当前位置+步数>目标时，元素是可达的
                if(result[j]==true&&j+A[j]>=i){
                    result[i]=true;
                    break;
                }
            }
        }
        return result[length-1];
    }
}