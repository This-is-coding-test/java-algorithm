import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 그래프_최단거리 {

    static class Temp{

        private int idx;
        private int level;

        public Temp(int idx, int level) {
            this.idx = idx;
            this.level = level;
        }

        @Override
        public String toString() {
            return idx + " : " + level;
        }
    }

    static ArrayList<Temp> temps = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> listGraph = new ArrayList<>();
    static int[] dist;
    static int N;

    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            listGraph.add(new ArrayList<>());
        }
        dist = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 1
            int y = Integer.parseInt(st.nextToken()); // 2
            listGraph.get(x).add(y);
        }
        queue.offer(1);
        BFS();

        for (int i = 2; i < dist.length; i++) {
            System.out.print(i + " : " + dist[i]);
            System.out.println();
        }
//        temps.sort(Comparator.comparingInt(o -> o.idx));
//
//        for (int i = 0; i < temps.size(); i++) {
//            System.out.println(temps.get(i));
//        }


    }

    private static void BFS() {

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Integer cv = queue.poll();

                for (int nv : listGraph.get(cv)) {
                    if (dist[nv] == 0) {
                        queue.offer(nv);
                        dist[nv] = dist[cv] + 1;
                    }
                }
            }

        }

    }

    // Level로 처리
    private static void BFS_Level() {

        dist[1] = 1;
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Integer cv = queue.poll();
                if (cv != 1) {
                    temps.add(new Temp(cv, L));
                }

                for (int nv : listGraph.get(cv)) {
                    if (dist[nv] == 0) {
                        queue.offer(nv); // 3, 4
                        dist[nv] = 1;
                    }
                }
            }
            L++;
        }

    }

}
