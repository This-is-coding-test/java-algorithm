import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 선수과목 {
    // 민욱이는 선수과목 조건을 지킬 경우 각각의 전공과목을 언제 이수할 수 있는지 궁금
    // 1. 한 학기에 들을 수 있는 과목 수에는 제한이 없다.
    // 2. 모든 과목은 매 학기 항상 개설
    static int N, M;
    // A B -> A번 과목이 B번 과목의 선수과목 A -> B
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static int[] inorders;
    static int[] results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inorders = new int[N + 1];
        results = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adjList.get(A).add(B);
            inorders[B]++;
        }

        topology();
        for (int i = 1; i <= N; i++) {
            System.out.print(results[i] + " ");
        }

    }

    private static void topology() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inorders[i] == 0) queue.offer(i);
        }

        int L = 1;
        while (!queue.isEmpty()) {

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Integer now = queue.poll();
                results[now] = L;

                for (Integer next : adjList.get(now)) {
                    inorders[next]--;
                    if (inorders[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
            L++;
        }
    }
}