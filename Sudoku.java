/*
Sudoku

Problem Description

Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.

A sudoku puzzle,

and its solution numbers marked in red.



Problem Constraints

N = 9



Input Format

First argument is an array of array of characters representing the Sudoku puzzle.



Output Format

Modify the given input to the required answer.



Example Input

Input 1:

A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]



Example Output

Output 1:

[[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]



Example Explanation

Explanation 1:

Look at the diagrams given in the question.
*/

/*
Solution Approach

Classic backtrack problem.
Everytime you place an element x on row,col, you need to check if its still valid to put x on that position by double checking if x occurs more than once in the row or column or in its block. If not, you proceed by placing x, and call forward to check if a correct solution is possible with x in position row, col.
If a solution is possible, you return the current configuration and you are done. Otherwise you try other values.
*/

public class Solution {
    
    boolean isdone = false;
    
	public void solveSudoku(ArrayList<ArrayList<Character>> res) {
	    solve(res, 0, 0);
	}
	
	public boolean solve(ArrayList<ArrayList<Character>> res, int i, int j){
	    if(i==res.size()-1 && j==res.size()){
	        /*if(!isdone){
	            isdone = true;
	            printlist(res);
	        }
	       for(int k=0;k<res.size();k++){
    	        for(char ch:res.get(k)){
    	            System.out.print(ch);
    	        }
    	        System.out.print(" ");
    	    }*/
	        return true;
	    }
	    if(j==res.size()){
	        i++;
	        j = 0;
	    }
	    char ch = res.get(i).get(j);
	    if(ch=='.'){
	        for(int k=1;k<=9;k++){
	            if(isPossible(res, (char)('0'+k), i, j)){
	                res.get(i).set(j, (char)('0'+k));
	                if(solve(res, i, j+1)){
	                    return true;
	                }
	                res.get(i).set(j, '.');
	            }
	        }
	        res.get(i).set(j, '.');
	    }
	    else{
	        return solve(res, i, j+1);
	    }
	    return false;
	}
	
	public boolean isPossible(ArrayList<ArrayList<Character>> res, char ch, int i, int j){
	    if(res.get(i).contains(ch)){
	        return false;
	    }
	    for(int k=0;k<res.size();k++){
	        if(res.get(k).get(j)==ch){
	            return false;
	        }
	    }
	    int startrow = i-i%3;
	    int startcol = j-j%3;
	    for(int p=startrow;p<3+startrow;p++){
	        for(int q=startcol;q<3+startcol;q++){
	            if(res.get(p).get(q)==ch){
	                return false;
	            }
	        }
	    }
	    
	    return true;
	}
	
	public void printlist(ArrayList<ArrayList<Character>> res){
	    
	}
	
}

