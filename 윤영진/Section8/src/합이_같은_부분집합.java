import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합이_같은_부분집합 {

    static int[] arr = new int[12];
    static int N;
    static int total;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        total = Arrays.stream(arr).sum();

        DFS(0, 0);

        System.out.print(flag ? "YES" : "NO");


    }

    private static void DFS(int L, int sum) {

        if (flag) return;

        if (L == N) {
            if ((total - sum) == sum) {
                flag = true;
            }
        } else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);

        }


    }

}
