/*
Aggressive cows

Problem Description

Farmer John has built a new long barn, with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall, and an integer B which represent the number of cows.

His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?



Problem Constraints

2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N


Input Format

The first argument given is the integer array A.
The second argument given is the integer B.


Output Format

Return the largest minimum distance possible among the cows.


Example Input

Input 1:

A = [1, 2, 3, 4, 5]
B = 3

Input 2:

A = [1, 2]
B = 2



Example Output

Output 1:

 2

Output 2:

 1



Example Explanation

Explanation 1:

 
John can assign the stalls at location 1,3 and 5 to the 3 cows respectively.
So the minimum distance will be 2.

Explanation 2:

 
The minimum distance will be 1.
*/

/*
Solution Approach

We’ll be doing the binary search for finding the best possible maximum difference.

Since the maximum difference range between 0 to max of array.
If we sort the array then binary search starts with l=0 and r=A[n-1] and we’ve to find the maximum distance.
For mid in binary search, we will check whether there are B stalls such that the minimum distance is greater than equal to mid.
Finally store the maximum value we can get.
*/

public class Solution {
    
    private boolean isPossible(int[] arr, int cows, int gap) {
        int numCows = 1;
        int cowPos = 0;
        for(int i=1;i<arr.length;++i) {
            if(arr[i]-arr[cowPos]>=gap) {
                ++numCows;
                if(numCows==cows) {
                    return true;
                }
                cowPos=i;
            }
        }
        return false;
    }
    
    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int high = A[A.length-1]-A[0];
        int low = 0;
        while(low<high) {
            int mid = low+(high-low+1)/2;
            if(isPossible(A,B,mid)) {
                low=mid;
            } else {
                high=mid-1;
            }
        }
        return low;
    }
}

