public class Main {

    // һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
    // �����������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
    public static void main(String[] args) {
        int floor = 1;
        System.out.println(jumpFloor(floor));

    }

    // �ݹ�
    public static int jumpFloor(int number) {
        if (number <=1){
            return 1;
        }
        return jumpFloor(number-1) + jumpFloor(number-2);
    }

    public static int jumpFloor2(int number) {
        if (number <= 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        if (number == 2) {
            return 2;
        }
        int first = 1, second = 2, third = 0;
        for (int i = 3; i <= number; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
}