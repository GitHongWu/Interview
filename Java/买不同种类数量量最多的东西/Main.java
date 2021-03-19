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
        // Scanner in = new Scanner(System.in);
        // ArrayList<Integer> array = new ArrayList<>();
        
        // while (in.hasNextInt()) {
        //     array.add(in.nextInt());
        // }
        // System.out.println(buy(array));

        int goodsPrices[] = new int[]{12, 3, 4, 12, 5, 3, 5};
        int budget = 20;
        // System.out.println(buy(goodsPrices, budget));
        buy(goodsPrices, budget);
    }
    
    public static void buy(int goodsPrices[], int budget) {
        int totalPrice = 0; //����������Ʒ���ܼ�
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(goodsPrices);

        for(int i = 0; i < goodsPrices.length; i++){
            if (totalPrice + goodsPrices[i] <= budget) {
                totalPrice += goodsPrices[i];
                result.add(goodsPrices[i]);
            }
        }
        System.out.println("Total Price: " + totalPrice);
        System.out.println(result);
    }
}