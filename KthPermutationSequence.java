/*
Kth Permutation Sequence

The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, We get the following sequence (ie, for n = 3 ) :

1. "123"
2. "132"
3. "213"
4. "231"
5. "312"
6. "321"

Given n and k, return the kth permutation sequence.

For example, given n = 3, k = 4, ans = "231"

    Good questions to ask the interviewer :

        What if n is greater than 10. How should multiple digit numbers be represented in string?

        In this case, just concatenate the number to the answer. so if n = 11, k = 1, ans = "1234567891011" 

        Whats the maximum value of n and k?

        In this case, k will be a positive integer thats less than INT_MAX. n is reasonable enough to make sure the answer does not bloat up a lot. 

*/

/*
Solution Approach

This involves a little bit of maths and recursion for simplicity.

Number of permutation possible using n distinct numbers = n!

Lets first make k 0 based.
Let us first look at what our first number should be.
Number of sequences possible with 1 in first position : (n-1)!
Number of sequences possible with 2 in first position : (n-1)!
Number of sequences possible with 3 in first position : (n-1)!

Hence, the number at our first position should be k / (n-1)! + 1 th integer.

Can we reduce the k and modify the set we pick our numbers from ( initially 1 2 3 … n ) to call the function for second position onwards ?

*/

public class Solution {
	public String getPermutation(int A, int B) {
	ArrayList<Integer> candidateSet = new ArrayList<>();
        for (int i = 1; i <= A; i++){
            candidateSet.add(i);
        }
        return getPermutation(B - 1, candidateSet);
    }

    private static String getPermutation(int k, ArrayList<Integer> candidateSet) {
        int n = candidateSet.size();
        if (n == 0) {
            return "";
        }
        if (k > factorial(n)) return ""; // invalid. Should never reach here.

        int f = factorial(n - 1);
        int pos = k / f;
        k %= f;
        String ch = String.valueOf(candidateSet.get(pos));
        // now remove the character ch from candidateSet.
        candidateSet.remove(pos);
        return ch + getPermutation(k, candidateSet);
    }

    static int factorial(int n) {
        if (n > 12) {
            // this overflows in int. So, its definitely greater than k
            // which is all we care about. So, we return INT_MAX which
            // is also greater than k.
            return Integer.MAX_VALUE;
        }
        // Can also store these values. But this is just < 12 iteration, so meh!
        int fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }
}


