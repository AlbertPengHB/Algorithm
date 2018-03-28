/* 
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 */

 
//Solution1 大数据时效率较低
public class Solution {
    public int Fibonacci(int n) {
        if(n<=0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
}

//Solution2 推荐使用
public class Solution {
    public int Fibonacci(int n) {
        int preNum=1;
        int prepreNum=0;
        int result=0;
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        for(int i=2;i<=n;i++){
            result=preNum+prepreNum;
            prepreNum=preNum;
            preNum=result;
        }
        return result;
    }
}