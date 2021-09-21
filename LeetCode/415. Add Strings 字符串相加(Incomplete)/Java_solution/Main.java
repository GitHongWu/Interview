import java.util.*;

public class Main {

    public static void main(String[] args) {
        String s1 = "999928";
        String s2 = "72";
        System.out.println(bigNumberAdd(s1, s2));
		System.out.println(bigNumberAdd2(s1, s2));
    }

	//解题思路：所有位数相加，短的数在前面补0，继续相加
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

	//解题思路：确保str2是长的，用stringBuilder reverse两个string，按位数相加，
	//加完短的string后，把剩下的长string复制过来
	public static String bigNumberAdd2(String str1, String str2) {
        // Before proceeding further, make sure length
        // of str2 is larger.
        if (str1.length() > str2.length()) {
            String t = str1;
            str1 = str2;
            str2 = t;
        }

        // Take an empty String for storing result
        String str = "";

        // Calculate length of both String
        int n1 = str1.length(), n2 = str2.length();

        // Reverse both of Strings
        str1 = new StringBuilder(str1).reverse().toString();
        str2 = new StringBuilder(str2).reverse().toString();

        int carry = 0;
        for (int i = 0; i < n1; i++) {
            // Do school mathematics, compute sum of
            // current digits and carry
            int sum = ((int) (str1.charAt(i) - '0') + (int) (str2.charAt(i) - '0') + carry);
            str += (char) (sum % 10 + '0');

            // Calculate carry for next step
            carry = sum / 10;
        }

        // Add remaining digits of larger number
        for (int i = n1; i < n2; i++) {
            int sum = ((int) (str2.charAt(i) - '0') + carry);
            str += (char) (sum % 10 + '0');
            carry = sum / 10;
        }

        // Add remaining carry
        if (carry > 0)
            str += (char) (carry + '0');

        // reverse resultant String
        str = new StringBuilder(str).reverse().toString();

        return str;
    }
}