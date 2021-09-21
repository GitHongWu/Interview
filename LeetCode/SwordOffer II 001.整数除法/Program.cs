using System;
using System.Diagnostics.PerformanceData;

namespace SwordOffer_II_001
{
    class Program
    {
        static void Main(string[] args)
        {
            // https://leetcode-cn.com/problems/xoh6Oh/
            int a = 22;
            int b = 3;
            System.Console.WriteLine(divide(a, b));
        }

        static int divide(int a, int b)
        {
            System.Console.WriteLine(a + " " + b);
            int ret = 0;
            int tmp_b = b;
            if (a >= tmp_b)
            {
                ret = 1;
                tmp_b += tmp_b;
            }
            else{
                return ret;
            }
            while (a >= tmp_b)
            {
                ret += ret;
                tmp_b += tmp_b;
            }
            
            System.Console.WriteLine(a + " " + tmp_b);
            a = a - (tmp_b/2);
            ret += divide(a, b);
            return ret;
        }
    }
}
