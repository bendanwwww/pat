package OF_2019;


import java.util.Scanner;

/**
 * 题目描述
 * 小明在越南旅游，参加了当地的娱乐活动。小明运气很好，拿到了大奖， 到了最后的拿奖金环节。小明发现桌子上放着一列红包，每个红包上写着奖金数额。
 * 现在主持人给要求小明在这一列红包之间“切”2刀，将这一列红包“切”成3组，并且第一组的奖金之和等于最后一组奖金和（允许任意一组的红包集合是空）。最终第一组红包的奖金之和就是小明能拿到的总奖金。小明想知道最多能拿到的奖金是多少，你能帮他算算吗。
 *
 * 举例解释：桌子上放了红包  1, 2, 3, 4, 7, 10。小明在“4,7”之间、“7,10” 之间各切一刀，将红包分成3组 [1, 2, 3, 4]   [7]   [10]，其中第一组奖金之和=第三组奖金之和=10，所以小明可以拿到10越南盾。
 *
 * 输入描述:
 * 第一行包含一个正整数n，(1<=n<= 200 000)，表示有多少个红包。
 *
 * 第二行包含n个正整数d[i]，表示每个红包包含的奖金数额。其中1<= d[i] <= 1000 000 000
 *
 * 输出描述:
 * 小明可以拿到的总奖金
 *
 * 5
 * 1 3 1 1 4
 *
 * 5
 */
public class Main_16 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] moneys = new int[n];
        for(int i = 0 ; i < n ; i++) {
            moneys[i] = sc.nextInt();
        }

        int firstState = -1;
        int endState = n;

        // 0 first 1 end
        int isFirst = 0;

        long maxMoney = 0;

        long fitstMoney = 0;
        long endMoney = 0;

        while(firstState != endState) {
            if(fitstMoney == endMoney) {
                maxMoney = fitstMoney;
            }else{
                if(fitstMoney > endMoney) {
                    isFirst = 1;
                }else{
                    isFirst = 0;
                }
            }
            if(isFirst == 0) {
                firstState++;
                fitstMoney = fitstMoney + moneys[firstState];
            }else{
                endState--;
                endMoney = endMoney + moneys[endState];
            }
        }
        System.out.println(maxMoney);
    }
}
