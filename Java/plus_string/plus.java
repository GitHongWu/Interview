import java.util.Arrays;

public class plus {
    public static void main(String[] args) {
        String num1 = "1234";
        String num2 = "56789";
        System.out.println(plus1(num1, num2));
        System.out.println(plus2(num1, num2));
    }

    public static String plus1(String numberA, String numberB) {
        int a_length = numberA.length();
        int b_length = numberB.length();
        int result_length = Math.max(a_length, b_length) + 1;
        int[] result = new int[result_length];
        int overTen = 0;

        while (a_length > 0 && b_length > 0) {
            char ca = numberA.charAt(a_length - 1);
            char cb = numberB.charAt(b_length - 1);
            int a = Integer.parseInt(String.valueOf(ca));
            int b = Integer.parseInt(String.valueOf(cb));
            System.out.println(a + " + " + b + " = " + (a + b));

            // if two digit sum over 10
            if (a + b >= 10) {
                overTen = 1;
                result[result_length - 1] = result[result_length - 1] + ((a + b) % 10); // add the last digit
            } else {
                result[result_length - 1] = result[result_length - 1] + a + b;
            }

            if (overTen == 1) {
                result[result_length - 2] = result[result_length - 2] + 1; // add 1 at ahead index
            }

            a_length--;
            b_length--;
            result_length--;
            overTen = 0; // reset over ten
        }

        // TODO: remaining digits

        return Arrays.toString(result);
    }

    public static String plus2(String str1, String str2) {
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
