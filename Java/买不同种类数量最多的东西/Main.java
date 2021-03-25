import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    // https://blog.csdn.net/niaonao/article/details/84206451
    // 小朋友买东西，她想买尽可能多的种类，每种只买一件，同时总价格还不能超过预算上限
    // 如果商店里没有小朋友想买的东西，则什么都不买
    
    // input: 12 3 4 12 5 3 5 // 商品种类的价格
    // 5    // 小朋友想买的东西的价格
    // 20   // 总钱数

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
        int totalPrice = 0; //手上所有商品的总价
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