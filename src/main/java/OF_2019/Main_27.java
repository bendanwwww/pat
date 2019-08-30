package OF_2019;


import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 题目描述
 * 我们定义字符串包含关系：字符串A=abc，字符串B=ab，字符串C=ac，则说A包含B，A和C没有包含关系。
 *
 * 输入描述:
 * 两个字符串，判断这个两个字符串是否具有包含关系，测试数据有多组，请用循环读入。
 *
 * 输出描述:
 * 如果包含输出1，否则输出0.
 *
 * abc ab
 *
 * 1
 */
public class Main_27 {

    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            String[] s = str.split(" ");
            System.out.println((s[0].length() > s[1].length() ? s[0].contains(s[1]) : s[1].contains(s[0])) ? 1 : 0);
        }
    }
}
