/* 
给出两个字符串，找到最长公共子序列(LCS)，返回LCS的长度。
最长公共子序列的定义：最长公共子序列问题是在一组序列（通常2个）中找到最长公共子序列（注意：不同于子串，LCS不需要是连续的子串）。该问题是典型的计算机科学问题，是文件差异比较程序的基础，在生物信息学中也有所应用。
样例:
给出"ABCD" 和 "EDCA"，这个LCS是 "A" (或 D或C)，返回1
给出 "ABCD" 和 "EACB"，这个LCS是"AC"返回 2
 */


public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if(A.length()<=0&&B.length()<=0){
            return 0;
        }
        int n=A.length();
        int m=B.length();
        int[][] LCS=new int[n+1][m+1];
        //initialize
        for(int i=0;i<=n;i++){
            LCS[i][0]=0;
        }
        for(int i=0;i<=m;i++){
            LCS[0][i]=0;
        }
        //function
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                if(A.charAt(i - 1) == B.charAt(j - 1)){
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                }
            }
        }
        return LCS[n][m];
    }
}