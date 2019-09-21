package leetcode;

import java.util.ArrayList;

/**
 *
 */
public class Solution_19_test {

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
            list.add(s.substring(index, i));
            solve(s, i, list, res);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        Solution_19_test solution = new Solution_19_test();
        ArrayList<ArrayList<String>> res = solution.partition("acac");
        System.out.println(res);
    }
}
