/*
Mysterious function

Rishik given an integer array A of size N and a integer B. You pass it through the mysterious_function with psuedo code given as:

def mysterious_function(A,B):
    ans=1
    for number in A:
        ans=power(number,ans) // power(number,ans) returns number raised to power ans
    return ans%B

Rishik is afraid of mysteries, can you tell him the output?


Input Format:

    First argument of input is an integer array A
    Second argument of input is an integer B

Output Format:

    return a single integer denoting value returned by mysterious_function

Constraints:

    1 <= N <= 100
    1 <= A[i], B <= 40000

For Example:

Example Input 1:
    A = [1, 2, 4], B = 10
Example Output 1:
    6
Explanation 1:
    initially ans=1, Then
    i = 1, ans = power(1,1) = 1
    i = 2, ans = power(2,1) = 2
    i = 4, ans = power(4,2) = 16. 16 mod 10 = 6
Example Input 2:
    A = [4, 1, 2, 5, 3], B = 11
Example Output 2:
    1
Explanation 2:
    See carefully mod is taken after performing all the operation!

*/

/*
 Solution Approach

If you see clearly, ans = A[1]A[2]…

So, we have Aφ(m) ≡ 1 (modulo m)

=> AX ≡ AX(modulo φ(m)) (modulo m)

We can use this observation recursively to find answer.
*/

int phi[40009];

void precompute(){ phi[0]=phi[1]=0;

for(int i=0;i<=40000;i++)
    phi[i]=i;

for(int i=2;i<=40000;i++){
    if(phi[i]==i){
        for(int j=i;j<=40000;j+=i){
            phi[j]/=i;
            phi[j]*=(i-1);
        }
    }
}

}

int fast_power(int base,int expo,int mod){ int res=1; base= base % mod;

while(expo > 0){
    if(expo & 1)//odd
        res= (res*base)%mod;
    expo>>=1;//dividing by 2
    base=(base*base)%mod;
}

return res;

}

int getResult(vector<int> &A,int m,int idx){ if(m<=1) return 0; if(idx==0) return A[idx]%m;

int x= getResult(A,phi[m],idx-1);
return fast_power(A[idx],x,m);

}

int Solution::mysterious_function(vector<int> &A, int B) { int n=A.size(); precompute();

return getResult(A,B,n-1);

}

