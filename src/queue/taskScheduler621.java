package queue;

/**
 * @Author: Li Wanfang
 * @Date: 2019/10/17 22:06
 */

/**
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
 * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个
 * 任务，或者在待命状态。然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内
 * CPU 在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的最短时间。
 *
 * 示例 1：
 *
 * 输入: tasks = ["A","A","A","B","B","B"], n = 2
 * 输出: 8
 * 执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 * 注：
 *
 * 任务的总个数为 [1, 10000]。
 * n 的取值范围为 [0, 100]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/task-scheduler
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * 这道题的核心公式是(m-1)x(t+1)+numof(m),m是最高频率数，t是间隔。公式很快能推出了，我来解释一下，先排出现频率最高的，
 * 然后再插入频率第二高的（可以等于第一的频率),这题最巧妙的一点是不要拘泥于间隔，你其实是可以无限插入的，这就意味着即
 * 使频率最高的字母之间的间隔小于其他字母的个数，你还是可以继续插入的，所以并不会出现空转的情况，这也是我看了pphdsny
 * 的解法明白的，其他解法几乎都没有说明这一点。
 */
public class taskScheduler621 {
    public int leastInterval(char[] tasks, int n) {
        /**
         * 先定义一个26位长的数组，来储存每个任务实现的频率
         * 比如taskCount【0】=3，说明有三个A任务。
         */
        int[] taskCount = new int[26];
        for(int i=0;i<tasks.length;i++){
            taskCount[tasks[i]-'A']++;
        }
        /**
         * 排序，保证到时候先排频率最高的任务
         * 然后计算出公式所需的num of maxcount
         * 最后带入公式得到答案
         */
        Arrays.sort(taskCount);
        int maxCount = taskCount[25];
        int num=0;
        for(int i=0;i<26;i++){
            if(taskCount[i]==maxCount){
                num++;
            }
        }
        int time = (maxCount-1)*(n+1)+num;
        /**
         *返回答案，time出现比长度还短的原因是你已经把任务
         *插进去了但实际上并没有算上。
         */
        return Math.max(time,tasks.length);

    }
}
