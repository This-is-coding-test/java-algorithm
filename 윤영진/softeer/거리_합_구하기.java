package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 거리_합_구하기 {

    // 현재 사내 네트워크는 N개의 노드를 가지는 트리 형태의 네트워크
    // 두 노드간의 연결이 정확히 N-1개 있어서 이 연결만으로 모든 노드간에 통신을 할 수 있다.

    // 각 노드에 1에서 N 사이의 번호를 붙이면 i번째 연결은 xi번 노드와 yi번 노드를 양방향으로 연결
    // 통신에 걸리는 시간은 ti

    // 첫 번째 줄에 노드의 개수 N

    static class Edge {
        int vex;
        int weight;

        public Edge(int vex, int weight) {
            this.vex = vex;
            this.weight = weight;
        }
    }

    static int N;
    static List<ArrayList<Edge>> graph = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;
    static int[] subTreeSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        subTreeSize = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Edge(end, weight));
            graph.get(end).add(new Edge(start, weight));
        }

        dist = new int[N + 1];

        DFS1(1, 1);
        DFS2(1, 1);

        for (int i = 1; i <= N; i++) {
            System.out.println(dist[i]);
        }

    }

    private static void DFS2(int vex, int parent) {

        for (Edge edge : graph.get(vex)) {
            int child = edge.vex;
            int weight = edge.weight;
            if (child != parent) {
                dist[child] = dist[vex] + weight * (N - 2 * subTreeSize[child]);
                DFS2(child, vex);
            }
        }

    }

    private static void DFS1(int vex, int parent) {
        subTreeSize[vex] = 1;
        for (Edge edge : graph.get(vex)) {
            int child = edge.vex;
            int weight = edge.weight;
            if (child != parent) {
                DFS1(child, vex);
                dist[vex] += dist[child] + subTreeSize[child] * weight;
                subTreeSize[vex] += subTreeSize[child];
            }
        }

    }


}
