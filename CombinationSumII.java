/*
Combination Sum II

Problem Description

Given an array of size N of candidate numbers A and a target number B. Return all unique combinations in A where the candidate numbers sums to B.

Each number in A may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.

Warning:

DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.

Example : itertools.combinations in python. If you do, we will disqualify your submission and give you penalty points.



Problem Constraints

1 <= N <= 20


Input Format

First argument is an integer array A denoting the collection of candidate numbers.
Second argument is an integer which represents the target number.


Output Format

Return all unique combinations in A where the candidate numbers sums to B.


Example Input

Input 1:

 A = [10, 1, 2, 7, 6, 1, 5]
 B = 8

Input 2:

 A = [2, 1, 3]
 B = 3



Example Output

Output 1:

 [ 
  [1, 1, 6 ],
  [1, 2, 5 ],
  [1, 7 ], 
  [2, 6 ] 
 ]

Output 2:

 [
  [1, 2 ],
  [3 ]
 ]



Example Explanation

Explanation 1:

 1 + 1 + 6 = 8
 1 + 2 + 5 = 8
 1 + 7 = 8
 2 + 6 = 8
 All the above combinations sum to 8 and are arranged in ascending order.

Explanation 2:

 1 + 2 = 3
 3 = 3
 All the above combinations sum to 3 and are arranged in ascending order.
*/

/*
Solution Approach

Some elements can be repeated in the input set.
Make sure you iterate over the number of occurrences of those elements to make sure you are not counting the same combinations again.

Once you do that, things are fairly straightforward. Backtracking is the solution here.
You make a recursive call with the remaining sum and make sure the indices are moving forward.
*/

public class Solution {
	ArrayList<ArrayList<Integer>> res;
    
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        res = new ArrayList<>();
        getCombinationSum(A, B, 0,new ArrayList<>());
        return res;
    }
    
    private void getCombinationSum(ArrayList<Integer> nums, int remain, int start, ArrayList<Integer> tempList){
        if(remain < 0) return;
        else if(remain == 0) res.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.size(); i++){
                if(i > start && nums.get(i) == nums.get(i-1)) continue; // skip duplicates
                tempList.add(nums.get(i));
                getCombinationSum(nums, remain - nums.get(i), i + 1, tempList);
                tempList.remove(tempList.size() - 1); 
            }
        }
    }
}

