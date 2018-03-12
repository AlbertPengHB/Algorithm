/* 
给出两个单词word1和word2，计算出将word1 转换为word2的最少操作次数。
你总共三种操作方法：插入一个字符、删除一个字符、替换一个字符
样例：
给出 work1="mart" 和 work2="karma" 返回 3
 */

public class Solution {
    /**
     * @param word1: A string
     * @param word2: A string
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        if(word1.length()<0&&word2.length()<0){
            return -1;
        }
        int n=word1.length();
        int m=word2.length();
        //initialize
        int[][] distance=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            distance[i][0]=i; //Delete i 次
        }
        for(int i=0;i<=m;i++){
            distance[0][i]=i; //Insert i 次
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){  //如果第i个字符和第j个字符相等情况
                    distance[i][j]=Math.min(
                        distance[i-1][j]+1, //Delete i
                        Math.min(
                            distance[i-1][j-1],  //比较前一次的结果
                            distance[i][j-1]+1  //Insert i
                            )
                        );
                    
                }
                else{
                    distance[i][j]=Math.min(
                        distance[i][j-1]+1, //Insert i
                        Math.min(
                            distance[i-1][j-1]+1,  //Replace i
                            distance[i-1][j]+1  //Delete i
                            )
                        );
                }
            }
        }
        return distance[n][m];
    }
}