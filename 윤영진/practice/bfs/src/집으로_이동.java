import java.util.*;

class 집으로_이동 {
    static class Info {
        int p;
        int cnt;

        public Info(int p, int cnt) {
            this.p = p;
            this.cnt = cnt;
        }
    }

    HashSet<Integer> set;
    int answer;

    public int solution(int[] pool, int a, int b, int home) {
        answer = 0;
        set = new HashSet<>();

        for (int p : pool) {
            set.add(p);
        }

        if (!bfs(a, b, home)) {
            answer = -1;
        }
        return answer;
    }

    private boolean bfs(int a, int b, int home) {
        Queue<Info> queue = new LinkedList<>();
        queue.offer(new Info(0, 0));
        boolean[][] visited = new boolean[2][10001];
        visited[0][0] = true;
        visited[1][0] = true;

        while (!queue.isEmpty()) {

            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Info info = queue.poll();
                if (info.p == home) return true;
                int next;

                // a만큼 +
                next = info.p + a;
                if (next <= 10000 && !visited[0][next] && !set.contains(next)) {
                    visited[0][next] = true;
                    queue.offer(new Info(next, 0));
                }

                // b만큼 -
                next = info.p - b;
                if (next >= 0 && info.cnt < 1 && !visited[1][next] && !set.contains(next)) {
                    visited[1][next] = true;
                    queue.offer(new Info(next, 1));
                }
            }
            answer++;
        }
        return false;

    }

    public static void main(String[] args) {
        집으로_이동 T = new 집으로_이동();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}