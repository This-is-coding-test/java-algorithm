import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 바이러스 {

    // 신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.

    // 어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다.
    // 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력


    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    static int N; // 컴퓨터 수
    static int K; // 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        visited = new boolean[N + 1];

        visited[1] = true;
        DFS(1);

        int result = 0;
        for (int i = 2; i <= N; i++) {
            if (visited[i]) {
                result++;
            }
        }
        System.out.println(result);

    }

    private static void DFS(int i) {

        for (Integer x : graph.get(i)) {
            if (!visited[x]) {
                visited[x] = true;
                DFS(x);
            }
        }
    }

}
