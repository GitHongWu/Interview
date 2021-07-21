import java.util.*;

public class Main {
    // ����һ����n��Ԫ�ص�����S��S���Ƿ���Ԫ��a,b,c����a+b+c=0���ҳ�����S������������������Ԫ��
    // ��Ԫ�飨a��b��c���е�Ԫ�ر��밴�ǽ������С�����a��b��c��
    // �⼯�в��ܰ����ظ�����Ԫ�顣
    // input: {-10 0 10 20 -10 -40}
    // output: (-10, 0, 10) (-10, -10, 20)

    public static void main(String[] args) {
        int target = 0;
        int[] array = new int[]{-10, 0, 10, 20, -10, -40};
        int[] array2 = new int[]{-1,0,1,2,-1,-4};

        sum2tar(array2, target);

        for(ArrayList<Integer> list: threeSum(array2)){
            System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2));
        }
    }

    // �Զ���target����Ԫ��
    // ����˼·���Ȱ�arr�������򣬶�arr���ÿһ��Ԫ��arr[i]����target-arr[i]����õ�second_tar����ʱ������ͱ������
    // ��Ӧsecond_tar�Ķ�Ԫ���ˡ��Ҷ�Ԫ����˫ָ���ͷβ����������ʱȷ����������ǰԪ��arr[i],����hashset��֤�𰸲��ظ�
    public static void sum2tar(int[] arr, int target){
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        HashSet<String> set = new HashSet<>();  // use for remove duplicate
        for(int i = 0; i < arr.length; i++){
            int second_tar = target-arr[i];   // second_tar is the target number minus each int in array
            int left = 0, right = arr.length-1; // declare two pointer, approch to the target number
            while(left < right){
                int sum = arr[right] + arr[left];
                if(sum == second_tar && i!=right && i!=left) {  // i�����ظ�����
                    int result_index[] = new int[]{arr[i], arr[left], arr[right]};  //�����ϵĴ𰸴��벢sort
                    Arrays.sort(result_index);
                    if (!set.contains(Arrays.toString(result_index))){
                        System.out.println("(" + arr[i] + ", " + arr[left] + ", " + arr[right] + ")");
                        set.add(Arrays.toString(result_index)); // store into set
                    }
                    left++;
                    right--;
                }
                else if (sum < second_tar) left++;
                else right--;
            }
        }
    }

    // ��Ϊ0����Ԫ��
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = num.length;
        if(n < 3) return result;
        // ����
        Arrays.sort(num);
        for (int i = 0; i < n-2; i++){
            int left = i+1;
            int right = n-1;
            int target = 0 - num[i];
            if(i!=0 && num[i] == num[i-1]) continue;    //ȥ��
            while(left < right){
                int sum = num[left] + num[right];
                if(sum < target) left++;
                else if(sum > target) right--;
                else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(num[i]);
                    temp.add(num[left]);
                    temp.add(num[right]);
                    result.add(temp);
                    while (left + 1 < right && num[left+1] == num[left]) ++left;  // ��ֹ�ظ�
                    while (right - 1 > left && num[right-1] == num[right]) --right;  // ��ֹ�ظ�
                    ++left; --right;
                }
            }
        }
        return result;
    }
}