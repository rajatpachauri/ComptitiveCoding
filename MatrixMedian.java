/*
Matrix Median

Problem Description

Given a matrix of integers A of size N x M in which each row is sorted.

Find and return the overall median of the matrix A.

NOTE: No extra memory is allowed.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints

1 <= N, M <= 10^5

1 <= N*M <= 10^6

1 <= A[i] <= 10^9

N*M is odd



Input Format

The first and only argument given is the integer matrix A.


Output Format

Return the overall median of the matrix A.


Example Input

Input 1:

A = [   [1, 3, 5],
        [2, 6, 9],
        [3, 6, 9]   ]

Input 2:

A = [   [5, 17, 100]    ]



Example Output

Output 1:

 5

Output 2:

 17



Example Explanation

Explanation 1:

 
A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
Median is 5. So, we return 5.

Explanation 2:

 
Median is 17.
*/

/*
Solution Approach

We cannot use extra memory, so we can’t actually store all elements in an array and sort the array.
But since, rows are sorted it must be of some use, right?

Note that in a row you can binary search to find how many elements are smaller than a value X in O(log M).
This is the base of our solution.

Say k = N*M/2. We need to find (k + 1)^th smallest element.
We can use binary search on answer. In O(N log M), we can count how many elements are smaller than X in the matrix.

So, we use binary search on interval [1, INT_MAX]. So, total complexity is O(30 * N log M).

Note:
This problem can be solve by using min-heap, but extra memory is not allowed.
*/

public class Solution {
    
    public int lowerBound(int A[], int val)
    {
        int l = 0, h = A.length-1, ans = -1;
        while(l<=h)
        {
            int mid = (h-l)/2 + l;
            
            if(A[mid] < val)
            {
                ans = mid;
                l = mid + 1;
            }
            else
            {
                h = mid - 1;
            }
        }
        
        return ans + 1;
    }
    public int findMedian(int[][] A) {
    
        int low = 0, high = 1000000000, n = A.length, m = A[0].length;
        int medPos = n*m/2, ans = -1; // number of elements less than median element
        while(low <= high)
        {
            int mid = (high - low)/2 + low;
            int cnt = 0;
            
            //count in each row numer of elements <= mid
            for(int i=0;i<n;i++)
            {
                cnt += lowerBound(A[i], mid);
            }

            if(cnt > medPos)
            {
                high = mid - 1;
            }
            else
            {
                ans = mid;
                low = mid + 1;
            }
        }
        
        return ans;
    }
}

