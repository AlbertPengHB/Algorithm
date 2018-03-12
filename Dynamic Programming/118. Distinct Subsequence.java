/* 
给出字符串S和字符串T，计算S的不同的子序列中T出现的个数。
子序列字符串是原始字符串通过删除一些(或零个)产生的一个新的字符串，并且对剩下的字符的相对位置没有影响。(比如，“ACE”是“ABCDE”的子序列字符串,而“AEC”不是)。 
样例:给出S = "rabbbit", T = "rabbit" 返回 3
 */

public class Solution {
    /*
     * @param : A string
     * @param : A string
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if(S.length()<0&&T.length()<0&&S.length()<T.length()){
            return 0;
        }
        int n=S.length();
        int m=T.length();
        int[][] num=new int[n+1][m+1];
        //intialize
		//此时num[i][0]代表当T为空时，子序列始终有一个
        for(int i=0;i<=n;i++){
            num[i][0]=1;
        }
		//此时j应该从大于0开始，num[0][0]=1
        for(int j=1;j<=m;j++){
            num[0][j]=0;
        }
        //function
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(S.charAt(i-1)==T.charAt(j-1)){
                    num[i][j]=num[i-1][j-1]+num[i-1][j];
                }
                else{
                    num[i][j]=num[i-1][j];
                }
            }
        }
        return num[n][m];
    }
};