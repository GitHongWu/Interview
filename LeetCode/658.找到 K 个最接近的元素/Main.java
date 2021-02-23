import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // ����һ������õ�����?arr ���������� k �� x �����������ҵ��
    // �� x������֮����С���� k ���������صĽ������Ҫ�ǰ������źõġ�
    // ���� a ������ b ���ӽ� x ��Ҫ���㣺
    // |a - x| < |b - x| ����
    // |a - x| == |b - x| �� a < b

    // ʾ�� 1��
    // ���룺arr = [1,2,3,4,5], k = 4, x = 3
    // �����[1,2,3,4]

    // ʾ�� 2��
    // ���룺arr = [1,2,3,4,5], k = 4, x = -1
    // �����[1,2,3,4]

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(findClosestElements(arr,4,3));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        // put array into list
        List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
        // sort by its absolute value
        Collections.sort(ret, (a,b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
        // ȡ��0��k����
        ret = ret.subList(0, k);
        // ȡ���ڽ���Ƿ�Ҫsort
        Collections.sort(ret);
        return ret;
    }
}



