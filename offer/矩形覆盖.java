/* 
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
 
//result[i]=result[i-1]+result[i-2]
public class Solution {
    public int RectCover(int target) {
        if(target<=0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        int[] result=new int[target+1];
        result[1]=1;
        result[2]=2;
        for(int i=3;i<=target;i++){
            result[i]=result[i-1]+result[i-2];
        }
        return result[target];
    }
}