import java.util.*;

public class Main {

    public static void main(String[] args) {
        // input: 1234
        // output: 4321

        // input: -123
        // output: -321

    }

    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int t = x % 10; // ����x=123, ��t=3
            int newRes = res * 10 + t;  //��t�ӵ�res��ĩβ
            //������������ֱ�ӷ���0
            if ((newRes - t) / 10 != res)
                return 0;
            res = newRes;
            x = x / 10;
        }
        return res;
    }
}