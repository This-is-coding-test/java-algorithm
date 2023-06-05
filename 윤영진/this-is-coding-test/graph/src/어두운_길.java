import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 어두운_길 {
    static class Info {
        int vex, cost;

        public Info(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
    }

    static int N, M;
    static ArrayList<ArrayList<Info>> adjList = new ArrayList<>();
    static boolean[] visited;
    static int answer = 0;
    // 한 마을은 N개의 집과 M개의 도로


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        int total = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList.get(a).add(new Info(b, cost));
            adjList.get(b).add(new Info(a, cost));
            total += cost;
        }

        prim();
        System.out.println(total - answer);

    }

    private static void prim() {

        PriorityQueue<Info> pQ = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pQ.offer(new Info(0, 0));

        while (!pQ.isEmpty()) {
            Info info = pQ.poll();
            if (visited[info.vex]) continue;
            visited[info.vex] = true;
            answer += info.cost;

            for (Info next : adjList.get(info.vex)) {
                if (visited[next.vex]) continue;
                pQ.offer(next);
            }
        }
    }
}
