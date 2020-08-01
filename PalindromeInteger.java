/*
Palindrome Integer

Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed. Negative numbers are not palindromic.

Example :

Input : 12121
Output : True

Input : 123
Output : False

*/

public class Solution {
    public int isPalindrome(int A) {
        if(A<0)
            return 0;
        int temp = A;
        int B = 0;
        while(A>0){
            int rem = A%10;
            B = B*10+rem;
            A /= 10;
        }
        
        if(temp==B)
            return 1;
        else 
            return 0;
    }
}

