import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Strahler_순서 {
    // 지질학에서 하천계는 유향그래프로 나타낼 수 있다.
    // 네모 안의 숫자는 순서를 나타내고, 동그라미 안의 숫자는 노드 번호를 나타낸다.

    // 하천계의 Strahler 순서는 다음과 같이 구할 수 있다
    // 강의 근원인 노드의 순서는 1이다.
    // 나머지 노드는 그 노드로 들어오는 강의 순서 중 가장 큰 값을 i라고 했을 때, 들어오는 모든 강 중에서 Strahler 순서가 i인 강이 1개이면 순서는 i, 2개 이상이면 순서는 i+1이다.


    static int T; // 테스트 케이스의 수
    static int K, M, P; // K: 테스트 케이스 번호, M은 노드의 수, P는 간선의 수
    static int[] inDegree;
    static int[] order;
    static int[] maxCnt;

    static List<ArrayList<Integer>> graphList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            for (int i = 0; i <= M; i++) {
                graphList.add(new ArrayList<>());
            }

            inDegree = new int[M + 1];
            order = new int[M + 1];
            maxCnt = new int[M + 1];

            result = Integer.MIN_VALUE;

            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                graphList.get(A).add(B);
                inDegree[B]++;
            }

            solution();
//            sb.append(K).append(" ").append(getMax()).append("\n");

        }

        System.out.println(sb);


    }

    private static void solution() {

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= M; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                order[i]++; // 순서
                maxCnt[i]++; // 최대진입
            }
        }

        while (!queue.isEmpty()) {

            Integer x = queue.poll();
            if (maxCnt[x] >= 2) order[x]++;
            result = Math.max(result, order[x]);

            for (Integer y : graphList.get(x)) {
                inDegree[y]--;
                if (inDegree[y] == 0) {
                    queue.offer(y);
                }
                if (order[x] == order[y]) maxCnt[y]++; // 한번더 진입
                else if (order[y] < order[x]) {
                    order[y] = order[x];
                    maxCnt[y] = 1;
                }

            }
        }

        sb.append(K).append(" ").append(result).append("\n");


    }

//    public static int getMax() {
//        int max = -1;
//        for (int i = 1; i <= M; i++) {
//            max = Math.max(max, order[i]);
//        }
//        return max;
//    }
}
