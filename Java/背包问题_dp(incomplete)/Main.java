import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    // https://blog.csdn.net/niaonao/article/details/84206451
    // С���������������򾡿��ܶ�����࣬ÿ��ֻ��һ����ͬʱ�ܼ۸񻹲��ܳ���Ԥ������
    // ����̵���û��С��������Ķ�������ʲô������
    
    // input: 12 3 4 12 5 3 5 // ��Ʒ����ļ۸�
    // 5    // С��������Ķ����ļ۸�
    // 20   // ��Ǯ��

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();
        
        while (in.hasNextInt()) {
            array.add(in.nextInt());
        }
        System.out.println(buy(array));
    }
    
    public static int buy(ArrayList<Integer> a) {
        int total = a.get(a.size() - 1);
        int like = a.get(a.size() - 2);
        a.remove(a.size() - 1);
        a.remove(a.size() - 2);

        if (a.indexOf(like) <= 0) {
            return 0;
        }
        a.remove(a.indexOf(like));
        total -= like;

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(total);
        System.out.println(result.size());
        result.add(temp);
        
        for (int i = 0; i < a.size(); i++) {
            int temp_total = result.get(i + 1).get(1);
            if (temp_total >= a.get(i)) {
                ArrayList<Integer> temp2 = new ArrayList<>();
                temp2.add(i + 1);
                temp2.add(temp_total - a.get(i));
                result.add(temp2);
            }
        }

        // System.out.println(Arrays.toString(result));
        return result.get(result.size()-1).get(0);
    }
}