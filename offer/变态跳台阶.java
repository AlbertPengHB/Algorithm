/* 
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */


//f[n]=f[1]+f[2]+...f[n-1]+1
public class Solution {
    public int JumpFloorII(int target) {
        if(target<=0){
            return 0;
        }
        int[] result=new int[target+1];
        result[0]=0;
        result[1]=1;
        for(int i=2;i<=target;i++){
            for(int j=1;j<i;j++){
                result[i]=result[i]+result[j];
            }
            result[i]=result[i]+1;
        }
        return result[target];
    }
}


//f[n]=2*f[n-1]
public class Solution {
    public int JumpFloorII(int target) {
        if(target<=0){
            return 0;
        }
        int[] result=new int[target+1];
        result[0]=0;
        result[1]=1;
        for(int i=2;i<=target;i++){
            result[i]=result[i-1]*2;
        }
        return result[target];
    }
}