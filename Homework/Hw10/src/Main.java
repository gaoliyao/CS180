import java.util.Scanner;

public class Main {
//    /**
//     * Definition for singly-linked list.
//     * public class ListNode {
//     *     int val;
//     *     ListNode next;
//     *     ListNode(int x) { val = x; }
//     * }
//     */
//    public class ListNode {
//          int val;
//          ListNode next;
//          ListNode(int x) { val = x; }
//      }
//    class Solution {
//        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//            int[] nums = new int[100];
//            for (int i=0;i<100;i++){
//                nums[i] = -1;
//            }
//            int count = 0;
//            if (l1.next != null){
//                int num = l1.next.val + l2.next.val;
//                if (num < 10){
//                    if (nums[count] != null)
//                        nums[count] = nums[count] + num;
//                    else
//                        nums[count] = num;
//                }
//                else{
//                    if (nums[count] != null){
//                        nums[count] = nums[count] + num - 10;
//                        nums[count+1] = 1;
//                    }
//                    else{
//                        nums[count] = nums[count] + num - 10;
//                        nums[count+1] = 1;
//                    }
//                }
//                count++;
//            }
//            ListNode node = new ListNode(num[0]);
//            for (int i=1;i < nums.length;i++){
//                if (nums[i] != -1){
//                    node.next = new ListNode(num[i]);
//                    node = node.next;
//                }
//            }
//            return node;
//        }
//    }

}