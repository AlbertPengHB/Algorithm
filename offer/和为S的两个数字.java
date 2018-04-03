/* 
输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */


//采用头尾夹逼，找到的第一组符合条件的一定是乘积最小的
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(array==null||array.length<=0){
            return result;
        }
        int low=0;
        int length=array.length-1;
        int high=length;
        while(high>low&&high<=length&&low>=0){
            if(array[high]+array[low]>sum){
                high--;
            }
            else if(array[high]+array[low]<sum){
                low++;
            }
            else if(array[high]+array[low]==sum){
                result.add(array[low]);
                result.add(array[high]);
                break;
            }
        }
        return result;
    }
}