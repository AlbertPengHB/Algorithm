/* 
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */

//把一个整数减去1之后在和原来的整数做位与运算，得到的结果相当于把整数的二进制表示中最左边的1变成0
public class Solution {
    public int NumberOf1(int n) {
        int count=0;
        while(n!=0){
            count++;
            n=(n-1)&n;
        }
        return count;
    }
}