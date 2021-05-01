import java.util.*;

public class Main {

    public static void main(String[] args) {
        // https://www.nowcoder.com/practice/c3120c1c1bc44ad986259c0cf0f0b80e?tpId=188&tqId=38352&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey

        String s = "asd qwe";
        System.out.println(flipString(s));  // 翻转每个字符，hello -> OLLEH
        System.out.println(trans(s));   // 翻转string by space, hello world -> WORLD HELLO
    }
    
    public static String flipString(String s){
        System.out.println("orginal string: " + s);
        String reverse = new StringBuffer(s).reverse().toString(); // 翻转整个字符串
        char[] chars = reverse.toCharArray();   // String to char array

        // 大小写翻转
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if (Character.isUpperCase(c))
            {
                chars[i] = Character.toLowerCase(c);
            }
            else if (Character.isLowerCase(c))
            {
                chars[i] = Character.toUpperCase(c);
            }
        }
        return new String(chars);
    }

    // 只需要一个stringBuffer
    // 需要在每个空格处记录下上一个单词的长度,然后从上一个单词长度后继续添加字符
    public static String trans(String s) {
        System.out.println("orginal string: " + s);

        int n = s.length();
        StringBuffer str = new StringBuffer();
        int start=0;
        for (int i = n-1; i >= 0; i--) {
            if(s.charAt(i)==' '){
                str.append(" ");
                start=n-i;
            }else {
                // 大小写翻转
                char sss = (char) (s.charAt(i) < 97 ? s.charAt(i) + 32 : s.charAt(i) - 32);
                str.insert(start, sss);
            }
        }
        return str.toString();
    }
    
}