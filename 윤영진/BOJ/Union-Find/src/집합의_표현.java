import java.util.*;
import java.io.*;

public class 집합의_표현 {
    static int n, m;
    static int[] unf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        unf = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            if (op == 0) {
                union(p1, p2);
            } else {
                if (isFriend(p1, p2)) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }

            }
        }
        System.out.println(sb);
    }

    private static boolean isFriend(int p1, int p2) {
        int f1 = find(p1);
        int f2 = find(p2);
        return f1 == f2;
    }

    private static void union(int p1, int p2) {
        int f1 = find(p1);
        int f2 = find(p2);

        if (f1 != f2) {
            unf[f1] = f2;
        }

    }

    private static int find(int p) {
        if (p == unf[p]) return p;
        else return unf[p] = find(unf[p]);
    }

}
