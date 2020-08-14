/*
Subset

Problem Description

Given a set of distinct integers, A, return all possible subsets.

NOTE:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
    Also, the subsets should be sorted in ascending ( lexicographic ) order.
    The list is not necessarily sorted. 



Problem Constraints
1 <= |A| <= 16
INTMIN <= A[i] <= INTMAX


Input Format

First and only argument of input contains a single integer array A.


Output Format

Return a vector of vectors denoting the answer.


Example Input

Input 1:

A = [1]

Input 2:

A = [1, 2, 3]



Example Output

Output 1:

[
    []
    [1]
]

Output 2:

[
 []
 [1]
 [1, 2]
 [1, 2, 3]
 [1, 3]
 [2]
 [2, 3]
 [3]
]



Example Explanation

Explanation 1:

 You can see that these are all possible subsets.

Explanation 2:

You can see that these are all possible subsets.
*/

/*
Solution Approach

For every element, you have 2 options.

You may either include the element in your subset or you will not include the element in your subset.

Make the call for both the cases.
Remember to include base case to avoid infinite calling.

Can you also do it iteratively?
Hint: You can use the fact that each number from 0 to 2N - 1, represent each subset of N elements.
*/

public class Solution {
    
    ArrayList<ArrayList<Integer>> res;
    
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        res = new ArrayList<>();
        genSubset(A, 0, new ArrayList<>());
        return res;
    }
    
    public void genSubset(ArrayList<Integer> list, int start, ArrayList<Integer> ans){
        
        res.add(new ArrayList<>(ans));
        
        for(int i=start;i<list.size();i++){
            ans.add(list.get(i));
            genSubset(list, i+1, ans);
            ans.remove(ans.size()-1);
        }
    }
    
}

