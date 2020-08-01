/*
ALL GCD

Given an array of integers A of size N.

Find and return how many distinct gcd( sub(A) ) values are possible, where sub(A) is any non-empty subsequence of arraya A.

NOTE: gcd here refers to greatest common divisor.


Input Format

The first argument given is the integer array A.

Output Format

Return how many distinct gcd( sub(A) ) values are possible, where sub(A) is any subsequence of array A.

Constraints

1 <= N <= 1000
1 <= A[i] <= 1000

For Example

Input 1:
    A = [3, 2, 8]

Output 1:
    4
Explaination 1:
gcd([3]) = 3
gcd([3, 2]) = 1
gcd([3, 8]) = 1
gcd([2]) = 2
gcd([2, 8]) = 2
gcd([8]) = 8
gcd([3, 2, 8]) = 1
There are 4 distinct gcd values (1,2, 3, 8).

Input 2:
    A = [5, 17, 3, 11]
Output 2:
    5

*/

public class Solution {
    public int solve(int[] A) {
        boolean[] arr = new boolean[1001];
        for(int i=0;i<A.length;i++){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(A[i]);
            for(int j=0;j<arr.length;j++){
                if(arr[j]){
                    list.add(gcd(A[i], j));
                }
            }
            
            for(int elem:list){
                arr[elem] = true;
            }
        }
        
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]){
                ans++;
            }
        }
        return ans;
    }
    
    public int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
    
}

