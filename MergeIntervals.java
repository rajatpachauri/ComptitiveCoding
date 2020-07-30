/*
Merge Intervals

Problem Description

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.



Problem Constraints

1 <= |intervals| <= 105


Input Format

First argument is the vector of intervals

second argument is the new interval to be merged



Output Format

Return the vector of intervals after merging


Example Input

Input 1:

Given intervals [1, 3], [6, 9] insert and merge [2, 5] .

Input 2:

Given intervals [1, 3], [6, 9] insert and merge [2, 6] .



Example Output

Output 1:

 [ [1, 5], [6, 9] ]

Output 2:

 [ [1, 9] ]



Example Explanation

Explanation 1:

(2,6) does not completely merge the given intervals

Explanation 2:

(2,6) completely merges the given intervals

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


/*
Solution Approach

Have you covered the following corner cases :

1) Size of interval array as 0.

2) newInterval being an interval preceding all intervals in the array.

    Given interval (3,6),(8,10), insert and merge (1,2)

3) newInterval being an interval succeeding all intervals in the array.

    Given interval (1,2), (3,6), insert and merge (8,10)

4) newInterval not overlapping with any interval and falling in between 2 intervals in the array.

    Given interval (1,2), (8,10) insert and merge (3,6) 

5) newInterval covering all given intervals.

    Given interval (3, 5), (7, 9) insert and merge (1, 10)

*/

public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> list, Interval elem) {
        elem = new Interval(Integer.min(elem.start, elem.end), Integer.max(elem.start, elem.end));
        Deque<Interval> dq = new LinkedList<>();
        boolean isAdded = false;
        for(int i=0;i<list.size();i++){
            if(!isAdded){
                if(list.get(i).start>=elem.start){
                    addElemStack(dq, elem);
                    addElemStack(dq, list.get(i));
                }
                else{
                    dq.addLast(list.get(i));
                }
                isAdded = true;
            }
            else{
                addElemStack(dq, list.get(i));
            }
        }
        if(!isAdded){
            if(dq.size()>0)
                addElemStack(dq, elem);
            else
                dq.add(elem);    
        }
        ArrayList<Interval> res = new ArrayList<>();
        while(dq.size()>0){
            res.add(dq.removeFirst());
        }
        
        return res;
    }
    
    public void addElemStack(Deque<Interval> dq, Interval elem){
        if(dq.size()>0 && dq.peekLast().end>=elem.start){
            Interval temp = dq.removeLast();
            dq.addLast(new Interval(Integer.min(temp.start, elem.start), Integer.max(temp.end, elem.end)));
        }
        else{
            dq.addLast(elem);
        }
    }

}

