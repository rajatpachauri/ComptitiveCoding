/*
INVERSIONS

Given an array A, count the number of inversions in the array.

Formally speaking, two elements A[i] and A[j] form an inversion if A[i] > A[j] and i < j

Example:

A : [2, 4, 1, 3, 5]
Output : 3

as the 3 inversions are (2, 1), (4, 1), (4, 3).

*/

public class Solution {
    public int countInversions(int[] A) {
        int count = 0; 
		for (int i = 0; i < A.length-1; i++) 
			for (int j = i + 1; j < A.length; j++) 
				if (A[i] > A[j]) 
					count++; 

		return count;
    }
}

