/*
Merge Overlapping Intervals

Problem Description

Given a collection of intervals, merge all overlapping intervals.


Problem Constraints

1 <= Total number of intervals <= 100000.


Input Format

First argument is a list of intervals.


Output Format

Return the sorted list of intervals after merging all the overlapping intervals.


Example Input

Input 1:

[1,3],[2,6],[8,10],[15,18]



Example Output

Output 1:

[1,6],[8,10],[15,18]



Example Explanation

Explanation 1:

Merge intervals [1,3] and [2,6] -> [1,6].
so, the required answer after merging is [1,6],[8,10],[15,18].
No more overlapping intervals present.
*/

/*
Solution Approach

Given all the intervals, you need to figure out the sequence of intervals which intersect.

Lets see how we check if interval 1 (a,b) intersects with interval 2 (c,d):

Overlap case :

a---------------------b          OR             a------b
            c-------------------d           c------------------d

Non overlap case :

a--------------------b   c------------------d

If max(a,c) > min(b,d), then the intervals do not overlap. Otherwise, they overlap.

NOTE: Do you think it will be easier to solve if you could sort the intervals based on the starting point?

*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Comparator<Interval> cmp = new Comparator<Interval>(){
            @Override
            public int compare(Interval first, Interval second){
                if(first.start==second.start){
                    return first.end-second.end;
                }
                return first.start-second.start;
            }
        };
        Collections.sort(intervals, cmp);
        ArrayList<Interval> res = new ArrayList<>();
        for(Interval i:intervals){
            if(!res.isEmpty() && res.get(res.size()-1).end>=i.start){
                int index = res.size()-1;
                if(res.get(index).start==i.start && res.get(index).end<=i.end){
                    res.remove(res.size()-1);
                    res.add(i);
                }
                else if(res.get(index).start<i.start && res.get(index).end<i.end){
                    res.get(index).end = i.end;
                }
                
            }
            else{
                res.add(i);
            }
        }
        
        return res;
    }
}

