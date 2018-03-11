//给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字上。
/* 
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
 */

 
//Solution1二分法，时间复杂度O(2^n),不好
public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int best=Integer.MAX_VALUE;
    public int minimumTotal(int[][] triangle) {
        // write your code here
        dfs(triangle,0,0,0);
        return best;
    }
    //sum=root->x,y但不包含x,y的路径和
    private void dfs(int[][] triangle,int x,int y,int sum){
        int n=triangle.length;
        if(x==n){
            best=Math.min(best,sum);
            return;
        }
        dfs(triangle,x+1,y,sum+triangle[x][y]);
        dfs(triangle,x+1,y+1,sum+triangle[x][y]);
    }
}


//Solution2分治法，时间复杂度O(2^n),不好
public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
     
    private int[][]triangle;
    private int length;
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int sum=Integer.MAX_VALUE;
        if(triangle==null){
            return sum;
        }
        this.triangle=triangle;
        this.length=triangle.length;
        return Math.min(sum,divideConquer(0,0));
    }
    private int divideConquer(int x,int y){
        if(x==length){
            return 0;
        }
        return triangle[x][y]+Math.min(
                                divideConquer(x+1,y),
                                divideConquer(x+1,y+1)
                                    );
    }
}


//Solution3记忆化搜索，时间复杂度O(n^2),好
public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
     
    private int[][]triangle;
    private int[][]minsum;
    private int length;
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if(triangle==null||triangle.length==0){
            return -1;
        }
        if(triangle[0]==null||triangle[0].length==0){
            return -1;
        }
        this.triangle=triangle;
        this.length=triangle.length; //此时二维数组的两个维都是一样的
        this.minsum=new int[length][length];
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                minsum[i][j]=Integer.MAX_VALUE;
            }
        }
        return divideConquerMemory(0,0);
    }
    private int divideConquerMemory(int x,int y){
        if(x>=length){
            return 0;
        }
        if(minsum[x][y]!=Integer.MAX_VALUE){
            return minsum[x][y];
        }
        minsum[x][y]=Math.min(divideConquerMemory(x+1,y),divideConquerMemory(x+1,y+1))+triangle[x][y];
        return minsum[x][y];
    }
}


//Solution4自底向上，多重循环，时间复杂度O(n^2)
public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if(triangle==null||triangle.length==0){
            return -1;
        }
        if(triangle[0]==null||triangle[0].length==0){
            return -1;
        }
        int length=triangle.length;
        int[][] sum=new int[length][length];
		//初始化最后一层的结果
        for(int k=0;k<length;k++){
            sum[length-1][k]=triangle[length-1][k];
        }
		//对倒数第二层的结果进行计算
        for(int i=length-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                sum[i][j]=Math.min(sum[i+1][j],sum[i+1][j+1])+triangle[i][j];
            }
        }
        return sum[0][0];
    }
}


//Solution5自顶向下,多重循环，时间复杂度O(n^2)
public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if(triangle==null||triangle.length==0){
            return -1;
        }
        if(triangle[0]==null||triangle[0].length==0){
            return -1;
        }
        int length=triangle.length;
        int[][] sum=new int[length][length];
        //初始化
        sum[0][0]=triangle[0][0];
		//左右两条边进行单独考虑初始化
        for(int i=1;i<length;i++){
            sum[i][0]=sum[i-1][0]+triangle[i][0];
            sum[i][i]=sum[i-1][i-1]+triangle[i][i];
        }
        //计算中间部分的最小值
        for(int i=1;i<length;i++){
            for(int j=1;j<i;j++){
                sum[i][j]=Math.min(sum[i-1][j-1],sum[i-1][j])+triangle[i][j];
            }
        }
        int result=Integer.MAX_VALUE;
        for(int i=0;i<length;i++){
            result=Math.min(result,sum[length-1][i]);
        }
        return result;
    }
}