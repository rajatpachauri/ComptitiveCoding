/*
All Unique Permutations

Problem Description

Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.

NOTE: No 2 entries in the permutation sequence should be the same.

WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.



Problem Constraints

1 <= |A| <= 9


Input Format

Only argument is an integer array A of size N.


Output Format

Return a 2-D array denoting all possible unique permutation of the array.


Example Input

Input 1:

A = [1, 1, 2]

Input 2:

A = [1, 2]



Example Output

Output 1:

[ [1,1,2]
  [1,2,1]
  [2,1,1] ]

Output 2:

[ [1, 2]
  [2, 1] ]



Example Explanation

Explanation 1:

 All the possible unique permutation of array [1, 1, 2].

Explanation 2:

 All the possible unique permutation of array [1, 2].
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        genPerm(res, A, 0);
        return res;
    }
    
    public void genPerm(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int start){
        if(start==list.size()-1){
            // System.out.print("-->");
            // System.out.println(list);
            res.add(new ArrayList<>(list));
            return;
        }
        
        // System.out.println(list);
        for(int i=start;i<list.size();i++){
            if(isSwapReq(list, start, i)){
                swap(list, start, i);
                genPerm(res, list, start+1);
                swap(list, i, start);
            }
        }
    }
    
    public boolean isSwapReq(ArrayList<Integer> list, int start, int end){
        if(end==start){
            return true;
        }
        if(list.get(start)==list.get(end) || list.get(end)==list.get(end-1))
            return false;
        
        // OR
        // for(int i=start;i<end;i++){
        //     if(list.get(i)==list.get(end)){
        //         return false;
        //     }
        // }
        
        return true;
    }
    
    public void swap(ArrayList<Integer> list, int first, int sec){
        int temp = list.get(first);
        list.set(first, list.get(sec));
        list.set(sec, temp);
    }
    
}

