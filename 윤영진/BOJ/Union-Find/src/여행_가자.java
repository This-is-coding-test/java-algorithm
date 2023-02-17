import java.util.*;
import java.io.*;

public class 여행_가자 {
    // 도시가 N개 있고 임의의 두 도시 사이에 길이 있을 수도, 없을 수도 있다.
    //여행 일정이 주어졌을 때, 여행 경로가 가능한 것인지 알아보자

    static int N, M;
    static int[] unf;
    static int[] path;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        unf = new int[N + 1];
        path = new int[M];

        for (int i = 1; i <= N; i++) {
            unf[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int d = Integer.parseInt(st.nextToken());
                if (d == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            path[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M - 1; i++) {
            int f1 = Find(path[i]);
            int f2 = Find(path[i + 1]);
            if(f1 != f2) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");



    }

    private static void union(int p1, int p2) {
        int f1 = Find(p1);
        int f2 = Find(p2);

        if (f1 != f2) {
            unf[f1] = f2;
        }
    }

    private static int Find(int p) {
        if (p == unf[p]) return p;
        else return unf[p] = Find(unf[p]);
    }
}