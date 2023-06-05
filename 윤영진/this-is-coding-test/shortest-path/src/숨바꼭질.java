import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 숨바꼭질 {
    // 동빈이는 숨바꼭질을 하면서 술래로부터 잡히지 않도록 숨을 곳을 찾고 있다.
    // 동빈이는 1 ~ N번까지의 헛간 중에서 하나를 골라 숨을 수 있으며, 술래는 항상 1번에서 출발
    // 전체 맵에는 총 M개의 양방향 통로가 존재
    static class Info {
        int vex, cost;

        public Info(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
    }

    static int N, M;
    static int[] dist;
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static PriorityQueue<Info> pQ = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        pQ.offer(new Info(1, 0));
        dijkstra();

        int answer = 0; // 숨어야 하는 헛간 번호
        int dst = Integer.MIN_VALUE; // 헛간까지의 거리
        int cnt = 0; // 헛간과 같은 거리를 갖는 헛간의 개수

        for (int i = 2; i <= N; i++) {
            if (dst < dist[i]) {
                answer = i;
                dst = dist[i];
                cnt = 0;
            }
            if (dst == dist[i]) cnt++;
        }

        System.out.println(answer + " " + dst + " " + cnt);


    }

    private static void dijkstra() {
        while (!pQ.isEmpty()) {
            Info info = pQ.poll();

            if (info.cost > dist[info.vex]) continue;

            for (Integer next : adjList.get(info.vex)) {
                if (info.cost + 1 < dist[next]) {
                    dist[next] = info.cost + 1;
                    pQ.offer(new Info(next, info.cost + 1));
                }
            }

        }

    }
}
