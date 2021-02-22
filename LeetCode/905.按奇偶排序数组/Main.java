import java.util.*;

public class Main {

    // ����һ���Ǹ��������� A������һ�����飬�ڸ������У� A ������ż��Ԫ��֮�������������Ԫ�ء�
    // ���룺[3,1,2,4]
    // �����[2,4,3,1]
    // ��� [4,2,3,1]��[2,4,1,3] �� [4,2,1,3] Ҳ�ᱻ���ܡ�

    public static void main(String[] args) {
        System.out.println(Arrays.toString(unstableSort(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(stableSort(new int[] {1,2,3,4})));
    }

    // unstable
    // time complexity: O(n)
    // space complexity: O(1)
    // ˫ָ���ǰ�����м����
    public static int[] unstableSort(int[] array){
        int n = array.length;
        if (n <= 1) return array;

        int head = 0, tail = n-1;
        while(head < tail){
            if(array[head]%2!=0 && array[tail]%2!=0) tail--;
            else if(array[head]%2==0 && array[tail]%2==0) head++;
            else if(array[head]%2!=0 && array[tail]%2==0){
                int temp = array[head];
                array[head] = array[tail];
                array[tail] = temp;
                head++;
                tail--;
            }
            else{
                head++;
                tail--;
            }
            // System.out.println(head + " " + tail);
        }
        return array;
    }

    // stable
    // time complexity: O(n^2)
    // space complexity: O(1)
    // �������飬�ҵ�ż����swap��swap���Ѿ�sortż�������һλ��k��ż�����һλ��λ��
    public static int[] stableSort(int[] array){
        int n = array.length;
        if (n <= 1) return array;

        int k = 0;  // if even number found, swap to this target index
        for (int i = 0; i < n; i++){
            if(array[i]%2==0){  //even
                int j = i;
                while(k < j){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    j--;
                }
                k++;
            }
        }
        return array;
    }
}