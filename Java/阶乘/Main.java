import java.util.*;

public class Main {
    // �׳�����Եݹ鷽ʽ���壺0!=1��n!=(n-1)!��n
    public static void main(String[] args) {
        System.out.println(fact(5));
    }

    public static long fact(int n) {
        if(n <= 1) {
            return 1;
        }
        else {
            return n*fact(n-1);
        }
    }
}