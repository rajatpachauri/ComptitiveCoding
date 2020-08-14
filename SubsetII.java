/*
Subsets II

Problem Description

Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.

NOTE:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.



Problem Constraints

0 <= N <= 16


Input Format

Only argument is an integer array A of size N.


Output Format

Return a 2-D vector denoting all the possible subsets.


Example Input

Input 1:

 A = [1, 2, 2]

Input 2:

 A = [1, 1]



Example Output

Output 1:

 [
    [],
    [1],
    [1, 2],
    [1, 2, 2],
    [2],
    [2, 2]
 ]

Output 2:

 [
    [],
    [1],
    [1, 1]
 ]



Example Explanation

Explanation 1:

All the subsets of the array [1, 2, 2] in lexicographically sorted order.
*/

/*
Solution Approach

Think in terms of recursion.
This is very similar to the problem where you need to generate subsets for distinct integer. However, in this case, because of repetitions, things are not as simple as choosing or rejecting an element.
Now for the elements which are repeated you need to iterate over the count of elements you are going to include in your subset
*/

public class Solution {
    
    ArrayList<ArrayList<Integer>> res;
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        res = new ArrayList<>();
        genSubset(A, 0, new ArrayList<>());
        return res;
    }
    
    public void genSubset(ArrayList<Integer> list, int start, ArrayList<Integer> temp){
        if(start==list.size()){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        res.add(new ArrayList<>(temp));
        for(int i=start;i<list.size();i++){
            if(i>start && list.get(i)==list.get(i-1))
                continue;
            temp.add(list.get(i));
            genSubset(list, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
    
}

