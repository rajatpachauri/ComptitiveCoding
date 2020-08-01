/*
Reverse integer

Problem Description

You are given an integer N and the task is to reverse the digits of the given integer. Return 0 if the result overflows and does not fit in a 32 bit signed integer

Look at the example for clarification.


Problem Constraints

N belongs to the Integer limits.


Input Format

Input an Integer.


Output Format

Return a single integer denoting the reverse of the given integer.


Example Input

Input 1:

 x = 123


Input 2:

 x = -123



Example Output

Output 1:

 321


Ouput 2:

 -321



Example Explanation

 If the given integer is negative like -123 the output is also negative -321.

*/

/*
Solution Approach

Here are some good questions to ask before coding.

If the integer’s last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

Tips:

1) num % 10 gives you the last digit of a number.

2) num / 10 gives you the number after removing the last digit.

3) num * 10 + digit appends the digit at the end of the number.
*/


public class Solution {
    public int reverse(int A) {
        int temp = Math.abs(A);
        long res = 0;
        
        while(temp>0){
            int rem = temp%10;
            res = res*10 + rem;
            if(res>Integer.MAX_VALUE)
                return 0;
            temp /= 10;
        }
        
        if(A<=0)
            return (int)-res;
        else{
            return (int)res;
        }
    }
}

