import java.util.*;

public class Main {
    // 阶乘亦可以递归方式定义：0!=1，n!=(n-1)!×n
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