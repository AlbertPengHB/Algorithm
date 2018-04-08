//设计一个算法来找到最大的利润。你最多可以完成两笔交易。
//交易不能交叉（must sell the stock before you buy again），也就是说我们在遍历价格差找最大获益时，可以首位同时进行。可以用双向动态规划的思想来做。


class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=0){
            return 0;
        }
        
        //存放左半部分最大收益
        int[] left=new int[prices.length];
        //存放右半部分最大收益
        int[] right=new int[prices.length];
        //初始化为0
        int leftMin=prices[0];
        int rightMax=prices[prices.length-1];
        int sum=0;
        //计算左半段最大收益
        for(int i=1;i<prices.length;i++){
            //获取左半部分的最低价
            leftMin=Math.min(prices[i],leftMin);
            //获取左半部分最大收益
            left[i]=Math.max(prices[i]-leftMin,left[i-1]);
        }
        //计算右半段最大收益
        for(int i=prices.length-2;i>=0;i--){
            //获取右半部分最低价
            rightMax=Math.max(prices[i],rightMax);
            //获取右半部分最大收益
            right[i]=Math.max(rightMax-prices[i],right[i+1]);
        }
        //找出两次交易最大收益组合
        for(int i=0;i<prices.length;i++){
            if(left[i]+right[i]>sum){
                sum=left[i]+right[i];
            }
        }
        return sum;
    }
}