/*
Palindrome Partitioning

Problem Description

Given a string A, partition A such that every string of the partition is a palindrome.

Return all possible palindrome partitioning of A.

Ordering the results in the answer : Entry i will come before Entry j if :

    len(Entryi[0]) < len(Entryj[0]) OR
    (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR * * *
    (len(Entryi[0]) == len(Entryj[0]) AND ... len(Entryi[k] < len(Entryj[k]))



Problem Constraints

1 <= len(A) <= 15


Input Format

First argument is a string A of lowercase characters.


Output Format

Return a list of all possible palindrome partitioning of s.


Example Input

Input 1:

A = "aab"

Input 2:

A = "a"



Example Output

Output 1:

 [
    ["a","a","b"]
    ["aa","b"],
  ]

Output 2:

 [
    ["a"]
  ]



Example Explanation

Explanation 1:

In the given example, ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa").

Explanation 2:

In the given example, only partition possible is "a" .
*/

public class Solution {
	public ArrayList<ArrayList<String>> partition(String a) {
	    ArrayList<ArrayList<String>> res = new ArrayList<>();
	    genPalString(res, new ArrayList<>(), a, 0);
	    return res;
	}
	
	public void genPalString(ArrayList<ArrayList<String>> res, ArrayList<String> list, String a, int index){
	    if(index==a.length()){
	        res.add(new ArrayList<>(list));
	        return;
	    }
	    for(int i=index;i<a.length();i++){
	        if(isPalindrome(a, index,i)){
	            list.add(a.substring(index, i+1));
	            genPalString(res, list, a, i+1);
	            list.remove(list.size()-1);
	        }
	    }
	}
	
	public boolean isPalindrome(String s, int start, int end){
	    int j=0;
	    for(int i=start;i<=(start+end)/2;i++){
	        if(s.charAt(i)!=s.charAt(end-j)){
	            return false;
	        }
	        j++;
	    }
	    
	    return true;
	}
	
}

