/* 
输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */


import java.util.*;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> re = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return re;
        }
        HashSet<String> set = new HashSet<String>();
        fun(set, str.toCharArray(), 0);
        re.addAll(set);
        Collections.sort(re);
        return re;
    }

    void fun(HashSet<String> re, char[] str, int k) {
        //当遇到最后一个字符的时候，直接加入集合中
		if (k == str.length) {
            re.add(new String(str));
            return;
        }
		//采用递归的思路进行计算
        for (int i = k; i < str.length; i++) {
            swap(str, i, k);
            fun(re, str, k + 1);
            swap(str, i, k);
        }
    }

    void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }
}