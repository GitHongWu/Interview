using System;

namespace NestedArray
{
    class Program
    {
        static void Main(string[] args)
        {
            // 2d array
            long[,] arr = new long[5, 4] { { 1, 2, 3, 4 }, { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 4, 4, 4, 4 } };
            for (int i = 0; i < arr.GetLength(0); i++)
            {
                for (int j = 0; j < arr.GetLength(1); j++)
                {
                    Console.Write(string.Format("{0} ", arr[i, j]));
                }
                Console.WriteLine();
            }


            // Three-dimensional array.
            int[,, ] intarray3D = new int[,, ] { { { 1, 2, 3 }, 
                                                { 4, 5, 6 } },
                                                { { 7, 8, 9 }, 
                                            { 10, 11, 12 } } };
            }

            int[][] jagged_arr = new int[4][];
    }
}
