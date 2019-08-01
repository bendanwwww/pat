package OF_2019;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * 题目描述
 * 为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。牛牛选工作的标准是在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作。在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴们。牛牛的小伙伴太多了，于是他只好把这个任务交给了你。
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
 * 接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
 * 接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
 * 保证不存在两项工作的报酬相同。
 * 输出描述:
 * 对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。
 *
 * 3 3
 * 1 100
 * 10 1000
 * 1000000000 1001
 * 9 10 1000000000
 *
 * 100
 * 1000
 * 1001
 */
public class Main_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLines = scanner.nextLine().split(" ");

        int workNumber = Integer.valueOf(firstLines[0]);
        int peopleNumber = Integer.valueOf(firstLines[1]);

        TreeMap<Integer, Integer> works = new TreeMap<Integer, Integer>();

        for(int i = 0 ; i < workNumber ; i++) {
            String[] tmp = scanner.nextLine().split(" ");
            works.put(Integer.valueOf(tmp[1]), Integer.valueOf(tmp[0]));
        }
        if(peopleNumber > 0) {
            String[] peoples = scanner.nextLine().split(" ");

            Set<Integer> keySet = works.keySet();
            Integer[] keys = new Integer[keySet.size()];
            keySet.toArray(keys);
            for (String p : peoples) {
                for (int x = keys.length - 1; x >= 0; x--) {
                    if (works.get(keys[x]) <= Integer.valueOf(p)) {
                        System.out.println(keys[x]);
                        break;
                    }
                }
            }
        }
    }

}
