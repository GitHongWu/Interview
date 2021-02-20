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