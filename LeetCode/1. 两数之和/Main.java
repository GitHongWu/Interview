import java.util.*;

public class Main {

    // ����һ���������飬�����������ҳ���������������Ŀ��ֵ������
    // ������ĺ���twoSum ��Ҫ�������������ֵ��±꣨index1��index2������Ҫ���� index1 С��index2.��ע�⣺�±��Ǵ�1��ʼ��
    // ���������������ֻ����Ψһ��
    // ���磺
    // ����������Ϊ {20, 70, 110, 150},Ŀ��ֵΪ90
    // ��� index1=1, index2=2
    // {2,7,5,5}10Ӧ��output[3,4]����[3,3]

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