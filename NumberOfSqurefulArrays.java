/*
Number of Squareful Arrays

Problem Description

Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.

Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].



Problem Constraints

1 <= length of the array <= 12

1 <= A[i] <= 109



Input Format

The only argument given is the integer array A.


Output Format

Return the number of permutations of A that are squareful.


Example Input

Input 1:

 A = [2, 2, 2]

Input 2:

 A = [1, 17, 8]



Example Output

Output 1:

 1

Output 2:

 2



Example Explanation

Explanation 1:

 Only permutation is [2, 2, 2], the sum of adjacent element is 4 and 4 and both are perfect square.

Explanation 2:

 Permutation are [1, 8, 17] and [17, 8, 1].
*/

/*
Solution Approach

Construct a graph where an edge from i to j exists if A[i] + A[j] is a perfect square.

Our goal is to investigate Hamiltonian paths of this graph: paths that visit all the nodes exactly once.

Let’s keep a current count of what values of nodes are left to visit, and a count todo of how many nodes left to visit.

From each node, we can explore all neighboring nodes (by value, which reduces the complexity).
*/

public class Solution {
    
    Map<Integer, Integer> count;
    Map<Integer, List<Integer>> graph;
    public int solve(int[] A) {
        int N = A.length;
        if(N==1){
            int i = (int)Math.sqrt(A[0]);
            if(i*i==A[0]){
                return 1;
            }
            else return 0;
        }
        count = new HashMap();
        graph = new HashMap();

        // count.get(v) : number of v's in A
        for (int x: A)
            count.put(x, count.getOrDefault(x, 0) + 1);

        // graph.get(v) : values w in A for which v + w is a square
        //                (ie., "vw" is an edge)
        for (int x: count.keySet())
            graph.put(x, new ArrayList());

        for (int x: count.keySet())
            for (int y: count.keySet()) {
                int r = (int) (Math.sqrt(x + y) + 0.5);
                if (r * r == x + y)
                    graph.get(x).add(y);
            }

        // Add the number of paths that start at x, for all possible x
        int ans = 0;
        for (int x: count.keySet())
            ans += dfs(x, N - 1);
        return ans;
    }

    public int dfs(int x, int todo) {
        count.put(x, count.get(x) - 1);
        int ans = 1;  // default if todo == 0
        if (todo != 0) {
            ans = 0;
            for (int y: graph.get(x)) if (count.get(y) != 0) {
                ans += dfs(y, todo - 1);
            }
        }
        count.put(x, count.get(x) + 1);
        return ans;
    }
}

