import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄_세우기 {
    // N명의 학생들을 키 순서대로 줄을 세우려고 한다.
    // 각 학생의 키를 직접 재서 정렬하면 간단하겠지만, 마땅한 방법이 없어서 두 학생의 키를 비교하는 방법을 사용하기로 했다.
    // 일부 학생들의 키만 비교

    static int N, M; // N - 학생 수, M - 비교 회수
    // 1 3 == 1번 학생이 3번 학생 앞에 서야 한다.
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static int[] inorders;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        inorders = new int[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            // A -> B
            inorders[B]++;
            adjList.get(A).add(B);
        }

        topology();
        System.out.println(sb.toString());
    }

    private static void topology() {

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (inorders[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            sb.append(now + 1).append(" ");

            for (Integer next : adjList.get(now)) {
                inorders[next]--;
                if (inorders[next] == 0) queue.offer(next);
            }
        }
    }
}
