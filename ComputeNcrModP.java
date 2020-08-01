/*
Compute nCr % m

Problem Description

Given three integers A, B and C, where A represents n, B represents r and C represents m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.

x! means factorial of x i.e. x! = 1 * 2 * 3... * x.



Problem Constraints

1 <= A * B <= 106

1 <= B <= A

1 <= C <= 106



Input Format

The first argument given is integer A ( = n).
The second argument given is integer B ( = r).
The third argument given is integer C ( = m).


Output Format

Return the value of nCr % m.


Example Input

Input 1:

 A = 5
 B = 2
 C = 13

Input 2:

 A = 6
 B = 2
 C = 13



Example Output

Output 1:

 10

Output 2:

 2



Example Explanation

Explanation 1:

 The value of 5C2 % 11 is 10.

Explanation 2:

 The value of 6C2 % 13 is 2.
*/

/*
Solution Approach

If we calculate nCr by calculating factorial of each number and then doing n! / (r! * (n-r)!) % m. This will not work as the factorial can be very large and will cause overflow.

As we know nCr = n-1Cr-1 + n-1Cr.

So we will use Dynamic Programming approach and calculate the value of nCr.
*/

// A modular inverse based solution to 
// compute nCr % 
import java.io.*; 

class GFG { 

    public static long fact[],inverseFact[],sum[];
    final static long c=(long)(1E9+7);
    
    public static long fastExponentiation(long a,long b)
    {
        long res=1;
        while(b>0)
        {
            while(b%2==0)
            {
                a=(a*a)%c;
                b=b>>1;
            }
            b--;
            res=(res*a)%c;
        }
        return res;
    }
    
    public static long power(long x,long y)
	{
	    if (y == 0)
	        return 1;
	    long p = power(x, y/2) % c;
	    p = (p * p) % c;
	 
	    return (y%2 == 0)? p : (x * p) % c;
	}
    
    public static void initialise()
    {
        fact=new long[200001];
        inverseFact=new long[200001];
        storeFactorials(200000);
        storeReverseFactorials(200000);
    }
    
    public static void storeFactorials(int n)
    {
        n++;
        fact[0]=1;
        for(int i=1;i<n;++i)
            fact[i]=(fact[i-1]*i)%c;
    }
    
    public static void storeReverseFactorials(int n)
    {
        n++;
        inverseFact[0]=inverseFact[1]=1;
        for(int i=2;i<n;++i)
            inverseFact[i]=power(fact[i],c-2);
    }
    
    public static long combo(int n,int k)
    {
        if(n<k||n<0||k<0)
            return 0;
        else
            return ((fact[n]*((inverseFact[k]*inverseFact[n-k])%c))%c);
    }
    
    public static void main (String[] args) {
        initialise();
        
        System.out.println(combo(200000, 100000));
    }
    
} 



public class Solution {
    
    public int solve(int A, int B, int C) {
        	int dp[][] = new int[A+1][B+1]; 
        	
        	for (int i = 0; i <= A; i++) 
        	{ 
        		for (int j = 0; j <= Integer.min(i, B); j++) 
        		{ 
        			if (j == 0 || j == i) 
        				dp[i][j] = 1%C; 
        			else
        				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%C; 
        		} 
        	} 
        	
        	return dp[A][B];
    }
    
}
