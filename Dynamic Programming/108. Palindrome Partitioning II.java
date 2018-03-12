/* 
给定一个字符串s，将s分割成一些子串，使每个子串都是回文。
返回s符合要求的的最少分割次数。

样例：
比如，给出字符串s = "aab"，
返回 1， 因为进行一次分割可以将字符串s分割成["aa","b"]这样两个回文子串
 */

// version 1
// f[i] 表示前i个字母，最少可以被分割为多少个回文串
// 最后return f[n] - 1
public class Solution {
	//采用二维数组返回是否为回文串
    private boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length]
                    = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }

        return isPalindrome;
    }

    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // preparation
        boolean[][] isPalindrome = getIsPalindrome(s);
        
        // initialize
        int[] f = new int[s.length() + 1];
        f[0] = 0;
        
        // main
        for (int i = 1; i <= s.length(); i++) {
            f[i] = Integer.MAX_VALUE; // or f[i] = i
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }

        return f[s.length()] - 1;
    }
}