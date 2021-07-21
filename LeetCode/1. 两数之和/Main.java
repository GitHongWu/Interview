import java.util.*;

public class Main {

    // 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
    // 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
    // 假设给出的数组中只存在唯一解
    // 例如：
    // 给出的数组为 {20, 70, 110, 150},目标值为90
    // 输出 index1=1, index2=2
    // {2,7,5,5}10应该output[3,4]不是[3,3]

    public static void main(String[] args) {
        int[] arr1 = new int[]{2,7,5,5};    //[]
        System.out.println(Arrays.toString(fun(arr1, 10)));
        int[] arr2 = new int[]{3,2,4};  //[2,3]
        System.out.println(Arrays.toString(fun(arr2, 6)));
    }

    public static int[] fun(int[] arr, int tar){
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++){
            map.put(arr[i], i);
        }
        for(int j = 0; j < n; j++){
            if(map.get(tar-arr[j])!=null && j != map.get(tar-arr[j])){
                return new int[]{j+1, map.get(tar-arr[j])+1};
            }
        }
        return null;
    }
}