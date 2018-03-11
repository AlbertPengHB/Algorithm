//有一个机器人的位于一个 m × n 个网格左上角。机器人每一时刻只能向下或者向右移动一步。机器人试图达到网格的右下角。问有多少条不同的路径？

public class Solution {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        if(m<=0||n<=0){
            return 0;
        }
        int[][] sum=new int[m][n];
        //对第0行，第0列进行初始化
		for(int j=0;j<n;j++){
            sum[0][j]=1;
        }
        for(int i=0;i<m;i++){
            sum[i][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                sum[i][j]=sum[i][j-1]+sum[i-1][j];
            }
        }
        return sum[m-1][n-1];
    }
}