/*
Excel Column Title

Problem Description

Given a positive integer A, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 



Problem Constraints

1 <= A <= 109


Input Format

First and only argument of input contains single integer A


Output Format

Return a string denoting the corresponding title.


Example Input

Input 1:

A = 3

Input 2:

 
A = 27



Example Output

Output 1:

"C"

Output 2:

"AA"



Example Explanation

Explanation 1:

 
3 corrseponds to C.

Explanation 2:

    1 -> A,
    2 -> B,
    3 -> C,
    ...
    26 -> Z,
    27 -> AA,
    28 -> AB 
*/

/*

Solution Approach

Think of it like this.

How would you convert a number to binary ?

Can you apply the same principle here now that the base is different ?
*/

public class Solution {
    public String convertToTitle(int A) {
        String ans = "";
        while(A>0){
            int rem = (A-1)%26 + 1;
            ans = (char)('A'+rem-1)+ans;
            A /= 26;
            if(rem==26)
                A--;
        }
        
        return ans;
    }
}

