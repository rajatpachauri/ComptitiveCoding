/*
Unique Paths III

Problem Description

Given a matrix of integers A of size N x M . There are 4 types of squares in it:

1. 1 represents the starting square.  There is exactly one starting square.
2. 2 represents the ending square.  There is exactly one ending square.
3. 0 represents empty squares we can walk over.
4. -1 represents obstacles that we cannot walk over.

Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints

2 <= N * M <= 20
-1 <= A[i] <= 2


Input Format

The first argument given is the integer matrix A.


Output Format

Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.


Example Input

Input 1:

A = [   [1, 0, 0, 0]
        [0, 0, 0, 0]
        [0, 0, 2, -1]   ]

Input 2:

A = [   [0, 1]
        [2, 0]    ]



Example Output

Output 1:

2

Output 2:

0



Example Explanation

Explanation 1:

We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

Explanation 1:

Answer is evident here.

*/

public class Solution {
    
    int ans = 0;
    public int solve(int[][] A) {
        int starti= 0, startj=0;
        int count = 0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j]==1){
                    starti = i;
                    startj = j;
                }
                if(A[i][j]==0)
                    count++;
            }
        }
        getPath(A, starti, startj, count, new boolean[A.length][A[0].length]);
        return ans;
    }
    
    public void getPath(int[][] arr, int i, int j, int count, boolean[][] visited){
        if(i==arr.length || j==arr[0].length || i<0 || j<0 || arr[i][j]==-1 || visited[i][j]){
            return;
        }
        if(arr[i][j]==2){
            if(count==-1)
                ans++;
            return;
        }
        
        visited[i][j] = true;
        getPath(arr, i, j-1, count-1, visited);
        getPath(arr, i, j+1, count-1, visited);
        getPath(arr, i-1, j, count-1, visited);
        getPath(arr, i+1, j, count-1, visited);
        visited[i][j] = false;
    }
    
}

