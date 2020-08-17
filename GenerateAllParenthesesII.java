/*
Generate all Parentheses II

Problem Description

Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.


Problem Constraints

1 <= A <= 20


Input Format

First and only argument is integer A.


Output Format

Return a sorted list of all possible paranthesis.


Example Input

Input 1:

A = 3

Input 2:

A = 1



Example Output

Output 1:

[ "((()))", "(()())", "(())()", "()(())", "()()()" ]

Output 2:

[ "()" ]



Example Explanation

Explanation 1:

 All paranthesis are given in the output list.

Explanation 2:

 All paranthesis are given in the output list.

*/

/*
Solution Approach

Again, think recursion.
At every step, you have 2 options :
1) Add ‘(‘ to the string.
2) Add ‘)’ to the string.
However, you need to make sure, that the number of closing brackets do not exceed number of opening brackets at any point of time.
Also, make sure that the number of opening brackets never exceeds n.
*/

public class Solution {
    
    public ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> res = new ArrayList<>();
        genParen(res, A, 0, 0, "");
        return res;
    }
    
    public void genParen(ArrayList<String> res, int n, int open, int closing, String s){
        if(closing==n){
            res.add(new String(s));
            return;
        }
        if(open<n){
            genParen(res, n, open+1, closing, s+"(");
        }
        if(closing<open){
            genParen(res, n, open, closing+1, s+")");
        }
    }
}

