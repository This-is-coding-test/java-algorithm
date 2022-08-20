import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 경로_탐색_인접리스트 {
    // 정점의 개수가 많은 경우에는 인접행렬은 굉장히 비효율적이다.
    // 따라서, 정점의 개수가 많은 경우에는 인접리스트로 풀자.

    static ArrayList<ArrayList<Integer>> listGraph = new ArrayList<ArrayList<Integer>>();
    static int count = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 1
            int y = Integer.parseInt(st.nextToken()); // 2
            listGraph.get(x).add(y);
        }

        boolean[] check = new boolean[N + 1];
        DFS(1, check);
        System.out.println(count);

    }

    private static void DFS(int x, boolean[] check) {

        if (x == N) {
            count++;
        } else {
            for (int i = 1; i <= N; i++) {

//                if (graph[x][i] == 1 && !check[i]) {
//                    check[x] = true;
//                    DFS(i, check);
//                    check[x] = false;
//                }

            }

        }


    }
}
