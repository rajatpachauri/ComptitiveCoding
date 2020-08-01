/*

ALL GCD PAIR

Problem Description

Given an array of integers A of size N containing GCD of every possible pair of elements of another array.

Find and return the original numbers which are used to calculate the GCD array in any order. For example, if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.



Problem Constraints

1 <= N <= 10000

1 <= A[i] <= 109



Input Format

The first and only argument given is the integer array A.


Output Format

Find and return the original numbers which are used to calculate the GCD array in any order.


Example Input

Input 1:

 A = [2, 2, 2, 2, 8, 2, 2, 2, 10]

Input 2:

 A = [5, 5, 5, 15]



Example Output

Output 1:

 [2, 8, 10]

Output 2:

 [5, 15]



Example Explanation

Explanation 1:

 Initially, array A = [2, 2, 2, 2, 8, 2, 2, 2, 10].
 2 is the gcd between 2 and 8, 2 and 10.
 8 and 10 are the gcds pair with itself.
 Therefore, [2, 8, 10] is the original array.

Explanation 2:

 Initially, array A = [5, 5, 5, 15].
 5 is the gcd between 5 and 15.
 15 is the gcds pair with itself.
 Therefore, [5, 15] is the original array.

*/

/*
 Solution Approach

1.Sort the array in decreasing order.
2.Highest element will always be one of the original numbers. Keep that number and remove it from the array.
3.Compute GCD of the element taken in the previous step with the current element starting from the greatest and discard the GCD value from the given array.

*/

public class Solution {
    public int[] solve(int[] A) {
        int n = (int)Math.sqrt(A.length);
        int[] res = new int[n];
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++){
            map.put(A[i], map.getOrDefault(A[i], 0)+1);
        }
        Arrays.sort(A);
        
        for(int i=A.length-1;j<res.length;i--){
            if(map.get(A[i])>0){
                int temp = A[i];
                res[j++] = temp;
                for(int k=0;k<j;k++){
                    int gcdn = gcd(temp, res[k]);
                    map.put(gcdn, map.get(gcdn)-2);
                }
            }
        }
        
        return res;
    }
    
    public int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
}

