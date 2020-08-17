/*
Letter Phone

Problem Description

Given a digit string A, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.

NOTE: Make sure the returned strings are lexicographically sorted.



Problem Constraints

1 <= |A| <= 10


Input Format

The only argument is a digit string A.


Output Format

Return a string array denoting the possible letter combinations.


Example Input

Input 1:

 A = "23"

Input 2:

 A = "012"



Example Output

Output 1:

 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

Output 2:

 ["01a", "01b", "01c"]



Example Explanation

Explanation 1:

 There are 9 possible letter combinations.

Explanation 2:

 Only 3 possible letter combinations.
*/

/*

Solution Approach

Think  of recursion. 

Think about possibilites at any place and move on.

For every integer, you have 1 or 3 or 4 options. Try appending every letter in the option to the string and move forward.
For digit 0 and 1: there is only one possibility.
For digit 7 and 9: there are 4 possibility.
For all others: there are 3 possibility.

Note that the string array should be lexicographically sorted.

*/

public class Solution {
    public ArrayList<String> letterCombinations(String A) {
        ArrayList<String> res = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        genMap(map);
        genComb(res, map, A, 0,"");
        return res;
    }
    
    public void genComb(ArrayList<String> res, HashMap<Integer, String> map, String s, int index, String path){
        if(index==s.length()){
            res.add(path);
            return;
        }
        String temp = map.get(Character.getNumericValue(s.charAt(index)));
        // System.out.println(temp);
        for(int i=0;i<temp.length();i++){
            genComb(res, map, s, index+1, path+(temp.charAt(i)));
        }
    }
    
    public void genMap(HashMap<Integer, String> map){
        map.put(1, "1");
        map.put(0, "0");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }
}

