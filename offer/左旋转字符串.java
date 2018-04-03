/* 
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！

 */

//三步翻转法：1、翻转左半边；2、翻转右半边；3、整个字符串翻转
public class Solution {
    public String LeftRotateString(String str,int n) {
        //考虑str=“ ”的时候，因此后面需要判定str.length<=0
		if(str==null||str.length()<=0||n<=0){
            return str;
        }
        n=n%str.length();
        char[] chars=str.toCharArray();
        reverse(chars,0,n-1);
        reverse(chars,n,chars.length-1);
        reverse(chars,0,chars.length-1);
        return new String(chars);
    }
    
    private void reverse(char[] chars,int low,int high){
        while(high>low){
            char temp=chars[low];
            chars[low]=chars[high];
            chars[high]=temp;
            high--;
            low++;
        }
    }
}