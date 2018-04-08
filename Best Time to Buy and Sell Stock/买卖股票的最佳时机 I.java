//如果您只能完成最多一笔交易（即买入和卖出一股股票），则设计一个算法来找到最大的利润。


class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=0){
            return 0;
        }
        int minbuy=prices[0];
        int profit=0;
        //最小买入，最大卖出，得到最大的收益
        for(int i=1;i<prices.length;i++){
            profit=Math.max(profit,prices[i]-minbuy);
            minbuy=Math.min(prices[i],minbuy);
        }
        return profit;
    }
}