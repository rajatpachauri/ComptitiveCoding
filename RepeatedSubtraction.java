/*

Repeated Subtraction

You are given 2 numbers P and Q.

An operation on these 2 numbers is defined as follows: Take the smaller number of the 2 numbers and subtract it from the bigger number. Keep performing this operation till either of the following criterion is met:

    Both numbers become equal.
    Either of the number becomes 0.

Find the sum of the final values of P and Q.

Constraints:

 0 <= P,Q <= 1e9

Input:

Two integers P and Q

Output:

Sum of the final values of P and Q

Example:

Input:

P : 5 
Q : 15

Output:

10

Explanation:

For the first operation, smaller of P and Q is P.
So we subtract P from Q which gives us the new values of P and Q as 5 and 10 resp.
For the second operation, smaller of P and Q is P.
So we subtract P from Q which gives us the new values of P and Q as 5 and 5 resp.
Since the values of P and Q are now same, we output the sum of these values=10.

*/

/*
Solution Approach

The answer will be 2*(greatest common divisor of P and Q).
Consider this for any two prime numbers, we will always reach a point where one number will be reduced to 0 and the other to 1.
Similarly, for any two numbers (not necessarily prime), one of P and Q will reach the greatest number that divides both P and Q
while the other might be 0 or the greatest number that divides both P and Q itself.
Working out a few cases on pen paper helps you reach this conclusion too.
*/

public class Solution {
    public int getFinal(int A, int B) {
        if(A==0){
            return B;
        }
        if(B==0){
            return A;
        }
        
        return 2*gcd(A, B);
    }
    
    public int gcd(int A, int B){
        if(B==0)
            return A;
        return gcd(B, A%B);
    }
}

