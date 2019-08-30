package OF_2019;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 已知一个字符串数组words，要求寻找其中两个没有重复字符的字符串，使得这两个字符串的长度乘积最大，输出这个最大的乘积。如：
 * words=["abcd","wxyh","defgh"], 其中不包含重复字符的两个字符串是"abcd"和"wxyh"，则输出16
 * words=["a","aa","aaa","aaaa"], 找不到满足要求的两个字符串，则输出0
 *
 * 输入描述:
 * Input:
 * ["a","ab","abc","cd","bcd","abcd"]
 *
 * 输出描述:
 * Output:
 * 4
 *
 * ["a","ab","abc","cd","bcd","abcd"]
 *
 * 4
 */
public class Main_33 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String in = sc.nextLine();

        if(in.length() == 2) {
            System.out.println(0);
            return;
        }

        String[] ins = in.substring(1, in.length() - 2).split(",");

        ins = Arrays.stream(ins)
                .map(s -> s.replaceAll("\"", ""))
                .filter(s -> !"".equals(s) && s != null)
                .sorted((s1, s2) -> s2.length() - s1.length())
                .map(s -> {
                        char[] tmps = s.toCharArray();
                        Arrays.sort(tmps);
                        return String.valueOf(tmps);
                    }).toArray(String[] :: new);

        int max = 0;
        for(int i = 0 ; i < ins.length ; i++) {
            for(int x = i + 1 ; x <ins.length ; x++) {
                char iFirst = ins[i].charAt(0);
                char iEnd = ins[i].charAt(ins[i].length() - 1);
                char xFirst = ins[x].charAt(0);
                char xEnd = ins[x].charAt(ins[x].length() - 1);
                if(xEnd < iFirst || iEnd < xFirst) {
                    int tmp = ins[i].length() * ins[x].length();
                    if(max < tmp) {
                        max = tmp;
                    }
                    break;
                }
            }
        }

        System.out.println(max);
    }
}
