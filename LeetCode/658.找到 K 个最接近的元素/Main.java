import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // 给定一个排序好的数组?arr ，两个整数 k 和 x ，从数组中找到最靠
    // 近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
    // 整数 a 比整数 b 更接近 x 需要满足：
    // |a - x| < |b - x| 或者
    // |a - x| == |b - x| 且 a < b

    // 示例 1：
    // 输入：arr = [1,2,3,4,5], k = 4, x = 3
    // 输出：[1,2,3,4]

    // 示例 2：
    // 输入：arr = [1,2,3,4,5], k = 4, x = -1
    // 输出：[1,2,3,4]

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(findClosestElements(arr,4,3));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        // put array into list
        List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
        // sort by its absolute value
        Collections.sort(ret, (a,b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
        // 取从0到k个数
        ret = ret.subList(0, k);
        // 取决于结果是否要sort
        Collections.sort(ret);
        return ret;
    }
}



