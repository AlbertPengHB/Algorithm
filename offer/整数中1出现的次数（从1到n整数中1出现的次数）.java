/* 
求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */


//暴力破解法最简单
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<1){
            return 0;
        }
        int count=0;
        while(n>0){
            String str=String.valueOf(n);
            char[] ch=str.toCharArray();
            for(int i=0;i<ch.length;i++){
                if(ch[i]=='1'){
                    count++;
                }
            }
            n--;
        }
        return count;
    }
}