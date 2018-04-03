/* 
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */


import java.util.*;

//两步反转法，先反转整个字符串，再根据空格反转各单词即可
public class Solution {
    public String ReverseSentence(String str) {
        if(str==null||str.trim().equals("")){
            return str;
        }
		//将字符串转化成数组方便反转
        char[] chars=str.toCharArray();
        reverse(chars,0,chars.length-1);
		//记住之前一个空格位置
        int blank=-1;
        for(int i=0;i<chars.length;i++){
            if(chars[i]==' '){
				//记住当前空格位置
                int nextblank=i;
				//记住两个空格间的位置即为需要反转的单词
                reverse(chars,blank+1,nextblank-1);
                blank=nextblank;
            }
        }
        reverse(chars,blank+1,chars.length-1);
		//返回的时候布恩那个直接toString会报错，应该将其用一个新生成的字符串对象进行接收
        return new String(chars);
    }
    
    private void reverse(char[] chars,int low,int high){
        while(high>low){
            char temp=chars[low];
            chars[low]=chars[high];
            chars[high]=temp;
            low++;
            high--;
        }
    }
}