/*
Shuttle Puzzle Problem

Problem Description

We are given n White marbles and n Black marbles along with a strip with 2n+1 holes . The n White marbles are on the left side occupying the leftmost n holes and the n Black marbles are on the right side occupying the rightmost n holes. The middle hole i.e the n+1 hole is empty.

For example if n = 4 , then the initial configuration of the strip is - WWWWHBBBB, Where H denotes the empty hole.

Valid moves are :

    Move 1 marble by 1 space (into the empty hole).
    Jump 1 marble over 1 marble of the opposite color (into the empty hole).

Output set of minimum number of valid moves to achieve the transformation of n Black marbles to the left followed by a hole followed by n White marbles.


NOTE - The first move should be the slide of the White marble(At Hole number n-1) to the right.



Problem Constraints

1 <= n <= 15


Input Format

First argument is an integer n.



Output Format

Return a list of strings where each string represents the state of the strip after each move.


Example Input

Input 1:

 1



Example Output

Output 1:

 [WHB, HWB, BWH, BHW]



Example Explanation

Explanation 1:

 For n = 1, initial configuration of strip -> WHB.
 After moving white marble to the right -> HWB.
 Now, move black marble to the leftmost hole -> BWH.
 Finally move the white marble to the rightmost hole -> BHW.
*/

/*
Solution Approach

There are 4 valid moves possible.
1. Slide a white marble to the right if the configuration contains ‘WH’. For example, if we have a configuration like ‘BBWBWBWHW’ , then we can slide the white marble to the right in the next move, and we get a new configuration as ‘BBWBWBWWH’ .
2. Slide a black marble to the left if the configuration contains ‘HB’.
3. Jump a white marble over a black marble to the right if the configuration contains ‘WBH’.
4. Jump a black marble over a white marble to the left if the configuration contains ‘HWB’.

Considering the valid moves, this problem can now be solved using backtracking.
We try each and every possible move for the current configuration we have, and if a move is possible then we recurse on the new configuration and increase the number of moves performed by 1. After the recursion, we backtrack by undoing the move. This is the basic backtracking algorithm using recursion. The number of times our recursive function is called is exponential in the given input ‘n’, since there can be 2^(2n+1) different configurations (because we have 2n+1 marbles).
*/

public class Solution {
    
    ArrayList<String> ans = null;
    
    public ArrayList<String> solve(int A) {
        char[] arr = new char[2*A+1];
        for(int i=0;i<2*A+1;i++){
            if(i<A){
                arr[i] = 'W';
            }
            else if(i==A){
                arr[i] = 'H';
            }
            else{
                arr[i] = 'B';
            }
        }
//        System.out.println(Arrays.toString(arr));
        genValidPath(arr, A, new ArrayList<>());
        return ans;
    }
    
    public void genValidPath(char[] arr, int index, ArrayList<String> list){
        if(index==arr.length/2 && isValid(arr)){
//        	System.out.println(list);
            list.add(new String(arr));
            if(ans==null || ans.size()>list.size()){
                ans = new ArrayList<>(list);
            }
            return;
        }
        
        String s = new String(arr); 
        
        if(list.contains(s)){
            return;
        }
        
        list.add(s);
        if(index-1>=0 && arr[index-1]=='W'){
            swap(arr, index, index-1);
            genValidPath(arr, index-1, list);
            swap(arr, index-1, index);
        }
        if(index+1<arr.length && arr[index+1]=='B'){
            swap(arr, index, index+1);
            genValidPath(arr, index+1, list);
            swap(arr, index+1, index);
        }
        if(index-2>=0 && arr[index-1]!=arr[index-2] && arr[index-2]=='W'){
            swap(arr, index, index-2);
            genValidPath(arr, index-2, list);
            swap(arr, index-2, index);
        }
        if(index+2<arr.length && arr[index+1]!=arr[index+2] && arr[index+2]=='B'){
            swap(arr, index, index+2);
            genValidPath(arr, index+2, list);
            swap(arr, index+2, index);
        }
        list.remove(list.size()-1);
    }
    
    public boolean isValid(char[] arr){
        for(int i=0;i<arr.length/2;i++){
            if(arr[i]!='B'){
                return false;
            }
        }
        return true;
    }
    
    public void swap(char[] arr, int a, int b){
    	char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
}

