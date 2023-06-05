import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행_계획 {
    static int N, M;
    static final int INF = 987654321;
    //    static int[][] dist;
    static int[][] dist;
    static int[] unf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        unf = new int[N];
        for (int i = 0; i < N; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < N; i++) {
            int p1 = i;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int p2 = Integer.parseInt(st.nextToken());
                if (p2 == 1) {
                    Union(p1, p2);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(unf[i] + " ");
        }

        st = new StringTokenizer(br.readLine());
        int now = Integer.parseInt(st.nextToken());
        for (int i = 1; i < M; i++) {
            int next = Integer.parseInt(st.nextToken());

            int f1 = Find(now);
            int f2 = Find(next);
            if (f1 != f2) {
                System.out.println("NO");
                return;
            }
            now = next;
        }

        System.out.println("YES");

    }

    private static void Union(int p1, int p2) {
        int f1 = Find(p1);
        int f2 = Find(p2);

        if (f1 != f2) {
            unf[f1] = f2;
        }
    }

    private static int Find(int p) {

        if (p == unf[p]) return unf[p];
        else return unf[p] = Find(unf[p]);

    }
}