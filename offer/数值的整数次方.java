/* 
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */

//考虑指数为负数的情况
public class Solution {
    public double Power(double base, int exponent) {
        if(exponent<0){
            return Cal(1/base,-exponent);
        }
        else if(exponent>0){
            return Cal(base,exponent);
        }
        return 1;
    }
    
    private double Cal(double base,int exponent) {
        double result=1;
        while(exponent>0){
            result=result*base;
            exponent--;
        }
        return result;
    }
}