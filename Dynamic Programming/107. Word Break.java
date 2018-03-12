

//Solution1方法时间复杂度为O(n^3)，超时不好
public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if(s==null||s.length==0){
            return false;
        }
        int length=s.length();
		//cut数组表示前i个字符能否被完美切分
        boolean[] cut=new boolean[length+1];
        //空字符串也在dict中
		cut[0]=true;
        for(int i=1;i<=length;i++){
            for(int j=0;j<i;j++){
				//substring函数表示取从j到i的子字符串（下标从0开始）
                String word=s.substring(j,i);
				//contains函数表示word是否在字典中
				//判定cut[j]和从j到i的两部分是不是都可被切分
                cut[i]=cut[i]||cut[j]&&dict.contains(word);
            }
        }
        return cut[length];
    }
}


//Solution2时间复杂度为O(nL^2),n为字符串长度，L为最大单词长度
public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
     
	//求字典中单词的最大长度
    private int getMaxLength(Set<String> dict){
        int maxLength=0;
        for(String word:dict){
            maxLength=Math.max(maxLength,word.length());
        }
        return maxLength;
    }
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if(s==null||s.length()==0){
            return true;
        }
        int maxLength=getMaxLength(dict);
        boolean[] can=new boolean[s.length()+1];
        can[0]=true;
        for(int i=1;i<=s.length();i++){
            can[i]=false;
			//从后往前进行切分，判断最后一个可切分单词的位置
            for(int lastWordLength=1;lastWordLength<=i&&lastWordLength<=maxLength;lastWordLength++){
                if(!can[i-lastWordLength]){
                    continue;
                }
                String word=s.substring(i-lastWordLength,i);
                if(dict.contains(word)){
                    can[i]=true;
                    break;
                }
            }
        }
        return can[s.length()];
    }
}