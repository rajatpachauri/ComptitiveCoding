/*
Is it a parabola?

Problem Description
Today, Rishik discovered a magical curve! He observed that it has an equation of form M.y = N.x2 + O.x + P. The most magical thing was that for each point on this curve distance to point (A, B) (let's call it d1) and distance to the x-axis (let's call it d2) is same(that is d1=d2)!

Can you find the value of this magical curve?

NOTE: Equation should be in simple form (i.e gcd(|M|, |N|, |O|, |P|) = 1) and N should always be positive.



Problem Constraints

-32000 <= A, B <= 32000


Input Format

First argument of input contains an integer A. Second argument of input contains an integer B.


Output Format

Return an integer array containing exactly 4 integers M, N, O, P.


Example Input

Input 1:

 A = 1
 B = 1

Input 2:

 A = -1
 B = 1



Example Output

Output 1:

 [2, 1, -2, 2]

Output 2:

 [2, 1, 2, 2]



Example Explanation

Explanation 1:

 Each point on the curve 2y = x^2 - 2x + 2 is equidistant from (1,1) and x axis! 
*/

/*
Solution Approach

Fun Fact: The question actually describes specific case of standard definition of parabola. You can learn about it here

The Directrix here is y = 0 and focus is (A,B).

all you need to do is apply distance formula for focus:

y2 = (x-A)2 + (x-B)2

this simplify to 2by = 1x2 -2ax + a2 + b2

On comparing this gives:

M = 2b

N = 1

O = -2a

P = a2 + b2
*/

public class Solution {
    public int[] solve(int A, int B) {
        int[] res = {2*B, 1, -2*A, A*A+B*B};
        
        return res;
    }
}

