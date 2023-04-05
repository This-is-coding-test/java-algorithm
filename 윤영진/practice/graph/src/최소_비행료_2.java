import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class 최소_비행료_2 {
    class Edge {
        int vex;
        int cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
    }

    ArrayList<ArrayList<Edge>> adjList;
    int[] dist;

    public int solution(int n, int[][] flights, int s, int e, int k) {
        int answer;
        adjList = new ArrayList<>();
        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            int sE = flights[i][0];
            int eE = flights[i][1];
            int c = flights[i][2];
            adjList.get(sE).add(new Edge(eE, c));
        }

        bfs(s, k);
        answer = dist[e];
        if(dist[e] == Integer.MAX_VALUE) answer = -1;
        return answer;
    }

    private void bfs(int s, int k) {
        Queue<Edge> queue = new LinkedList<>();
        queue.offer(new Edge(s, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Edge edge = queue.poll();
                for (Edge tmp : adjList.get(edge.vex)) {
                    if (dist[tmp.vex] > edge.cost  + tmp.cost) {
                        dist[tmp.vex] = edge.cost + tmp.cost;
                        queue.offer(new Edge(tmp.vex, dist[tmp.vex]));
                    }
                }
            }
            L++;
            if(L > k) break;
        }
    }

    public static void main(String[] args) {
        최소_비행료_2 T = new 최소_비행료_2();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
    }
}