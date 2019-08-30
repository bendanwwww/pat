package OF_2019;


import java.util.Scanner;

/**
 * 题目描述
 * 对字符串进行RLE压缩，将相邻的相同字符，用计数值和字符值来代替。例如：aaabccccccddeee，则可用3a1b6c2d3e来代替。
 *
 * 输入描述:
 * 输入为a-z,A-Z的字符串，且字符串不为空，如aaabccccccddeee
 *
 * 输出描述:
 * 压缩后的字符串，如3a1b6c2d3e
 *
 * aaabccccccdd
 *
 * 3a1b6c2d
 */
public class Main_30 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] ins = sc.nextLine().toCharArray();

        if(ins.length == 1){
            System.out.println(1 + String.valueOf(ins[0]));
            return;
        }

        String out = "";

        char lastChar = ins[0];
        int size = 1;

        for(int i = 1 ; i < ins.length ; i++) {
            if(lastChar == ins[i]) {
                size++;
                if(i == ins.length - 1) {
                    out = out + size + lastChar;
                }
            }else{
                out = out + size + lastChar;
                lastChar = ins[i];
                size = 1;
                if(i == ins.length - 1) {
                    out = out + size + lastChar;
                }
            }
        }

        System.out.println(out);
    }
}
