import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 위상정렬 {

    static List<ArrayList<Integer>> graphList = new ArrayList<>();
    static int N, P; // N 노드 개수, P 간선 개수
    static int[] inDegree;
    static int[] result;

    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        inDegree = new int[N + 1];
        result = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graphList.add(new ArrayList<>());
        }

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graphList.get(A).add(B);
            inDegree[B]++;
        }

//        solution();

        for (int i = 1; i <= N; i++) {
            System.out.print(inDegree[i] + " ");
        }
    }

    private static void solution() {

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            // 진입 차수가 0인 노드를 미리 add
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        for (int i = 1; i <= N; i++) {
            Integer x = queue.peek(); // 1
            queue.poll();
            result[i] = x;
            // result[1] = 1
            // result[2] = 2
            // result[3] = 5

            for (Integer y : graphList.get(x)) {
                inDegree[y]--;
//                result[y]++;
                if (inDegree[y] == 0) queue.offer(y);
            }

        }

//        while (!queue.isEmpty()) {
//            int x = queue.poll(); // 1
//
//            for (Integer y : graphList.get(x)) {
//                inDegree[y]--;
//                result[y]++;
//                if (inDegree[y] == 0) queue.offer(y);
//            }
//        }
    }
}
