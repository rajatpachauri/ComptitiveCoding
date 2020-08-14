/*
Gray Code

Problem Description

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.

A gray code sequence must begin with 0.



Problem Constraints

1 <= A <= 16


Input Format

First argument is an integer A.


Output Format

Return an array of integers representing the gray code sequence.


Example Input

Input 1:

A = 2

Input 1:

A = 1



Example Output

output 1:

[0, 1, 3, 2]

output 2:

[0, 1]



Example Explanation

Explanation 1:

for A = 2 the gray code sequence is:
    00 - 0
    01 - 1
    11 - 3
    10 - 2
So, return [0,1,3,2].

Explanation 1:

for A = 1 the gray code sequence is:
    00 - 0
    01 - 1
So, return [0, 1].
*/

/*
Solution Approach

Note the following :

Let G(n) represent a gray code of n bits.
Note that reverse of G(n) is also a valid sequence.
Let R(n) denote the reverse of G(n).

Note that we can construct
G(n+1) as the following :
0G(n)
1R(n)

Where 0G(n) means all elements of G(n) prefixed with 0 bit and 1R(n) means all elements of R(n) prefixed with 1.
Note that last element of G(n) and first element of R(n) is same. So the above sequence is valid.

Example G(2) to G(3) :
0 00
0 01
0 11
0 10
1 10
1 11
1 01
1 00
*/

public class Solution {
    
    ArrayList<Integer> res;
	public ArrayList<Integer> grayCode(int a) {
	    res = new ArrayList<>();
	    ArrayList<String> arr = new ArrayList<>();
	    arr.add("0");arr.add("1");
	    genList(res, arr,a);
	   // System.out.println(res);
	    return res;
	}
	
	public void genList(ArrayList<Integer> res, ArrayList<String> arr, int a){
	    if(arr.size()==(1<<a)){
	        for(int i=0;i<arr.size();i++){
	            res.add(Integer.parseInt(arr.get(i), 2));
	        }
	        return;
	    }
	    
	    int n = arr.size()-1;
	    for(int i=n;i>=0;i--){
	        arr.add(arr.get(i));
	    }
	    
	    for(int i=0;i<=n;i++){
	        arr.set(i, "0"+arr.get(i));
	    }
	    for(int i=n+1;i<arr.size();i++){
	        arr.set(i, "1"+arr.get(i));
	    }
	    
	   // System.out.println(arr);
	    genList(res, arr, a);
	}
	
}

