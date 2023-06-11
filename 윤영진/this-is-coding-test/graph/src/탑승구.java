import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 탑승구 {
    // 공항에는 G개의 탑승구(1 ~ G 번호), 공항에는 P개의 비행기가 차례대로 도착할 예정 (P개의 비행기)
    // i번째 비행기를 1번부터 gi(1 ~ G)번째 탑승구 중 하나에 영구적으로 도킹 -> 다른 비행기가 도킹하지 않은 탑승구에만 도킹
    // 공황 관리자는 최대한 많은 비행기를 공항에 도킹 -> 비행기를 최대 몇 대 도킹 가능?
    static int G, P;
    static int[] unf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        unf = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            unf[i] = i;
        }

        int result = 0;
        for (int i = 0; i < P; i++) {
            int n = Integer.parseInt(br.readLine());
            int root = Find(n);


            if (root == 0) {
                break;
            }

            Union(root, root - 1);
            result++;

        }
        System.out.println(result);


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
