import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 친구_네트워크 {
    static int T, F;
    static int[] unf;
    static int[] level;
    static Map<String, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            F = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            unf = new int[F * 2 + 1];
            level = new int[F * 2 + 1];
            init();

            int idx = 1;

            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken();
                String f2 = st.nextToken();

                if (!map.containsKey(f1)) {
                    map.put(f1, idx++);
                }
                if (!map.containsKey(f2)) {
                    map.put(f2, idx++);
                }

                union(map.get(f1), map.get(f2));
                // 최상위 루트 찾기
                int cnt = level[find(map.get(f2))];
                sb.append(cnt).append("\n");
            }

        }
        System.out.println(sb);
    }

    private static void init() {
        for (int i = 1; i <= F * 2; i++) {
            unf[i] = i;
            level[i] = 1;
        }
    }

    private static void union(Integer p1, Integer p2) {
        int f1 = find(p1);
        int f2 = find(p2);
        if (f1 != f2) {
            unf[f1] = f2;
            level[f2] += level[f1];
        }

    }

    private static int find(Integer p1) { // 최상위 루트 찾기
        if (p1 == unf[p1]) return p1;
        else return unf[p1] = find(unf[p1]);
    }

}
