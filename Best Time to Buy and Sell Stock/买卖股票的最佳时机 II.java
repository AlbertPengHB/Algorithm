//设计一个算法来找到最大的利润。你可以完成尽可能多的交易（多次买卖股票）。然而，你不能同时参与多个交易（你必须在再次购买前出售股票）。

class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=0){
            return 0;
        }
        int profit=0;
        for(int i=1;i<prices.length;i++){
            //只要当前价格大于前一天的价格，就可将其放入收益
            //d-a=(d-c)+(c-b)+(b-a)
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}