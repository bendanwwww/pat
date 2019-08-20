package OF_2019;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 小明有一袋子长方形的积木，如果一个积木A的长和宽都不大于另外一个积木B的长和宽，则积木A可以搭在积木B的上面。好奇的小明特别想知道这一袋子积木最多可以搭多少层，你能帮他想想办法吗？
 * 定义每一个长方形的长L和宽W都为正整数，并且1 <= W <= L <= INT_MAX, 袋子里面长方形的个数为N, 并且 1 <= N <= 1000000.
 * 假如袋子里共有5个积木分别为 (2, 2), (2, 4), (3, 3), (2, 5), (4, 5), 则不难判断这些积木最多可以搭成4层, 因为(2, 2) < (2, 4) < (2, 5) < (4, 5)。
 *
 * 输入描述:
 * 第一行为积木的总个数 N
 *
 * 之后一共有N行，分别对应于每一个积木的宽W和长L
 *
 * 输出描述:
 * 输出总共可以搭的层数
 *
 * 5
 * 2 2
 * 2 4
 * 3 3
 * 2 5
 * 4 5
 *
 * 4
 */
public class Main_18 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<int[]> woodList = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            int[] woods = {sc.nextInt(), sc.nextInt()};
            woodList.add(woods);
        }

        woodList = woodList.stream().sorted((w1, w2) -> {
            if(w1[0] - w2[0] == 0){
                return w1[1] - w2[1];
            }else{
                return w1[0] - w2[0];
            }
        }).collect(Collectors.toList());


        /**
         * 我们按照宽度从小到大对 bricks 进行了排序
         * dp数组中存储的数积木的长度，它是一个上升的数组，这样才能保证积木的层叠
         */
        int[] dp = new int[n];
        int count = 0;//层数
        for (int i = 0; i < n; i++) {
            if (count == 0 || woodList.get(i)[1] >= dp[count - 1]) {
                //当当前积木的长度 >= dp数组中保存的最大积木长度，那我们就将它加入到 dp 数组中,并且层数加一
                dp[count] = woodList.get(i)[1];
                count++;
            }else {
                /**
                 * 这里解释一下：当我们加入的积木 bricks[i][1],它的长度小于dp中的最大长度
                 * 我们需要在数组dp中找到 <= bricks[i][1] 最接近的值的索引 index，将它替换成现在的长度 bricks[i][1]
                 * 为什么要替换: dp数组中积木的宽度都是小于 bricks[i]的，积木bricks[i]的宽度比dp[index]宽度大，
                 * 而且bricks[i]的长度 >= dp[index],在堆积木情况下，当然是优先选择宽度和长度更大的积木。
                 */
                int index = lowerBound(dp, 0, count, woodList.get(i)[1]);
                dp[index] = woodList.get(i)[1];
            }
        }
        System.out.println(count);

//        int max = 1;
//
//        int[] last = woodList.get(0);
//        for(int i = 1 ; i < n ; i++) {
//            int[] tmp = woodList.get(i);
//            if(tmp[0] < last[0] && tmp[1] < last[1]) {
//                max++;
//                last = tmp;
//            }
//        }
//
//        System.out.println(max);
    }

    /**
     * C++中存在的两个方法，用java实现一下
     * ower_bound算法要求在已经按照非递减顺序排序的数组中找到第一个大于等于给定值key的那个数的索引，
     * 其基本实现原理是二分查找
     */
    public static int lowerBound(int[] nums, int l, int r, int target){
        while(l < r) {
            int m = (l + r) / 2;
            if(nums[m] >= target) {
                r = m;
            }else {
                l = m + 1;
            }
        }
        return l;
    }
}