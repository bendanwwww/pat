package OF_2019;

import java.util.Scanner;

/**
 * 题目描述
 * 又到了丰收的季节，恰逢小易去牛牛的果园里游玩。
 * 牛牛常说他对整个果园的每个地方都了如指掌，小易不太相信，所以他想考考牛牛。
 * 在果园里有N堆苹果，每堆苹果的数量为ai，小易希望知道从左往右数第x个苹果是属于哪一堆的。
 * 牛牛觉得这个问题太简单，所以希望你来替他回答。
 *
 * 输入描述:
 * 第一行一个数n(1 <= n <= 105)。
 * 第二行n个数ai(1 <= ai <= 1000)，表示从左往右数第i堆有多少苹果
 * 第三行一个数m(1 <= m <= 105)，表示有m次询问。
 * 第四行m个数qi，表示小易希望知道第qi个苹果属于哪一堆。
 *
 * 输出描述:
 * m行，第i行输出第qi个苹果属于哪一堆。
 *
 * 5
 * 2 7 3 4 9
 * 3
 * 1 25 11
 *
 * 1
 * 5
 * 3
 */
public class Main_11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] sumApples = new int[n];

        int sum = 0;
        for(int i = 0 ; i < n ; i++) {
            int apples = sc.nextInt();
            sum = sum + apples;
            sumApples[i] = sum;
        }

        int m = sc.nextInt();

        for(int i = 0 ; i < m ; i++) {
            int next = sc.nextInt();

            int left = 0;
            int right = n - 1;

            boolean s = false;

            while(left + 1 < right) {
                int middle = (left + right) / 2;
                if(sumApples[middle] == next) {
                    s = true;
                    System.out.println(middle + 1);
                    break;
                }
                if(sumApples[middle] < next) {
                    left = middle;
                }

                if(sumApples[middle] > next) {
                    right = middle;
                }
            }
            if(!s) {
                if(sumApples[left] >= next) {
                    System.out.println(left + 1);
                }else{
                    System.out.println(right + 1);
                }

            }
        }
    }
}
