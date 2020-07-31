/*
Count of paths in a grid

Given an integer A, find and return the number of paths in a grid of size (A x A) that starts from (1, 1) and reaches (A, A) without crossing the major diagonal.

Since the result can be large, return the result modulo (10^9 + 7).

NOTE

The major diagonal of a matrix A is the collection of entries A[i][j] where i == j


Input Format

The only argument given is integer A.

Output Format

Return the number of paths modulo (10^9 + 7).

Constraints

1 <= A <= 10^6

For Example

Input 1:
    A = 2
Output 1:
    1

Input 2:
    A = 5
Output 2:
    14

*/


public class Solution {
    public int solve(int A) {
        int mod = 1000000007;
        long totalPath = ncr(2*A-2, A-1, mod);
        long faultPath = ncr(2*A-2, A-2, mod);
        
        return (int)((totalPath-faultPath+mod)%mod);
    }
    
    public long ncr(int n, int r, int p){
        long[] fact = new long[n+1];
        fact[0] = 1;
        for(int i=1;i<=n;i++){
            fact[i] = (i*fact[i-1])%p;
        }
        return (fact[n]*power(fact[n-r], p-2, p)%p)*power(fact[r], p-2, p)%p;
    }
    
    public long power(long a, long b, long p){
        if(b==1){
            return a;
        }
        long temp = power(a, b/2, p);
        temp = (temp*temp)%p;
        if(b%2!=0){
            temp = (temp*a)%p;
        }
        
        return temp;
    }
    
}

