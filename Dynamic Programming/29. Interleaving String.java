/* 
 给出三个字符串:s1、s2、s3，判断s3是否由s1和s2交叉构成。
 样例
比如 s1 = "aabcc" s2 = "dbbca"
    - 当 s3 = "aadbbcbcac"，返回 true.
    - 当 s3 = "aadbbbaccc"， 返回 false.
 */

 
public class Solution {
    /**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int n=s1.length();
        int m=s2.length();
        int k=s3.length();
        boolean[][] result=new boolean[n+1][m+1];
        //intialize
		//当s1和s2都为空的时候，为了方便后面计算需要设result[0][0]=true
        result[0][0]=true;
        //此时后一个结果取决于s1的前一个子串是否组成了s3
		for(int i=1;i<=n;i++){
            if(s1.charAt(i-1)==s3.charAt(i-1) && result[i - 1][0]){
                result[i][0]=true;
            }
        }
        for(int i=1;i<=m;i++){
            if(s2.charAt(i-1)==s3.charAt(i-1)&&result[0][i-1]){
                result[0][i]=true;
            }
        }
        //function
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
				//分别考虑当s3的最后一个字符与s1或s2的最后一个字符相等的情况
                if(((s3.charAt(i+j-1)==s1.charAt(i-1))&&result[i-1][j])||
                ((s3.charAt(i+j-1)==s2.charAt(j-1))&&result[i][j-1])){
                    result[i][j]=true;
                }
            }
        }
        return result[n][m];
    }
}