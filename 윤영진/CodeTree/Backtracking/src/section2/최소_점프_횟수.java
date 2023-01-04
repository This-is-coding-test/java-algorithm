package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최소_점프_횟수 {
    // 각 위치로부터의 최대 점프 가능 거리를 의미하는 n개의 숫자
    // 첫 번째 위치로부터 n번째 위치에 도달하기 위해 필요한 최소 점프 횟수
    static class Pair {
        int idx;
        int val;

        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    static int n;
    static Pair[] jumps;
    static Queue<Pair> queue = new LinkedList<>();
    static int time = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        jumps = new Pair[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int val = Integer.parseInt(st.nextToken());
            jumps[i] = new Pair(i, val);
        }

        queue.offer(jumps[1]);
        BFS();
        System.out.println(time);

    }

    private static void BFS() {
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Pair p = queue.poll();
                if (p.idx == n) {
                    return;
                }
                for (int j = 1; j <= p.val; j++) { // 0, 1
                    if (p.idx + j <= n) {
                        Pair nP = jumps[p.idx + j];
                        queue.offer(nP);
                    }
                }
            }
            time++;
        }
        System.out.print(-1);
        System.exit(0);

    }

    private static void backtracking(int depth) {

    }
}
