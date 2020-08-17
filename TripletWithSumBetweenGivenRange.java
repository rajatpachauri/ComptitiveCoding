/*
Triplets with Sum between given range

Given an array of real numbers greater than zero in form of strings. Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 . Return 1 for true or 0 for false.

Example:

Given [0.6, 0.7, 0.8, 1.2, 0.4] ,

You should return 1

as

0.6+0.7+0.4=1.7

1<1.7<2

Hence, the output is 1.

O(n) solution is expected.

Note: You can assume the numbers in strings don't overflow the primitive data type and there are no leading zeroes in numbers. Extra memory usage is allowed.

*/

/*
Solution Approach

Start tackling this problem by thinking of kinds of numbers that could be members of potential solutions. Think about what range those numbers could have. From this, these are the few scenarios under which a valid triplet could exist.

We have natural boundaries at 0, 1, and 2. So that leads to a few scenarios. Suppose we let A=(0,1] and we let B=(1,2). Then, any number in a potential solution must come from either range A or range B.

That leaves us with four unique combinations:

1.A, A, A
2.A, A, B
3.A, B, B
4.B, B, B

We can quickly deduce that case 3 and case 4 are not possible. The minimum value for range B is a little bit more than 1. If we have two numbers that are a little bit more than 1, then our total sum will be a little bit more than 2. Say the numbers are 0.4, 1.0001 and 1.0001. Here sum is greater than 2. Hence, these cases won’t give us the required solution. Thus we can eliminate cases 3,4 and 5 (as they contain at least 2 numbers from range B).

So then we only have to check cases 1 and 2. Unfortunately, checking these cases is a little difficult. How can we determine if there are three numbers less than or equal to 1 that add up to a value greater than 1 and less than 2?

Maybe we can tighten the restrictions on case 1 to make it easier to solve. What if we knew that every number in range A was less than 2/3? Then we could just select the three highest values in A. If those three numbers exist and add up to a value in the range (1,2), then case 1 is fulfilled. Example- Let highest numbers in A be 0.333,0.55,0.44. These three numbers lies in the required range(1,2) and hence would give us the solution.

Now, since we tightened the restriction in case 1, we need another case to cover when values are in the range [2/3,1].

Let us formally define our new ranges. Let A=(0,2/3), B=[2/3,1] and C=(1,2).
These new ranges leave us with ten unique combinations:

1.A, A, A
2.A, A, B
3.A, A, C
4.A, B, B
5.A, B, C
6.A, C, C
7.B, B, B
8.B, B, C
9.B, C, C
10.C, C, C

We can quickly deduce that cases 6, 7, 8, 9, and 10 are not possible (the total sum will always be greater than 2).

That leaves us with cases 1, 2, 3, 4, and 5.

We can check case 1 by looking at the three largest values in A. Say we have these highest values as : 0.500,0.6666,0.65777. This lies between 1 and 2. We only have to worry about underflow in this case, meaning the sum of highest values in this range may not be greater than 1. But we are sure that this will be less than 2. So we only have to check for the condition whether these are greater than 1 or not.

Now, what about case 2? Under case 2, we have two numbers in range A and one number in range B. We have to worry about underflow and overflow. To avoid underflow, let’s suppose that we select the two largest values in A. Let’s call the sum of those numbers s. The range of s will be (0,4/3). So we just need to determine if there is a value in B that is greater than 1−s and less than 2−s. Simple enough.

Under case 3, we have two numbers in range A and one number in range C. We just have to worry about overflow ( because to the presence of an integer from range C, we are sure that their sum will be greater than 1). To avoid overflow, let’s suppose that we select the two smallest values in A and the smallest value in C. If the sum of those numbers is in the range ((1,2), then this case has occurred.

Case 4 will be similar to case 2. Under case 4, we have one number in range A and two numbers in range B. We have to worry about overflow. To avoid overflow, let’s suppose that we select the two smallest values in BB. Let’s call the sum of those numbers s. The range of ss will be [4/3,2]. So we just need to determine if there is a value in A that is less than 2−s. Not bad.

Case 5 is pretty easy as well. We have to worry about overflow. To avoid overflow, let’s suppose that we select the smallest value in A, the smallest value in B, and the smallest value in C. If the sum of those numbers is in the range (1,2), then this case has occurred.

So, to solve the problem, we just check to see if case 1, 2, 3, 4, or 5 is satisfied. Each case can be checked in O(n) time.

We can conclude that for all the 5 possible cases, we just need 3 largest values in range A, 2 smallest in range B, 2 smallest in range A and the smallest in range C. There are a lot of methods, choose anyone to find them.

*/

