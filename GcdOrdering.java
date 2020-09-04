/*
Gcd Ordering

Given an array of integers A, find and return the lexicographically greatest arrangement of A which follows the below rules:

    If the size of A is less than 3 it is always possible to rearrange A.

    A[i] = A[i-1] + GCD(A[i-1], A[i-2]) for all i > 2, where GCD(x, y) is greatest common factor of x and y.

Return the lexicographically greatest arrangement of A which follows the above rules, if it is not possible to rearrange A according to the above rules return -1.

Note: Lexicographically means in dictionary order, i.e. if two arrangemnets are compared based on dictionary position the arrangements which comes afterwards is said to be Lexicographically greater.


Input Format

The only argument given is the integer array A.

Output Format

Return the lexicographically greatest arrangement of A  which follows the above rules, 
if it is not possible to rearrange A according to the given rules return -1.

Constraints

1 <= length of the array <= 100000
0 <= A[i] <= 10^5

For Example

Input 1:
    A = [4, 6, 2, 5, 3]
Output 1:
     [2, 3, 4, 5, 6]

Input 2:
    A = [3, 8, 5]
Output 2:
    -1

*/

/*
Hint 1

You would have guessed of a solution that would involve sorting of the array and then checking if the gcd condition holds. You are partly right, the numbers have to be in increasing sequence but except for one case where there could be a number that could appear at the start of the permutation. For Example, in 2 4 6 8 8, you could have had 8 at the starting and have got the permutation 8 2 4 6 8. There were many corner cases to this
Check for the corner cases.

Few other things to note were -
1) you couldn’t have more than two elements whose freq was more than 1.
2) if you had two zeros in the array, the only possible permutation possible was all 0’s
3) you had to use gcd of(0,x) = x wisely.

Time Complexity - nlogn

*/

// Java implementation of the approach 
import java.util.*; 

class GFG 
{ 

static void Print(Vector<Integer> ans) 
{ 
	for (Integer i : ans) 
		System.out.print(i + " "); 
} 
 
static void Permutation(int a[], int n) 
{ 
	int flag = 0, pos = 0; 
	Vector<Integer> ans = new Vector<Integer>();  
	Arrays.sort(a); 

	for (int i = 2; i < n; i++) 
	{ 
		if (a[i] != a[i - 1] + __gcd(a[i - 1], a[i - 2])) 
		{ 
			flag = 1; 
			pos = i; 
			break; 
		} 
	} 
	if (flag == 0) 
	{ 
		if (a[1] == a[0] + __gcd(a[0], a[n - 1])) 
		{ 
			ans.add(a[n - 1]); 
			for (int i = 0; i < n - 1; i++) 
				ans.add(a[i]); 

			Print(ans); 
			return; 
		} 
		else
		{ 
			for (int i = 0; i < n; i++) 
				ans.add(a[i]); 

			Print(ans); 
			return; 
		} 
	}  
	else
	{ 
		if (a[1] == a[0] + __gcd(a[pos], a[0])) 
		{ 
			flag = 0; 
			for (int i = n - 1; i > pos + 2; i--) 
			{ 
				if (a[i] != a[i - 1] + __gcd(a[i - 1], a[i - 2])) 
				{ 
					flag = 1; 
					break; 
				} 
			} 

			if (flag == 0 & pos < n - 1) 
			{  
				if (a[pos + 1] 
					!= a[pos - 1] + __gcd(a[pos - 1], a[pos - 2])) 
					flag = 1; 
			} 

			if (flag == 0 & pos < n - 2) 
			{
				if (a[pos + 2] 
					!= a[pos + 1] + __gcd(a[pos - 1], a[pos + 1])) 
					flag = 1; 
			} 
			if (flag == 0) 
			{ 
				ans.add(a[pos]); 
				for (int i = 0; i < n; i++) 
					if (i != pos) 
						ans.add(a[i]); 

				Print(ans); 
				return; 
			} 
		} 
	} 
	ans.add(-1); 
	Print(ans); 
} 

  static int __gcd(int a, int b) 
  { 
      if (b == 0) 
          return a; 
      return __gcd(b, a % b);	 
  } 

  public static void main(String[] args) 
  { 
      int a[] = { 4, 6, 2, 8, 8 }; 
      int n = a.length; 

      Permutation(a, n); 
  } 
} 

