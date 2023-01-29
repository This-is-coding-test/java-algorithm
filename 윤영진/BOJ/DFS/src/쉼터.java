import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 쉼터 {
    // K채의 집을 지을 때, 가능하면 샘터의 주변에 집들을 지어서 K채의 모든 집에 대한 불행도의 합이 최소
    //
    // 일직선 상의 공간에 N개의 샘터가 존재하며, K채의 집을 짓고자 한다.
    static class Pair {
        int x;
        int dist;

        public Pair(int x, int dist) {
            this.x = x;
            this.dist = dist;
        }
    }

    static final int MAX = 100000000;
    static int N, K;
    static Set<Integer> visited = new HashSet<>();
    static int[] d = {-1, 1};
    static Queue<Pair> queue = new LinkedList<>();
    static long answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            queue.offer(new Pair(p, 0));
            visited.add(p);
        }

        bfs();
        System.out.println(answer);

    }

    private static void bfs() {
        int cnt = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Pair p = queue.poll();
                for (int k = 0; k < 2; k++) {
                    int nx = p.x + d[k];
                    if (canGo(nx)) {
                        cnt++;
                        answer += p.dist + 1;
                        if (cnt == K) return;

                        visited.add(nx);
                        queue.offer(new Pair(nx, p.dist + 1));

                    }
                }
            }


        }

    }

    private static boolean canGo(int nx) {
        return nx >= -MAX && nx <= MAX && !visited.contains(nx);
    }
}
