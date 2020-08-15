/*
NQueens

Problem Description

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer A, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.



Problem Constraints

1 <= A <= 10


Input Format

First argument is an integer n denoting the size of chessboard


Output Format

Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.


Example Input

Input 1:

A = 4

Input 2:

A = 1



Example Output

Output 1:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

Output 1:

[
 [Q]
]



Example Explanation

Explanation 1:

There exist only two distinct solutions to the 4-queens puzzle:

Explanation 1:

There exist only one distinct solutions to the 1-queens puzzle:
*/


/*
Solution Approach

Notes :
1) There can exactly be one queen per row. Otherwise the 2 queens in the row would collide. If you miss out on a row, there cannot be N queens on the board.
2) Every column needs to have exactly one queen.
3) The left diagonal cannot have more than one queen ( Unique (row + col) )
4) The right diagonal cannot have more than one queen ( Unique (row - col) )

We can start placing a queen per row. When placing a queen on a row, col, we need to check if the position is available based on what we have already placed. Then we move to the next row.


*/

public class Solution {
	public ArrayList<ArrayList<String>> solveNQueens(int a) {
	    boolean[][] arr = new boolean[a][a];
	    for(int i=0;i<a;i++){
	        Arrays.fill(arr[i], true);
	    }
	    ArrayList<ArrayList<String>> res = new ArrayList<>();
	    genQueen(res, arr, 0);
	    return res;
	}
	
	public void genQueen(ArrayList<ArrayList<String>>res, boolean[][] arr, int i){
	    if(i==arr.length){
	        ArrayList<String> temp = new ArrayList<>();
	        for(int k=0;k<arr.length;k++){
	            String s = "";
	            for(int j=0;j<arr.length;j++){
	                if(arr[k][j]){
	                    s += ".";
	                }
	                else{
	                    s += "Q";
	                }
	            }
	            temp.add(s);
	        }
	        res.add(temp);
	        return;
	    }
	    for(int j=0;j<arr.length;j++){
	        if(isPossible(arr, i , j)){
	            arr[i][j] = false;
	            genQueen(res, arr, i+1);
	            arr[i][j] = true;
	        }
	    }
	}
	
	public boolean isPossible(boolean[][] arr, int i, int j){
	    if(isUp(arr, i, j) && isDleft(arr, i, j) && isDright(arr, i, j)){
	        return true;
	    }
	    
	    return false;
	}
	
	public boolean isUp(boolean[][]arr, int i, int j){
	    if(i<0){
	        return true;
	    }
	    return arr[i][j]&& isUp(arr,i-1,j);
	}
	
	public boolean isDleft(boolean[][]arr, int i, int j){
	    if(i<0 || j<0){
	        return true;
	    }
	    return arr[i][j]&& isDleft(arr,i-1,j-1);
	}
	
	public boolean isDright(boolean[][]arr, int i, int j){
	    if(i<0 || j==arr.length){
	        return true;
	    }
	    return arr[i][j]&& isDright(arr,i-1,j+1);
	}
}

