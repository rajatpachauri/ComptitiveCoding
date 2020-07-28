/*
Maximum Consecutive Gap

Problem Description

Given an unsorted integer array A of size N.
Find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

    You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
    You may also assume that the difference will not overflow.

Return 0 if the array contains less than 2 elements.



Problem Constraints

1 <= N <= 106

1 <= A[i] <= 109



Input Format

First argument is an integer array A of size N.


Output Format

Return an integer denoting the maximum difference.


Example Input

Input 1:

 A = [1, 10, 5]

Input 2:

 A = [10, 9, 10]



Example Output

Output 1:

 5

Output 2:

 1



Example Explanation

Explanation 1:

 After sorting, the array becomes [1, 5, 10]
 Maximum difference is (10 - 5) = 5.

Explanation 2:

 Maximum difference is (10 - 9) = 1.
*/

/*
Now, first try to think if you were already given the minimum value MIN and maximum value MAX in the array of size N, under what circumstances would the max gap be minimum and maximum ?

Obviously, maximum gap will be maximum when all elements are either MIN or MAX making maxgap = MAX - MIN.

Maximum gap will be minimum when all the elements are equally spaced apart between MIN and MAX. Lets say the spacing between them is gap.

So, they are arranged as

MIN, MIN + gap, MIN + 2*gap, MIN + 3*gap, ... MIN + (N-1)*gap 

where

MIN + (N-1)*gap = MAX 
=> gap = (MAX - MIN) / (N - 1). 

So, we know now that our answer will lie in the range [gap, MAX - MIN].
Now, if we know the answer is more than gap, what we do is create buckets of size gap for ranges

  [MIN, MIN + gap), [Min + gap, `MIN` + 2* gap) ... and so on

There will only be (N-1) such buckets. We place the numbers in these buckets based on their value.

If you pick any 2 numbers from a single bucket, their difference will be less than gap, and hence they would never contribute to maxgap ( Remember maxgap >= gap ). We only need to store the largest number and the smallest number in each bucket, and we only look at the numbers across bucket.

Now, we just need to go through the bucket sequentially ( they are already sorted by value ), and get the difference of min_value with max_value of previous bucket with at least one value. We take maximum of all such values.
*/


public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maximumGap(final int[] A) {
        if(A.length<2){
            return 0;
        }
        
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++){
            max = Integer.max(max, A[i]);
            min = Integer.min(min, A[i]);
        }
         
        int gap = (max - min - 1) / (A.length - 1) + 1;
        
        int[] minArr = new int[A.length];
        int[] maxArr = new int[A.length];
        int res = 0, maxValue = max;
        
        // System.out.println(gap);
        Arrays.fill(minArr, Integer.MAX_VALUE);
        Arrays.fill(maxArr, Integer.MIN_VALUE);
        
        for(int i=0;i<A.length;i++){
            
            if(A[i]==max || A[i]==min){
                continue;
            }
            
            int bucket = (A[i]-min)/gap;
            minArr[bucket] = Integer.min(A[i], minArr[bucket]);
            maxArr[bucket] = Integer.max(A[i], maxArr[bucket]);
        }
        // System.out.println(Arrays.toString(minArr));
        // System.out.println(Arrays.toString(maxArr));
        
        for(int i=0;i<minArr.length;i++){
            max = minArr[i];
            
            if(max!=Integer.MAX_VALUE){
                res = Integer.max(res, max-min);
            }
            if(maxArr[i]!=Integer.MIN_VALUE){
                min = maxArr[i];
            }
        }
        
        return Integer.max(res, maxValue-min);
    }
}

