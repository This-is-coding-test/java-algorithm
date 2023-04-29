import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등수_구하기 {
    static int N, S, P; // N - 점수 개수, S - 태수 점수, P - 리스트 올라갈 개수
    static int[] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        if (N == 0) {
            System.out.println(1);
            return;
        }

        scores = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 1; // 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
        int level = 1; // 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10

        for (int i = 0; i < N; i++) {
            if (scores[i] > S) {
                level++;
                cnt++;
            } else if (scores[i] == S) {
                cnt++;
            }
        }
        if (cnt <= P) System.out.println(level);
        else System.out.println(-1);

    }
}
