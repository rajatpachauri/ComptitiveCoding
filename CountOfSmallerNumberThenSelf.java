/*
Count of smaller numbers after self

Problem Description

Given an array of integers A, find and return new integer array B.

Array B has the property where B[i] is the number of smaller elements to the right of A[i].



Problem Constraints

1 <= length of the array <= 100000

1 <= A[i] <= 109



Input Format

The only argument given is the integer array A.


Output Format

Return the new integer array B.


Example Input

A = [1, 5, 4, 2, 1]



Example Output

[0, 3, 2, 1, 0]



Example Explanation

Number of smaller elements to the right of 1 are 0.
Number of smaller elements to the right of 5 are 3 (4, 2, 1).
Number of smaller elements to the right of 4 are 2 (2, 1).
Number of smaller elements to the right of 2 are 1 (1).
Number of smaller elements to the right of 1 are 0.
*/

/*
Solution Approach

We can do this by using two loops and find the answer for each index in the array.
Time complexity for this will be O(N2). This will fail for large test case.

Approach 1

Use the idea of the merge sort at the time of merging two arrays.

When higher index element is less than the lower index element, it represents that the higher index element is smaller than all the elements after that lower index because the left part is already sorted.

Hence add up to all the elements after the lower index element for the required count.

Approach 2

For optimized solution we can use data compression and bit(fenwick tree).

We will sort the given data in other auxilary array and then compressed the values staring from 1.

Now for the original array, we loop through it back, first find the answer for that element using query in bit and then add the element in the bit.

Store these value in another array and return that.
*/

public class Solution {
    
    class NumberIndex {
    	int number;
    	int index;
    
    	NumberIndex(int number, int index) {
    		this.number = number;
    		this.index = index;
    	}
    
    	NumberIndex(NumberIndex another) {
    		this.number = another.number;
    		this.index = another.index;
    	}
    }
    
    public int[] solve(int[] nums) {
    	NumberIndex[] cnums = new NumberIndex[nums.length];
    	for (int i = 0; i < nums.length; i++) {
    		cnums[i] = new NumberIndex(nums[i], i);
    	}
    	int[] smaller = new int[nums.length];
    	cnums = sort(cnums, smaller);
    	
    	return smaller;
    }
    
    private NumberIndex[] sort(NumberIndex[] nums, int[] smaller) {
    	int half = nums.length / 2;
    	if (half > 0) {
    		NumberIndex[] rightPart = new NumberIndex[nums.length - half];
    		NumberIndex[] leftPart = new NumberIndex[half];
    		for (int i = 0; i < leftPart.length; i++) {
    			leftPart[i] = new NumberIndex(nums[i]);
    		}
    		for (int i = 0; i < rightPart.length; i++) {
    			rightPart[i] = new NumberIndex(nums[half + i]);
    		}
    		NumberIndex[] left = sort(leftPart, smaller), right = sort(
    				rightPart, smaller);
    		int m = left.length, n = right.length, i = 0, j = 0;
    		while (i < m || j < n) {
    			if (j == n || i < m && left[i].number <= right[j].number) {
    				nums[i + j] = left[i];
    				smaller[left[i].index] += j;
    				i++;
    			} else {
    				nums[i + j] = right[j];
    				j++;
    			}
    		}
    	}
    	return nums;
    }

    
}