public class Solution {
    private static double TWO_THIRDS = 2.0 / 3.0;
    private static Range rangeA = new Range(0, false, TWO_THIRDS, false);
    private static Range rangeB = new Range(TWO_THIRDS, true, 1, true);
    private static Range rangeC = new Range(1, false, 2, false);
    public static int check(double[] list) {
        double[] triplet = findTriplet(list);
        if (triplet == null) {
            return 0;
        } else {
           return 1;
        }
    }
    public static double[] findTriplet(double[] list) {
        int n = list.length;
        if (n < 3) {
            return null;
        }
        double[] case1 = caseOne(list);
        if (case1 != null) {
            return case1;
        }
        double[] case2 = caseTwo(list);
        if (case2 != null) {
            return case2;
        }
        double[] case3 = caseThree(list);
        if (case3 != null) {
            return case3;
        }
        double[] case4 = caseFour(list);
        if (case4 != null) {
            return case4;
        }
        double[] case5 = caseFive(list);
        if (case5 != null) {
            return case5;
        }
        return null;
    }
    private static double[] caseOne(double[] list) {
        double[] maximumA = getMaxesInRange(list, 3, rangeA);
        if (maximumA == null) {
            return null;
        }
        double sum = maximumA[0] + maximumA[1] + maximumA[2];
        boolean inRange = numInRange(sum, rangeC);
        if (!inRange) {
            return null;
        }
        return new double[] { maximumA[0], maximumA[1], maximumA[2] };
    }
    private static double[] caseTwo(double[] list) {
        double[] maximumA = getMaxesInRange(list, 2, rangeA);
        if (maximumA == null) {
            return null;
        }
        double sum = maximumA[0] + maximumA[1];
        int n = list.length;
        for (int i = 0; i < n; i++) {
            boolean inRange = numInRange(list[i], rangeB);
            if (inRange && list[i] > 1 - sum && list[i] < 2 - sum) {
                return new double[] { maximumA[0], maximumA[1], list[i] };
            }
        }
        return null;
    }
    private static double[] caseThree(double[] list) {
        double[] minimumA = getMinsInRange(list, 2, rangeA);
        if (minimumA == null) {
            return null;
        }
        double[] minimumC = getMinsInRange(list, 1, rangeC);
        if (minimumC == null) {
            return null;
        }
        double sum = minimumA[0] + minimumA[1] + minimumC[0];
        boolean inRange = numInRange(sum, rangeC);
        if (!inRange) {
            return null;
        }
        return new double[] { minimumA[0], minimumA[1], minimumC[0] };
    }
    private static double[] caseFour(double[] list) {
        double[] minimumB = getMinsInRange(list, 2, rangeB);
        if (minimumB == null) {
            return null;
        }
        double sum = minimumB[0] + minimumB[1];
        int n = list.length;
        for (int i = 0; i < n; i++) {
            boolean inRange = numInRange(list[i], rangeA);
            if (inRange && list[i] < 2 - sum) {
                return new double[] { minimumB[0], minimumB[1], list[i] };
            }
        }
        return null;
    }
     private static double[] caseFive(double[] list) {
        double[] minimumA = getMinsInRange(list, 1, rangeA);
        if (minimumA == null) {
            return null;
        }
        double[] minimumB = getMinsInRange(list, 1, rangeB);
        if (minimumB == null) {
            return null;
        }
        double[] minimumC = getMinsInRange(list, 1, rangeC);
        if (minimumC == null) {
            return null;
        }
        double sum = minimumA[0] + minimumB[0] + minimumC[0];
        boolean inRange = numInRange(sum, rangeC);
        if (!inRange) {
            return null;
        }
        return new double[] { minimumA[0], minimumB[0], minimumC[0] };
    }
    private static double[] getMinsInRange(double[] list, int numMins, Range range) {
        int n = list.length;
        double[] mins = new double[numMins];
        double[] minIndices = new double[numMins];
        for (int i = 0; i < numMins; i++) {
            mins[i] = -1;
            minIndices[i] = -1;
            for (int j = 0; j < n; j++) {
                boolean inRange = numInRange(list[j], range);
                if ((list[j] <= mins[i] || minIndices[i] == -1) && inRange) {
                    boolean good = true;
                    for (int k = 0; k < i; k++) {
                        if (j == minIndices[k]) {
                            good = false;
                            break;
                        }
                    }
                    if (good) {
                        mins[i] = list[j];
                        minIndices[i] = j;
                    }
                }
            }
            if (minIndices[i] == -1) {
                return null;
            }
        }
        return mins;
    }
    private static double[] getMaxesInRange(double[] list, int numMaxes, Range range) {
        int n = list.length;
        double[] maxes = new double[numMaxes];
        double[] maxIndices = new double[numMaxes];
        for (int i = 0; i < numMaxes; i++) {
            maxes[i] = -1;
            maxIndices[i] = -1;
            for (int j = 0; j < n; j++) {
                boolean inRange = numInRange(list[j], range);
                if ((list[j] >= maxes[i] || maxIndices[i] == -1) && inRange) {
                    boolean good = true;
                    for (int k = 0; k < i; k++) {
                        if (j == maxIndices[k]) {
                            good = false;
                            break;
                        }
                    }
                    if (good) {
                        maxes[i] = list[j];
                        maxIndices[i] = j;
                    }
                }
            }
            if (maxIndices[i] == -1) {
                return null;
            }
        }
        return maxes;
    }
    private static boolean numInRange(double num, Range range) {
        boolean inRange = true;
        if (range.lowerInclusive) {
            inRange &= (num >= range.lowerBound);
        } else {
            inRange &= (num > range.lowerBound);
        }
        if (range.upperInclusive) {
            inRange &= (num <= range.upperBound);
        } else {
            inRange &= (num < range.upperBound);
        }
        return inRange;
    }
    private static class Range {
        public double lowerBound;
        public boolean lowerInclusive;
        public double upperBound;
        public boolean upperInclusive;
        public Range(double lowerBound, boolean lowerInclusive, double upperBound, boolean upperInclusive) {
            this.lowerBound = lowerBound;
            this.lowerInclusive = lowerInclusive;
            this.upperBound = upperBound;
            this.upperInclusive = upperInclusive;
        }
    }


    public int solve(ArrayList<String> A) {
        double b[]=new double[A.size()];
    int i=0;
        for(String x:A){
            b[i++]=Double.parseDouble(x);
        }
        return Solution.check(b);
        
    }
}

/*
public class Solution {
    public int solve(String[] A) {
        float a = Float.parseFloat(A[0]);
        float b = Float.parseFloat(A[1]);
        float c = Float.parseFloat(A[2]);
        for(int i=3;i<A.length;i++){
            if(1<a+b+c && a+b+c<2){
                return 1;
            }
            if(a+b+c>=2){
                if(a>b && a>c){
                    a = Float.parseFloat(A[i]);
                }
                else if(b>c){
                    b = Float.parseFloat(A[i]);
                }
                else{
                    c = Float.parseFloat(A[i]);
                }
            }
            else{
                if(a<b && a<c){
                    a = Float.parseFloat(A[i]);
                }
                else if(b<c){
                    b = Float.parseFloat(A[i]);
                }
                else{
                    c = Float.parseFloat(A[i]);
                }
            }
        }
        
        if((a+b+c) > 1 && (a+b+c) < 2){
            return 1;
        }
        return 0;
    }
}
*/
