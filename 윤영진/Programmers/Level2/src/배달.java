import java.util.*;
import java.io.*;

class 배달 {

    static class Edge {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static int[] dist;
    static boolean[] visited;
    static int answer = 0;
    static List<ArrayList<Edge>> listGraph = new ArrayList<>();
    static PriorityQueue<Edge> pQ = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));

    public int solution(int N, int[][] road, int K) {

        visited = new boolean[N + 1];
        dist = new int[N + 1];
        for(int i = 0;i <= N; i++) {
            listGraph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i<road.length;i++) {
            int e1 = road[i][0];
            int e2 = road[i][1];
            int v = road[i][2];

            listGraph.get(e1).add(new Edge(e2, v));
            listGraph.get(e2).add(new Edge(e1, v));
        }

        dist[1] = 0;
        pQ.offer(new Edge(1, 0));
        bfs();

        for (int i = 1; i<=N ; i++) {
            if(dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    public void bfs() {

        while(!pQ.isEmpty()) {
            Edge edge = pQ.poll();
            int vex = edge.v;
            int cost = edge.w;

            if(!visited[vex]) continue;
            visited[vex] = true;

            for (Edge e : listGraph.get(vex)) {

                if(dist[e.v] > e.w + cost) {
                    dist[e.v] = e.w + cost;
                    pQ.offer(new Edge(e.v, e.w + cost));
                }

            }

        }

    }

}