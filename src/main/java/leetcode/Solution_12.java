package leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 给定一个字符串s和一组单词dict，判断s是否可以用空格分割成一个单词序列，使得单词序列中所有的单词都是dict中的单词（序列可以包含一个或多个单词）。
 * 例如:
 * 给定s=“leetcode”；
 * dict=["leet", "code"].
 * 返回true，因为"leetcode"可以被分割成"leet code".
 *
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s ="leetcode",
 * dict =["leet", "code"].
 *
 * Return true because"leetcode"can be segmented as"leet code".
 */
public class Solution_12 {

    public boolean wordBreak(String s, Set<String> dict) {

        int len = s.length();
        // dp[i]表示0到i位可分
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        Solution_12 solution = new Solution_12();
        boolean res = solution.wordBreak("leetscode", Arrays.stream(new String[]{"leet", "s", "code"}).collect(Collectors.toSet()));
        System.out.println(res);
    }
}
