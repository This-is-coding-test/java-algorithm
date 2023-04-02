import java.util.*;

class 멀티태스킹 {
    public int solution(int[] tasks, long k) {
        Arrays.sort(tasks);

        int idx = 0;
        int prev = 0;
        int cnt = tasks.length; // 3

        while (cnt != 0) {
            if (idx < tasks.length && (long) cnt * (tasks[idx] - prev) <= k) {
                k -= (long) cnt * (tasks[idx] - prev);
                prev = tasks[idx++];
                cnt--;
            } else break;
        }

        if(cnt == 0) {
            return -1;
        }

        int r = tasks.length - idx; // 남은 tasks 개수
        return (int) (k % r) + idx + 1;
    }

    public static void main(String[] args) {
        멀티태스킹 T = new 멀티태스킹();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}
