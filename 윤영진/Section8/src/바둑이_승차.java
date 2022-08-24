import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바둑이_승차 {

    static int N;
    static int C;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        DFS(0, 0);

        System.out.println(result);

    }

    private static void DFS(int x, int sum) {

        if (sum > C) return;
        if (x == N) {
            result = Math.max(result, sum);
        } else {

            DFS(x + 1, sum + arr[x]);
            DFS(x + 1, sum);

        }

    }
}
