package OF_2019;


import java.util.Scanner;

/**
 * 题目描述
 * 牛牛去犇犇老师家补课，出门的时候面向北方，但是现在他迷路了。虽然他手里有一张地图，但是他需要知道自己面向哪个方向，请你帮帮他。
 *
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个正整数，表示转方向的次数N(N<=1000)。
 * 接下来的一行包含一个长度为N的字符串，由L和R组成，L表示向左转，R表示向右转。
 *
 * 输出描述:
 * 输出牛牛最后面向的方向，N表示北，S表示南，E表示东，W表示西。
 *
 * 3
 * LRR
 *
 * E
 *
 */
public class Main_04 {

    public static void main(String[] args) {
        String[] direction = {"N", "E", "S", "W"};
        int initDirection = 0;

        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        char[] turn = sc.nextLine().toCharArray();

        for(char t : turn){
            if(t == 'R') {
                if(initDirection == 3){
                    initDirection = 0;
                }else{
                    initDirection++;
                }
            }else{
                if(initDirection == 0){
                    initDirection = 3;
                }else{
                    initDirection--;
                }
            }
        }

        System.out.println(direction[initDirection]);
    }
}
