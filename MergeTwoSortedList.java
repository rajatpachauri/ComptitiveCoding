/*
Merge Two Sorted Lists

Problem Description

Merge two sorted linked lists A and B and return it as a new list.

The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.



Problem Constraints

0 <= |A|, |B| <= 105


Input Format

The first argument of input contains a pointer to the head of linked list A.

The second argument of input contains a pointer to the head of linked list B.



Output Format

Return a pointer to the head of the merged linked list.


Example Input

Input 1:

 A = 5 -> 8 -> 20
 B = 4 -> 11 -> 15

Input 2:

 A = 1 -> 2 -> 3
 B = Null



Example Output

Output 1:

 4 -> 5 -> 8 -> 11 -> 15 -> 20

Output 2:

 1 -> 2 -> 3



Example Explanation

Explanation 1:

 Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20 

Explanation 2:

 We don't need to merge as B is empty. 
*/

/*
Solution Approach

First thing to note is that all you would want to do is modify the next pointers. You don’t need to create new nodes.

At every step, you choose the minumum of the current head X on the 2 lists, and modify your answer’s next pointer to X. You move the current pointer on the said list and the current answer.

Corner case,
Make sure that at the end of the loop, when one of the list goes empty, you do include remaining elemnts from the second list into your answer.

Test case : 1->2->3 4->5->6

*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(l1!=null || l2!=null){
            if(l2==null || (l1!=null && l1.val<l2.val)){
                temp.next = l1;
                l1 = l1.next;
            }
            else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        return head.next;
    }
}

