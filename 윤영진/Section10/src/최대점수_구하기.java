import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대점수_구하기 {

    static class Problem {

        int score;
        int time;

        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    static int N;
    static int M;
    static Problem[] problems;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        problems = new Problem[N];
        dy = new int[M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            problems[i] = new Problem(score, time);
        }

        for (Problem problem : problems) {
            for (int i = M; i >= problem.time; i--) {
                dy[i] = Math.max(dy[i], dy[i - problem.time] + problem.score);
            }
        }
        System.out.println(dy[M]);
    }
}
