import java.util.ArrayList;

public class 모두_0으로_만들기 {

    // 각 점에 가중치가 부여된 트리
    // 다음 연산을 통하여 이 트리의 모든 점들의 가중치를 0으로
    // 임의의 연결된 두 점을 골라서 한쪽은 1 증가, 다른 한쪽은 1감소
    // 트리는 끊어진 형태일 수 없다!

    static long ans = 0L;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static long[] weight;

    public long solution(int[] a, int[][] edges) {
        weight = new long[a.length];
        visited = new boolean[a.length];
        adjList = new ArrayList[a.length];
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            weight[i] = a[i];
            sum += a[i];
            adjList[i] = new ArrayList<>();
        }
        if (sum != 0) return -1;


        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];

            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        dfs(0);

        return ans;
    }

    public long dfs(int v) {
        visited[v] = true;

        for (int i = 0; i < adjList[v].size(); i++) {
            int curr = adjList[v].get(i);
            if (!visited[curr]) {
                weight[v] += dfs(curr);
            }
        }

        ans += Math.abs(weight[v]);
        return weight[v];
    }
}
