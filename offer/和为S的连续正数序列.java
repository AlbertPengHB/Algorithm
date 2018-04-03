/* 
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */



/*
*初始化small=1，big=2;
*small到big序列和小于sum，big++;大于sum，small++;
*当small增加到(1+sum)/2是停止
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       ArrayList<ArrayList<Integer>> lists=new ArrayList<ArrayList<Integer>>();
       if(sum<2){
           return lists;
       }
       int small=1;
       int big=2;
       while(small!=(1+sum)/2&&big>small){
           int curSum=sumOfList(small,big);
           if(curSum==sum){
               ArrayList<Integer> list=new ArrayList<Integer>();
               for(int i=small;i<=big;i++){
                   list.add(i);
               }
               lists.add(list);
			   //当找到满足条件的list后，需要将small往后移动一位重新计算一次
               small++;
           }
           else if(curSum<sum){
               big++;
           }
           else if(curSum>sum){
               small++;
           }
       }
       return lists;
    }
    
    private int sumOfList(int small,int big){
        int curSum=0;
        for(int i=small;i<=big;i++){
            curSum+=i;
        }
        return curSum;
    }
}