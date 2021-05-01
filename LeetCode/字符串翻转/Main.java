import java.util.*;

public class Main {

    public static void main(String[] args) {
        // https://www.nowcoder.com/practice/c3120c1c1bc44ad986259c0cf0f0b80e?tpId=188&tqId=38352&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey

        String s = "asd qwe";
        System.out.println(flipString(s));  // ��תÿ���ַ���hello -> OLLEH
        System.out.println(trans(s));   // ��תstring by space, hello world -> WORLD HELLO
    }
    
    public static String flipString(String s){
        System.out.println("orginal string: " + s);
        String reverse = new StringBuffer(s).reverse().toString(); // ��ת�����ַ���
        char[] chars = reverse.toCharArray();   // String to char array

        // ��Сд��ת
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

    // ֻ��Ҫһ��stringBuffer
    // ��Ҫ��ÿ���ո񴦼�¼����һ�����ʵĳ���,Ȼ�����һ�����ʳ��Ⱥ��������ַ�
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
                // ��Сд��ת
                char sss = (char) (s.charAt(i) < 97 ? s.charAt(i) + 32 : s.charAt(i) - 32);
                str.insert(start, sss);
            }
        }
        return str.toString();
    }
    
}