/*
Find Squares

You are given an integer N, you are supposed to convert it to a positive square by performing some steps.

A step is defined as: Remove any digit present in the number N, so that the number remains a positive integer without leading zeroes.

Return the minimum number of steps needed to convert a number to a positive square. If it is not possible to make a positive square by repeatedly performing steps, return -1.

Constraints:

1 <= N <= 2*10^9

Input:

N : An Integer without any leading zeroes.

Output:

Minimum number of steps needed to convert N to a perfect positive square. If not possible, return -1.

Example:

Input: 
309

Output:
2

Here, removing 2 digits, second and then first (0 and 3), makes N a perfect positive square (9).


Input: 
36

Output:
0

36 is already a perfect positive square, no need of removing any digits.

Input: 
87

Output:
-1

It isn't possible to make a perfect positive square through any combination of steps, hence -1.
*/

/*
Solution Approach

Looking at the constraints of the problem, the maximum number of digits N can have is 10. All possible combinations of choosing digits from N digits is 2^N.
For N = 10 we have, 2^10 = 1024, hence we can generate and test 1024 different numbers and find the minimum number of digits to be excluded to make a perfect positive square.

** Algorithm **

    Convert N to a string and generate all subsets(possible digit combinations) of N by method of bit-masking.
    For each combination, make sure it does not contain leading zeroes.
    Check whether acquired number is a perfect square, if it is, find the number of deletions needed to make that number.
    Return minimum deletions needed if exists, else return -1.

*/


public class Solution {
    public int answer,flag,min; 
    
    public int solve(int A) { 
        answer=-1; 
        flag=0; 
        min=Integer.MAX_VALUE; 
        ArrayList<Integer> arr=new ArrayList<>(); 
        
        while(A>0){ 
            arr.add(A%10); A=A/10; 
        } 
        
        Collections.reverse(arr); 
        ArrayList<Integer> temp=new ArrayList<>(arr.size()); 
        for(int i=0;i<arr.size();i++) 
            temp.add(0); 
        
        generateSequence(arr,temp,0); 
        
        if(min==Integer.MAX_VALUE) 
            return -1; 
            
        return min; 
        
    }

    public void generateSequence(ArrayList<Integer> arr,ArrayList<Integer> temp,int index){
        if(index==arr.size()){
            String result="";
            for(int i=0;i<temp.size();i++){
                if(temp.get(i)!=0){
                    result=result+arr.get(i);
                }
            }
            // System.out.println("generated sequence is"+result);
            if(result.length()==0) return;
            int ans=Integer.parseInt(result);
            if(ans == 0) return ;
            int len = 0;
            int num = ans;
            while(num > 0){
                len++;
                num /= 10;
            }
            int ans1=(int)Math.sqrt(ans);
            if(ans1*ans1==ans){
                // System.out.println(ans + " " + ans1);
               // if(flag==0){
                answer= arr.size()-len;
                  //  flag=1;
                 // System.out.println("here");
                  if(min>answer)
                    min=answer;
                return ;
            }
            return;
        }
        temp.set(index,1);
        generateSequence(arr,temp,index+1);
        temp.set(index,0);
        generateSequence(arr,temp,index+1);
    
    }

}
