/*
Sorted Permutation Rank

Problem Description

Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
Assume that no characters are repeated.

Note: The answer might not fit in an integer, so return your answer % 1000003



Problem Constraints

1 <= |A| <= 1000


Input Format

First argument is a string A.


Output Format

Return an integer denoting the rank of the given string.


Example Input

Input 1:

A = "acb"

Input 2:

A = "a"



Example Output

Output 1:

2

Output 2:

1



Example Explanation

Explanation 1:

Given A = "acd".
The order permutations with letters 'a', 'c', and 'b' : 
abc
acb
bac
bca
cab
cba
So, the rank of A is 2.

Explanation 2:

Given A = "a".
Rank is clearly 1.
*/

/*
Solution Approach

Lets start by looking at the first character.

If the first character is X, all permutations which had the first character less than X would come before this permutation when sorted lexicographically.

Number of permutation with a character C as the first character = number of permutation possible with remaining N-1 character = (N-1)!

Then the problem reduces to finding the rank of the permutation after removing the first character from the set.

Hence,

rank = number of characters less than first character * (N-1)! + rank of permutation of string with the first character removed

Example

Lets say out string is “VIEW”.

Character 1 : 'V'
All permutations which start with 'I', 'E' would come before 'VIEW'.
Number of such permutations = 3! * 2 = 12

Lets now remove ‘V’ and look at the rank of the permutation ‘IEW’.

Character 2 : ‘I’
All permutations which start with ‘E’ will come before ‘IEW’
Number of such permutation = 2! = 2.

Now, we will limit ourself to the rank of ‘EW’.

Character 3:
‘EW’ is the first permutation when the 2 permutations are arranged.

So, we see that there are 12 + 2 = 14 permutations that would come before "VIEW".
Hence, rank of permutation = 15.
*/

public class Solution {
    
    int mod = 1000003;
    
	public int findRank(String s) 
	{ 
	    int rank = 1;
	    int n = s.length()-1;

		for (int i = 0; i < n; i++)
		{
			// count all smaller characters than str[i] to the right of i
			int count = 0;
			for (int j = i + 1; j <= n; j++)
			{
				if (s.charAt(i) > s.charAt(j))
					count++;
			}
			// add current count to the rank
			rank += count * factorial(n - i)%mod;
			rank = rank%mod;
		}
	    
	    return rank;
	}
	
	public int factorial(int n)
	{
		return (n <= 2) ? n : n * factorial(n - 1)%mod;
	}
	
}

