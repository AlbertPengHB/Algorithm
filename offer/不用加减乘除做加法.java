/* 
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */

/* 
三个步骤：
1、求num1和num2异或求不进位结果  ---->sum
2、求num1和num2与再左移1位求进位结果  ---->carry
3、将sum和carry分别赋给num1和num2直到carry=0为止
 */
public class Solution {
    public int Add(int num1,int num2) {
        if(num2==0){
            return num1;
        }
        int sum;
        int carry;
        while(num2!=0){
            sum=num1^num2;
            carry=(num1&num2)<<1;
            num1=sum;
            num2=carry;
        }
        return num1;
        
    }
}