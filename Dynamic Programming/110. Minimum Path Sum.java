//给定一个只含非负整数的m*n网格，找到一条从左上角到右下角的可以使数字和最小的路径。

public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if(grid==null||grid.length==0){
            return -1;
        }
        if(grid[0]==null||grid[0].length==0){
            return -1;
        }
        int m=grid.length;
        int n=grid[0].length;
        int[][] sum=new int[m][n];
        sum[0][0]=grid[0][0];
        //对第0行，第0列进行单独初始化
		for(int i=1;i<m;i++){
            sum[i][0]=sum[i-1][0]+grid[i][0];
        }
        for(int j=1;j<n;j++){
            sum[0][j]=sum[0][j-1]+grid[0][j];
        }
		//计算到每个点的最小路径和
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                sum[i][j]=Math.min(sum[i][j-1],sum[i-1][j])+grid[i][j];
            }
        }
        return sum[m-1][n-1];
    }
}