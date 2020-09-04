/*
Flight Range Bookings

Problem Description

There is a company CorpFly which only takes booking from corporates. They have A flights and they are numbered from 1 to A.

Corporate bookings are of the following form (i, j, K). This implies book K seats each on every flight numbered between i and j (inclusive).

Given a 2-D array B of size M * 3 denoting a sequence of these bookings from corporates, your job is to tell the number of seats booked on each of the A flights.

NOTE: Assume the number of seats in every flight is infinite.



Problem Constraints

1 <= A <= 2 * 105

1 <= i <= j <= A

1 <= M <= 105



Input Format

First argument is an integer A.
Second argument is a 2-D array B of size M * 3.


Output Format

Return an integer array denoting the number of seats booked on each of the A flights.


Example Input

Input 1:

A = 5
B = [ [1, 2, 10],
      [2, 3, 20],
      [2, 5, 25] ]

  

Input 2:

A = 5
B = [ [1, 2, 10],
      [2, 3, 20],
      [2, 5, 25] ]



Example Output

Output 1:

[10, 55, 45, 25, 25]

Output 2:

[10, 55, 45, 25, 25]



Example Explanation

Explanation 1:

 
 First booking books 10 seats on flights 1 to 2(1 and 2). Final bookings in each flight after first booking: [10, 10, 0, 0, 0]
 Second booking books 20 seats on flights 2 to 3(2 and 3). Final bookings in each flight after second booking: [10, 30, 20, 0, 0]
 Third booking books 25 seats on flights 2 to 5(2,3,4,5). Final bookings in each flight after third booking: [10, 55, 45, 25, 25]

Explanation 2:

 
 First booking books 10 seats on flights 1 to 2(1 and 2). Final bookings in each flight after first booking: [10, 10, 0, 0, 0]
 Second booking books 20 seats on flights 2 to 3(2 and 3). Final bookings in each flight after second booking: [10, 30, 20, 0, 0]
 Third booking books 25 seats on flights 2 to 5(2,3,4,5). Final bookings in each flight after third booking: [10, 55, 45, 25, 25]

*/

/*
Solution Approach

Instead of updating each flight booking ranging from i to j, we could just update index i with +S and index j + 1 with -S, where S is number of booking made by some person. So if you want to know number of bookings made at kth flight, you just need to find prefix sum of all the values(coins) from 1 to k(Try to prove it by yourself that values between i to j contains +S as you are doing prefix sum).

Example:
A = 5, B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
Initial array: [0, 0, 0, 0, 0]

    After first booking, if we update i = 1 with +10 and j + 1 = 3 with -10, we get [10, 0, -10, 0, 0]. Now note that if you add 10 to 1st index and subtract 10 with 3rd index and do a prefix sum at every array element, you will get +10 at 1st and 2nd.
    After second booking, if we update i = 2 with +20 and j + 1 = 4 with -20, we get [10, 20, -10, -20, 0].
    Similarly, after third booking, if we update i = 2 with +25 and j + 1 = 6 with -25, we get [10, 45, -10, -20, 0].

Now if we calculate the prefix sum at every index, we get [10, 55, 45, 25, 25].
*/

public class Solution {
    public int[] solve(int A, int[][] B) {
        int[] arr = new int[A];
        for(int i=0;i<B.length;i++){
            arr[B[i][0]-1] += B[i][2];
            if(B[i][1]<arr.length)
                arr[B[i][1]] -= B[i][2];
        }
        for(int i=1;i<arr.length;i++){
            arr[i] += arr[i-1];
        }
        
        return arr;
    }
}

