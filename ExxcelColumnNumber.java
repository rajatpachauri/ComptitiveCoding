/*
Excel Column Number

Problem Description

Given a column title as appears in an Excel sheet, return its corresponding column number.


Problem Constraints

1 <= length of the column title <= 5


Input Format

Input a string which represents the column title in excel sheet.


Output Format

Return a single integer which represents the corresponding column number.


Example Input

Input 1:

 AB

Input 2:

 ABCD



Example Output

Output 1:

 28

Output 2:

 19010



Example Explanation

Explanation 1:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
*/

/*

Solution Approach

Simple math.

This is just like base 26 number conversion.

number = 26^0 * (S[n - 1] - ‘A’ + 1) + 26^1 * (S[n - 2] - ‘A’ + 1) + ….

We recommend you to check out the piece on base number conversion in articles again. Please also attempt the sample problem associated with it.
*/

public class Solution {
    public int titleToNumber(String A) {
        int result = 0; 
    	for (int i = 0; i < A.length(); i++) 
    	{ 
    		result *= 26; 
    		result += A.charAt(i) - 'A' + 1; 
    	} 
    	return result; 
    }
}

