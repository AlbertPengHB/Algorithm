/* 
把只包含因子2、3和5的数称作丑数（Ugly Number）。
例如6、8都是丑数，但14不是，因为它包含因子7。 
习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */


import java.util.*;
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index<=0){
            return 0;
        }
        ArrayList<Integer> result=new ArrayList<Integer>();
        result.add(1);
        int p2=0;
        int p3=0;
        int p5=0;
        for(int i=1;i<index;i++){
            int lastNumber=result.get(i-1);
			//找到当前数乘2以后的最小值
            while(2*result.get(p2)<=lastNumber){
                p2++;
            }
			//找到当前数乘3以后的最小值
            while(3*result.get(p3)<=lastNumber){
                p3++;
            }
			//找到当前数乘5以后的最小值
            while(5*result.get(p5)<=lastNumber){
                p5++;
            }
			//添加*2，*3，*5中三个整数的最小值
            result.add(Math.min(
                Math.min(result.get(p2)*2,result.get(p3)*3),
                result.get(p5)*5
                ));
        }
        return result.get(index-1);
    }
}