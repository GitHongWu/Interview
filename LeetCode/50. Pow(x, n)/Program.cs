using System;

namespace _50._Pow_x__n_
{
    class Program
    {
        // https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
        // 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）
        // 输入：x = 2.10000, n = 3
        // 输出：9.26100
        static void Main(string[] args)
        {
            double x = 2.1;
            int n = 4;
            System.Console.WriteLine(myPow(x, n));
        }

        // recursive
        // Time: O(log n)
        // Space: O(log n)
        static public double myPow(double x, int n)
        {
            long N = n; // //因为int范围是[-2^31,2^31-1](2147483647到-2147483648), -(-2147483648)负数的表示范围比正数大，所以不能简单取绝对值，用long代替
            if (N < 0)
            {
                x = 1 / x;  // 如果n是负数，x用1/x
                N = -N;
            }
            return _myPow(x, N);
        }

        static public double _myPow(double x, long N){
            
            if (N == 0) {
                return 1.0;
            }
            double y = _myPow(x, N / 2);
            System.Console.WriteLine(y);
            return N % 2 == 0 ? y * y : y * y * x;
        }

        // brute-force
        // time: O(n)
        static public double myPow2(double x, int n)
        {
            long N = n; // //因为int范围是[-2^31,2^31-1](2147483647到-2147483648), -(-2147483648)负数的表示范围比正数大，所以不能简单取绝对值，用long代替
            if (N < 0)
            {
                x = 1 / x;
                N = -N;
            }

            double ans = 1;
            for (int i = 0; i < N; i++)
            {
                ans = ans * x;
            }
            return ans;
        }
    }
}
