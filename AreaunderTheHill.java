/*
Area under the hills

Problem Description

Rishik likes to draw a lot. He starts at origin and chooses a single Y ordinate of each abscissa in [1-N] given in array A and then chooses 0 for N+1. He then joins each consecutive point with a straight line and found that he has drawn a masterpiece. But, It is incomplete without coloring.

So, he wants you to tell him the area of hills that he will color.



Problem Constraints

1 <= N <= 2e5

1 <= A[i] <= 2e9



Input Format

First and only argument of input contains a single integer array A.


Output Format

Return a string denoting area of hills(with truncated/rounded down decimal).


Example Input

Input 1:

 [2, 1, 3]

Input 2:

 [10]



Example Output

Output 1:

 "6"

Output 2:

 "10"



Example Explanation

Explanation 1:

See Image for diagram, Area under curve is 6.

*/

/*
Solution Approach

Since heights start and end at 0. Each height contribute area = 1/2 * 2 * height = height.

So, answer is just Summation of all values.

*/

public class Solution {
    public String solve(int[] A) {
        long ans = 0;
        for(int i=0;i<A.length;i++){
            ans += A[i];
        }
        
        return ""+ans;
    }
}

