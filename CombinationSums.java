/*
Combination Sum

Problem Description

Given a set of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.

The same repeated number may be chosen from A unlimited number of times.

Note:

1) All numbers (including target) will be positive integers.

2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).

3) The combinations themselves must be sorted in ascending order.

4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)

5) The solution set must not contain duplicate combinations.



Problem Constraints

1 <= |A| <= 20

1 <= A[i] <= 50

1 <= B <= 500



Input Format

First argument is the vector A.

Second argument is the integer B.



Output Format

Return a vector of all combinations that sum up to B.


Example Input

Input 1:

A = [2, 3]
B = 2

Input 2:

A = [2, 3, 6, 7]
B = 7



Example Output

Output 1:

[ [2] ]

Output 2:

[ [2, 2, 3] , [7] ]



Example Explanation

Explanation 1:

All possible combinations are listed.

Explanation 2:

All possible combinations are listed.

*/

/*
Solution Approach

In every recursion run, you either include the element in the combination or you don’t.
To account for multiple occurrences of an element, make sure you call the next function without
incrementing the current index.
something like :
void doWork(vector &candidates, int index, vector &current, int currentSum, int target, vector<vector > &ans) { if (currentSum > target) { return; } if (currentSum == target) { ans.push_back(current); return; } for (int i = index; i < candidates.size(); i++) { current.push_back(candidates[i]); currentSum += candidates[i];

    doWork(candidates, i, current, currentSum, target, ans);
    
    current.pop_back();
    currentSum -= candidates[i];
}

}

*/

public class Solution {
    
    ArrayList<ArrayList<Integer>> res;
    
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        res = new ArrayList<>();
        getCombinationSum(A, B, 0,new ArrayList<>());
        return res;
    }
    
    public void getCombinationSum(ArrayList<Integer> list, int target, int start, ArrayList<Integer> ans){
        if(target==0){
            res.add(new ArrayList<>(ans));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=start;i<list.size();i++){
            if(i>0 && list.get(i)==list.get(i-1))
                continue;
            ans.add(list.get(i));
            getCombinationSum(list, target-list.get(i), i, ans);
            ans.remove(ans.size()-1);
        }
    }
    
}

