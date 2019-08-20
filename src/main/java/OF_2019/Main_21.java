package OF_2019;


import java.util.Scanner;

/**
 * 题目描述
 *
 * 通过键盘输入一串小写字母(a~z)组成的字符串。
 * 请编写一个字符串归一化程序，统计字符串中相同字符出现的次数，并按字典序输出字符及其出现次数。
 * 例如字符串"babcc"归一化后为"a1b2c2"
 *
 * 输入描述:
 * 每个测试用例每行为一个字符串，以'\n'结尾，例如cccddecca
 *
 * 输出描述:
 * 输出压缩后的字符串ac5d2e
 *
 * dabcab
 *
 * a2b2c1d1
 */
public class Main_21 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] inputs = sc.nextLine().toCharArray();

        int[] letterNumber = new int[26];

        for(char c : inputs) {
            letterNumber[(int) c - 97]++;
        }

        String ouput = "";
        for(int i = 0 ; i < letterNumber.length ; i++) {
            if(letterNumber[i] > 0) {
                ouput = ouput + String.valueOf((char) (i + 97)) + letterNumber[i];
            }
        }

        System.out.println(ouput);
    }
}
