/*
Ath Magical Number

Problem Description

Given three positive integers A, B and C.

Any positive integer is magical if it is divisible by either B or C.

Return the Ath magical number. Since the answer may be very large, return it modulo 109 + 7.



Problem Constraints

1 <= A <= 109

2 <= B, C <= 40000



Input Format

The first argument given is an integer A.

The second argument given is an integer B.

The third argument given is an integer C.



Output Format

Return the Ath magical number. Since the answer may be very large, return it modulo 109 + 7.


Example Input

Input 1:

 A = 1
 B = 2
 C = 3

Input 2:

 A = 4
 B = 2
 C = 3



Example Output

Output 1:

 2

Output 2:

 6



Example Explanation

Explanation 1:

 1st magical number is 2.

Explanation 2:

 First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.

*/

/*
Solution Approach

Say L = lcm(B,C), the least common multiple of B and C and let f(x) be the number of magical numbers less than or equal to x.
A well known result says that L = (B*C)/gcd(B,C), and that we can calculate the function gcd.

Then f(x) = x/B + x/C - x/L (floor of all the divisions)

Why? There are x/B numbers B,2B,3B… thaare divisible by B, there are x/C numbers divisible by C and we need to subtract the x/L numbers divisible by B and C that we double counted.

Finally,the answer must be between 0 and A * max(B,C).

If x increase f(x) increases so we can use binary search on x to find the Ath number.

Algorithm:
1) Low=1 and High = A * max(B,C)
2) Find mid = (low+high)/2
3) Find f(mid) let it be count
4) If count>=A then mark it as a answer and try to find smaller number which implies high=mid-1
5) Else low=mid+1
6) Repeat steps 2 to 5 until low<=high

Time Complexity: O(log (A *max( B, C)))
Space Complexity: O(1).
*/

public class Solution {
    public int solve(int N, int A, int B) {
        long a = A, b = B, tmp, l = 2, r = (long)1e14, mod = (long)1e9 + 7;
        
        // GCD
        while (b > 0) {
            tmp = a;
            a = b;
            b = tmp % b;
        }
        
        // binary search
        while (l < r) {
            long m = (l + r) / 2;
            if (m / A + m / B - m / (A * B / a) < N) l = m + 1;
            else r = m;
        }
        
        return (int)(l %mod);
    }
    
}

