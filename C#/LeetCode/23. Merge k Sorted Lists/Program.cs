using System;
using System.Text;
using System.Collections.Generic;

namespace _23._Merge_k_Sorted_Lists
{
    class Program
    {
        static void Main(string[] args)
        {
            // Input: lists = [[1,4,5],[1,3,4],[2,6]]
            // Output: [1,1,2,3,4,4,5,6]
            // Explanation: The linked-lists are:
            // [
            // 1->4->5,
            // 1->3->4,
            // 2->6
            // ]
            // merging them into one sorted list:
            // 1->1->2->3->4->4->5->6
        }

        // Solution
        // Compare each head at time then store into result
        public ListNode MergeKLists(ListNode[] lists)
        {
            int min_index = 0;
            ListNode head = new ListNode(0);
            ListNode current = head;
            while (true)
            {
                bool allNull = true;
                int min = int.MaxValue;
                for (int i = 0; i < lists.Length; i++)  // if all linkedlist reached to the end, allNull is true
                {
                    if (lists[i] != null)
                    {
                        if (lists[i].val < min)
                        {
                            min_index = i;
                            min = lists[i].val;
                        }
                        allNull = false;
                    }

                }
                if (allNull)
                {
                    break;
                }
                current.next = lists[min_index];
                current = current.next;
                lists[min_index] = lists[min_index].next;
            }
            current.next = null;
            return head.next;
        }

    }

    public class ListNode
    {
        public int val;
        public ListNode next;
        public ListNode(int val = 0, ListNode next = null)
        {
            this.val = val;
            this.next = next;
        }
    }
}
