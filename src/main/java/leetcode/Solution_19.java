package leetcode;

import java.util.ArrayList;

/**
 * 题目描述
 * 给定一个字符串s，分割s使得s的每一个子串都是回文串
 * 返回所有的回文分割结果
 * 例如:给定字符串s="aab",
 * 返回
 *   [
 *      ["aa","b"],
 *      ["a","a","b"]
 *   ]
 *
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s ="aab",
 * Return
 *
 *   [
 *      ["aa","b"],
 *      ["a","a","b"]
 *   ]
 */
public class Solution_19 {

//    public ArrayList<ArrayList<String>> partition(String s) {
//
//        return null;
//    }

    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (s == null || s.length() == 0) {
            return res;
        }

        solve(s, 0, new ArrayList<String>(), res);
        return res;
    }

    private void solve(String s, int index, ArrayList<String> preList, ArrayList<ArrayList<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<String>(preList));
            return;
        }
        ArrayList<String> list = new ArrayList<String>(preList);
        for (int i = index + 1 ; i <= s.length() ; i++) {
            if (isPalindrom(s.substring(index, i))) {
                list.add(s.substring(index, i));
                solve(s, i, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrom(String s) {
        if (s == null)
            return false;

        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_19 solution = new Solution_19();
        ArrayList<ArrayList<String>> res = solution.partition("acac");
        System.out.println(res);
    }
}
