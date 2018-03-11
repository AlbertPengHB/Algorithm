//假设你正在爬楼梯，需要n步你才能到达顶部。但每次你只能爬一步或者两步，你能有多少种不同的方法爬到楼顶部？

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if(n<=0){
            return 0;
        }
		//此时如果采用数组的形式应该生成n+1维的数组
        int[] sum=new int[n+1];
        sum[0]=1;
        sum[1]=1;
		//此时的循环应包含等号（代数值及进行计算）
        for(int i=2;i<=n;i++){
            sum[i]=sum[i-1]+sum[i-2];
        }
		//返回的结果应该是sum[n]（代数值计算）
        return sum[n];
    }
}