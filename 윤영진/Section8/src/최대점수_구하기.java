import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대점수_구하기 {
    static int N;
    static int M;
    static Problem[] arr;
    static int result = Integer.MIN_VALUE;

    static class Problem {

        int score;
        int time;

        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new Problem[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Problem problem = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            arr[i] = problem;
        }

        DFS(0, 0, 0);

        System.out.println(result);

    }

    private static void DFS(int L, int totalTime, int totalScore) {

        if (totalTime > M) return;
        if (L == N) {
            result = Math.max(totalScore, result);
        } else {

            DFS(L + 1, arr[L].time + totalTime, arr[L].score + totalScore);
            DFS(L + 1, totalTime, totalScore);

        }

    }
}
