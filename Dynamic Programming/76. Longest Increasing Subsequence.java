//给定一个整数序列，找到最长上升子序列（LIS），返回LIS的长度。
//样例
//给出 [5,4,1,2,3]，LIS 是 [1,2,3]，返回 3
//给出 [4,2,4,5,3,7]，LIS 是 [2,4,5,7]，返回 4

public class Solution {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums==null||nums.length==0){
            return 0;
        }
        int length=nums.length;
		//将n个数看做n个木桩，目的是从某个木桩出发，从前向后，从低往高，看做多能踩多少个木桩。
        int[] LIS=new int[length];
        for(int i=0;i<length;i++){
            LIS[i]=1;
        }
        for(int i=1;i<length;i++){
			//best用于存储到i之前的LIS长度
            int best=0;
            for(int j=0;j<i;j++){
               if(nums[j]<nums[i]){
                   best=Math.max(LIS[j],best);
               } 
            }
            LIS[i]=best+1;
        }
		//result从所有符合条件的LIS中挑出一个最大的
        int result=0;
        for(int i=0;i<length;i++){
            result=Math.max(result,LIS[i]);
        }
        return result;
    }
}