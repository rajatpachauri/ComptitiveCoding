/*
Size three subsequences divisible by B

Given an array of integers A and an integer B. Find and return the number of subsequences of length 3 whose sum is divisible by B.

Since the total number of subsequences may be very large.

Return the total number of subsequences of length 3 whose sum is divisible by B modulo (109+7).


Input Format

The only argument given is the integer array A.

Output Format

Return the number of subsequences of length 3 whose sum is divisible by B modulo (10^9+7). 

Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 10^9 
1 <= B <= 10^3

For Example

Input 1:
    A = [6, 1, 1, 4, 1, 5, 3]
    B = 2
Output 1:
    20

Input 2:
    A = [4, 10, 9]
    B = 5
Output 2:
    0

*/

/*
olution Approach

Three cases may occur:

1.Thrice of a number is divisible by B then we will add ncr(N,3) to answer where N is frequency of that number.

2.Twice of some number A added with sum number B is divisible by B
then we will add ncr(Freq[A],2) * Freq[B] to the answer.

3.If all the number A, B, C(A,B,C are pairwise disticnt)
that sum up to S which is divisible by B then we will add Freq[A] * Freq[B] * Freq[C] to the answer.

Time Complexity : O(B^2)

*/

public class Solution {
    
    public int solve(int[] A, int k) {
        int[] modValues = new int[k];
        for(int i=0;i<A.length;i++){
            int rem = A[i]%k;
            modValues[rem]++;
        }
        int mod = (int) (1e9 + 7);
        long ans = 0;
        for (int i = 0; i < modValues.length; i++) {
            for (int j = i; j < modValues.length; j++) {
                int rem = (k - (i + j) % k)%k;
                if (rem < j) continue;
                if (i == j && rem == j) {
                    ans = ans + (modValues[i] * (modValues[i] - 1) * (modValues[i] - 2)) / 6;
                    ans = ans % mod;
                } else if (i == j) {
                    ans = ans + ((modValues[i] * (modValues[i] - 1)) * modValues[rem]) / 2;
                    ans = ans % mod;
                } else if (i == rem) {
                    ans = ans + ((modValues[i] * (modValues[i] - 1)) * modValues[j]) / 2;
                    ans = ans % mod;
                } else if (j == rem) {
                    ans = ans + ((modValues[j] * (modValues[j] - 1)) * modValues[i]) / 2;
                    ans = ans % mod;
                } else {
                    ans = ans + (modValues[i] * modValues[j] * modValues[rem]);
                    ans = ans % mod;
                }
            }
    
        }
        return (int) ans;
    }
}

