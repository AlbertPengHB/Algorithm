/* 
把字符串转换成整数
 */


//Solution1考虑各种情况进行转化成字符数组，复杂
public class Solution {
    public int StrToInt(String str) {
        if(str==null||str.length()<=0){
            return 0;
        }
        int length=str.length();
        char first=str.charAt(0);
        char[] result;
        if(first=='+'||first=='-'||(first>='0'&&first<='9')){
            if(first>='0'&&first<='9'){
                result=new char[length];
                for(int i=0;i<length;i++){
                    if(str.charAt(i)>'9'||str.charAt(i)<'0'){
                        return 0;
                    }
                    else{
                        result[i]=str.charAt(i);
                    }
                }
            }
            else{
                result=new char[length-1];
                for(int i=1;i<length;i++){
                    if(str.charAt(i)>'9'||str.charAt(i)<'0'){
                        return 0;
                    }
                    else{
                        result[i-1]=str.charAt(i);
                    }
                }
            }
           
        }
        else{
            return 0;
        }
        int time=1;
        int sum=0;
        int resultlength=result.length-1;
        while(resultlength>=0){
            sum+=(result[resultlength]-'0')*time;
            time*=10;
            resultlength--;
        }
		//如果第一字符是'-'的话，需要将其转化成负数
        if(str.charAt(0)=='-'){
            sum=0-sum;
        }
        return sum;
    }
}

//Solution2方法不好，没有考虑中间有加号的情况
public class Solution {
    public int StrToInt(String str) {
        if(str==null||str==" "||str.length()<=0){
            return 0;
        }
        char[] chars=str.toCharArray();
        int fuhao=0;
        if(chars[0]=='-'){
            fuhao=1;
        }
        int sum=0;
        for(int i=fuhao;i<chars.length;i++){
            if(chars[i]=='+'){
                continue;
            }
            if(chars[i]>'9'||chars[i]<'0'){
                return 0;
            }
            sum=sum*10+(chars[i]-'0');
        }
        return fuhao == 0 ? sum : sum * -1;
    }
}