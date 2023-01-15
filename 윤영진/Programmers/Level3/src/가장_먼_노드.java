import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장_먼_노드 {
    static List<ArrayList<Integer>> listGraph = new LinkedList<>();
    static boolean[] visited;
    static int[] dist;
    static Queue<Integer> queue = new LinkedList<>();

    public static int solution(int n, int[][] edge) {
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            listGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];

            listGraph.get(a).add(b);
            listGraph.get(b).add(a);
        }

        queue.offer(1);
        visited[1] = true;
        bfs();

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == max) {
                cnt++;
            }
        }

        return cnt;
    }

    private static void bfs() {

        while (!queue.isEmpty()) {

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Integer v = queue.poll();
                for (Integer vex : listGraph.get(v)) {
                    if (!visited[vex]) {
                        visited[vex] = true;
                        dist[vex] = dist[v] + 1;
                        queue.offer(vex);
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        int ans = solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});

        System.out.println(ans);

    }
}