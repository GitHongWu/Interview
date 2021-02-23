import java.util.*;

public class Main {

    public static void main(String[] args) {
        String s1 = "999928";
        String s2 = "72";
        System.out.println(bigNumberAdd(s1, s2));
    }

    public static String bigNumberAdd(String s1, String s2) {
		
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		int i = a1.length - 1, j = a2.length - 1;
		int m = 0; //当前位上要相加的数
		int carry = 0; //进位
		int num1 = 0, num2 = 0;
		StringBuffer s = new StringBuffer();
		while (i >= 0 || j >= 0) {
			if (i >= 0) {
				num1 = a1[i] - '0'; // convert char to int
			} else {
				num1 = 0;
			}
			if (j >= 0) {
				num2 = a2[j] - '0';
			} else {
				num2 = 0;
			}
			
			int sum = num1 + num2 + carry;
			m = sum % 10;
			carry = sum / 10;
            char c = (char)(m + '0');   // convert int to char
			s.append(c);
			i--;
			j--;
		}
		if (carry != 0) {
			s.append('1');
		}
		
		s.reverse();
		return s.toString();
	}
}