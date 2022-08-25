import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열_구하기 {
    static int N;
    static int M;
    static int[] arr;
    static int[] output;
    static boolean[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        output = new int[M];

        arr = new int[N];
        ch = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0);


    }

    private static void DFS(int L) {

        if (L == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
        } else {

            for (int i = 0; i < N; i++) {
                if (!ch[i]) {
                    ch[i] = true;
                    output[L] = arr[i];
                    DFS(L + 1);
                    ch[i] = false;
                }

            }

        }

    }
}
