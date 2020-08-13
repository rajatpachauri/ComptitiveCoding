/*
Search for a Range

Problem Description

Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given integar B in array A.

Your algorithm's runtime complexity must be in the order of O(log n).

Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].



Problem Constraints

1 <= N <= 106

1 <= A[i], B <= 109



Input Format

The first argument given is the integer array A.
The second argument given is the integer B.


Output Format

Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].


Example Input

Input 1:

 A = [5, 7, 7, 8, 8, 10]
 B = 8

Input 2:

 A = [5, 17, 100, 111]
 B = 3



Example Output

Output 1:

 [3, 4]

Output 2:

 [-1, -1]



Example Explanation

Explanation 1:

 First occurence of 8 in A is at index 3
 Second occurence of 8 in A is at index 4
 ans = [3, 4]

Explanation 2:

 There is no occurence of 3 in the array.
*/

/*
Solution Approach

First, let us find the left boundary of the range.

We initialize the range to [i=0, j=n-1]. In each step, calculate the middle element [mid = (i+j)/2].

Now according to the relative value of A[mid] to target, there are three possibilities:

    If A[mid] < target, then the range must begin on the right of mid (hence i = mid+1 for the next iteration)

    If A[mid] > target, it means the range must begin on the left of mid (j = mid-1)

    If A[mid] = target, then the range must begins on the left of or at mid (j= mid)

Since we would move the search range to the same side for case 2) and 3), we might as well merge them as one single case so that less code is needed:

2*. If A[mid] >= target, j = mid;

Surprisingly, 1 and 2* are the only logic you need to put in loop while (i < j). When the while loop terminates, the value of i/j is where the start of the range is. Why?

No matter what the sequence originally is, as we narrow down the search range, eventually we will be at a situation where there are only two elements in the search range.

Suppose our target is 5, then we have only 7 possible cases:

    Case 1: [5 7] (A[i] = target < A[j])

    Case 2: [5 3] (A[i] = target > A[j])

    Case 3: [5 5] (A[i] = target = A[j])

    Case 4: [3 5] (A[j] = target > A[i])

    Case 5: [3 7] (A[i] < target < A[j])

    Case 6: [3 4] (A[i] < A[j] < target)

    Case 7: [6 7] (target < A[i] < A[j])

For case 1, 2 and 3, if we follow the above rule, since mid = i => A[mid] = target in these cases, then we would set j = mid.

Now the loop terminates and i and j both point to the first 5.

For case 4, since A[mid] < target, then set i = mid+1. The loop terminates and both i and j point to 5.

For all other cases, by the time the loop terminates, A[i] is not equal to 5. So we can easily know 5 is not in the sequence if the comparison fails.

In conclusion, when the loop terminates, if A[i]==target, then i is the left boundary of the range; otherwise, just return -1;

For the right of the range, we can use a similar idea. Again we can come up with several rules:

    If A[mid] > target, then the range must begin on the left of mid (j = mid-1)

    If A[mid] < target, then the range must begin on the right of mid (hence i = mid+1 for the next iteration)

    If A[mid] = target, then the range must begins on the right of or at mid (i= mid)

Again, we can merge conditions 2 and 3 into:

2*. If A[mid] <= target, then i = mid;

However, the terminate condition on longer works this time.

Consider the following case:

[5 7], target = 5

Now A[mid] = 5, then according to rule 2), we set i = mid.

This practically does nothing because i is already equal to mid.

As a result, the search range is not moved at all!

The solution is in using a small trick:

Instead of calculating mid as mid = (i+j)/2, we now do:

mid = (i+j)/2+1

Why does this trick work?

When we use mid = (i+j)/2, the mid is rounded to the lowest integer.

In other words, mid is always biased towards the left. This means we could have i == mid when j - i == mid,

but we NEVER have j == mid. So in order to keep the search range moving, we must make sure that the new i is set to something different than mid, otherwise we are at the risk that i gets stuck.

But for the new j, it is okay if we set it to mid, since it was not equal to mid anyway.

Our two rules in search for the left boundary happen to satisfy these requirements, so it works perfectly in that situation.

Similarly, when we search for the right boundary, we must make sure i does not get stuck when we set the new i to i = mid.

The easiest way to achieve this is by making mid biased to the right, i.e. mid = (i+j)/2+1.

*/

public class Solution {
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
	    ArrayList<Integer> res = new ArrayList<>();
	    res.add(first(a, 0, a.size()-1, b, a.size()));
	    res.add(last(a, 0, a.size()-1, b, a.size()));
	    return res;
	}
	
	public int first(List<Integer> arr, int low, int high, int x, int n) 
	{ 
		if(high >= low) 
		{ 
			int mid = low + (high - low)/2; 
			if( ( mid == 0 || x > arr.get(mid-1)) && arr.get(mid) == x) 
				return mid; 
			else if(x > arr.get(mid)) 
				return first(arr, (mid + 1), high, x, n); 
			else
				return first(arr, low, (mid -1), x, n); 
		} 
	    return -1; 
	} 

	public int last(List<Integer> arr, int low, int high, int x, int n) 
	{ 
		if (high >= low) 
		{ 
			int mid = low + (high - low)/2; 
			if (( mid == n-1 || x < arr.get(mid+1)) && arr.get(mid) == x) 
				return mid; 
			else if (x < arr.get(mid)) 
				return last(arr, low, (mid -1), x, n); 
			else
				return last(arr, (mid + 1), high, x, n); 
		} 
	    return -1; 
	}
	
}

