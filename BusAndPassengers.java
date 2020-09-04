/*
Bus and Passenger

There is bus having N rows, each row consist of two seats of equal size. Given an array A where A[i] determines the width of seats in the ith row.

There are 2*N passengers of type 0 and type 1 (exactly N passengers of type 0 and exactly N passengers of type 1).

Type 0 : Type 0 passenger always chooses a row where both seats are empty. Among these rows, he chooses the one with the smallest seat width and takes one of the seats in it.

Type 1 : Type 1 always chooses a row where exactly one seat is occupied (by a type 0 passenger). Among these rows, he chooses the one with the largest seat width and takes the vacant place in it.

You are given a string B determining the order the passenger entering the bus where B[i] is either '0' (type 0 passenger) or '1' (type 1 passenger).

Return an array of intergers C, where C[i] determines row taken by ith passenger.


Input Format

The argument given is the integer array A and string B.

Output Format

Return an array of integers C, where C[i] determines row taken by passenger i.

Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 10^5
length of string = 2 * length of array
B[i] is either '0' or '1'.
All array elements are distinct.

For Example

Input 1:
    A = [3, 1]
    B = "0011"
Output 1:
    C= [2, 1, 1, 2]

Input 2:
    A = [10, 8, 9, 11, 13, 5]
    B = "010010011101"
Output 2:
    C= [6, 6, 2, 3, 3, 1, 4, 4, 1, 2, 5, 5]


*/

/*
Hint 1

Note that the final type 0 passenger-type 1 passenger pairs are uniquely determined, and that using the stack, it is possible to recover which type 1 passenger to which type 0 passenger will sit (note that the zeros and ones will form the correct bracket sequence). Then one of the solutions may be as follows:

1.Sort the array of the lengths of the rows in ascending order.
2.For each introvert write the number of the next free row and add it to the stack.
3.For each extrovert write the last number from the stack and remove it from there.

Time Complexity - nlogn
*/

public class Solution {
    
    class pair implements Comparable<pair>{
        int index;
        int val;
        pair(int index, int val){
            this.index = index;
            this.val = val;
        }
        
        public int compareTo(pair p){
            if(this.val==p.val){
                return this.index-p.index;
            }
            return this.val-p.val;
        }
        
    }
    
    public int[] solve(int[] A, String B) {
        pair[] parr = new pair[A.length];
        for(int i=0;i<A.length;i++){
            parr[i] = new pair(i+1, A[i]);
        }
        Arrays.sort(parr);
        int[] ans = new int[B.length()];
        Stack<Integer> stack = new Stack<>();
        for(int i=0, j=0;j<B.length();j++){
            if(B.charAt(j)=='0'){
                stack.push(parr[i].index);
                ans[j] = parr[i++].index;
            }
            else{
                ans[j] = stack.pop();
            }
        }
        
        return ans;
    }
}

