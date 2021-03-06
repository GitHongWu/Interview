import java.util.Arrays;
// import java.util.String;

public class Main {

    // ��һ������a��������n�����������������С�����һ��������
    // ��a��������������ӵ���N��������Щ�������������磬����Ϊ{1,3,44,2,4,5,54,222,368} N=6,������Ϊ{1,5}��{2,4}
    // û����return -1����return 0 ��print���з��ϵ�ֵ

    //����˼·��sort���飬˫ָ���ͷβ����

    public static void main(String[] args) {
        int[] array = new int[] {1,3,44,2,1,4,5,54,5,222,368};
        System.out.println(Arrays.toString(array));
        myFun2(array, 6);
    }

    // slow O(n^2)
    public static void myFun(int[] a, int target){
        int n = a.length;
        if(n < 2){
            return;
        }

        int[] diffArray = new int[n];
        for (int i = 0; i < n; i++){
            diffArray[i] = target - a[i];
        }
        System.out.println(Arrays.toString(diffArray));

        for(int i = 0; i < n; i++){
            // Arrays.asList(diffArray).indexOf(a[i]);
            int index = -1;
            for(int j = i+1; j < n; j++){
                if(a[i] == diffArray[j] && i != j){
                    index = j;
                    break;
                }
            }

            if(index != -1){
                System.out.println(a[i] + " " + a[index]);
            }
        }
        return;
    }

    // fast O(NlgN) sort + O(N) compare
    public static void myFun2(int[] a, int target){
        int n = a.length;
        if(n < 2){
            return;
        }

        Arrays.sort(a);
        System.out.println("Sort: " + Arrays.toString(a));

        int max_index = n-1;
        for (int i = 0; i < n; i++){
            if(max_index <= i) return;

            if(a[i] + a[max_index] > target){
                i--;
                max_index--;
            }
            else if(a[i] + a[max_index] == target){
                System.out.println(a[i] + " " + a[max_index]);
                max_index--;
            }
            // else if a[i] + a[max_index] < target
            // do nothing, let i++

        }
        return;
    }

}