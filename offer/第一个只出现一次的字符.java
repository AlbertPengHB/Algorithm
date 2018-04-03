/* 
在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */


import java.util.*;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str==null){
            return -1;
        }
		//采用哈希表存储字符和出现的次数
        LinkedHashMap<Character,Integer> map=new LinkedHashMap<Character,Integer>();
        //遍历一遍字符串，统计出现的次数
		for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int time=map.get(str.charAt(i));
                map.put(str.charAt(i),++time);
            }
            else{
                map.put(str.charAt(i),1);
            }
        }
		//遍历一遍字符串，找出出现一次的字符
        for(int i=0;i<str.length();i++){
            if(map.get(str.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}