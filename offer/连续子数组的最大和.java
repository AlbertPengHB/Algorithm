/* 
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)
 */

//采用动态规划的思路
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null||array.length<=0){
            return Integer.MIN_VALUE;
        }
        int[] result=new int[array.length];
        result[0]=array[0];
		//采用一个max数值用于保存当前最大子数组和
        int max=result[0];
        for(int i=1;i<array.length;i++){
            if(result[i-1]<=0){
                result[i]=array[i];
            }
            else{
                result[i]=result[i-1]+array[i];
            }
            max=Math.max(max,result[i]);
        }
		//返回当前最大子数组和
        return max;
    }
}