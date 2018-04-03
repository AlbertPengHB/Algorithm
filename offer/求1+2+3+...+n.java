/* 
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */

//利用&&的短路特性，若前面为假就不执行后面的
public class Solution {
    public int Sum_Solution(int n) {
        int sum=n;
        boolean flag=(sum>0)&&((sum+=Sum_Solution(--n))>0);
        return sum;
    }
}