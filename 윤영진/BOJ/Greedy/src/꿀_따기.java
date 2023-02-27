import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 꿀_따기 {
    static long total;                // 모든 장소들의 꿀 양 합
    static long[] toRightTotal;        // [0 ~ 벌 2 위치] 누적합
    static long[] toLeftTotal;        // [끝 ~ 벌 2 위치] 누적합
    static int N;
    static int[] honey;
    static long result;

    // Case 1 : 1번 벌 왼쪽 고정, 벌통 오른쪽 고정, 2번 벌 이동
    public static void case1() {
        long bee1;
        long bee2;

        for (int i = 1; i < N - 1; i++) { // 2번 벌 위치
            bee1 = total - honey[0] - honey[i];
            bee2 = total - toRightTotal[i];
            result = Math.max(result, bee1 + bee2);
        }
    }

    // Case 2 : 1번 벌 오른쪽 고정, 벌통 왼쪽 고정, 2번 벌 이동
    public static void case2() {
        long bee1;
        long bee2;

        for (int i = N - 2; i >= 1; i--) { // 2번 벌 위치
            bee1 = total - honey[N - 1] - honey[i];
            bee2 = total - toLeftTotal[i];
            result = Math.max(result, bee1 + bee2);
        }
    }

    // Case 3 : 1번 벌 왼쪽 고정, 2번 벌 오른쪽 고정, 벌통 이동
    public static void case3() {
        long bee1;
        long bee2;

        for (int i = 1; i < N - 1; i++) { // 2번 벌 위치
            bee1 = toRightTotal[i] - honey[0];
            bee2 = toLeftTotal[i] - honey[N - 1];
            result = Math.max(result, bee1 + bee2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        honey = new int[N];
        toRightTotal = new long[N];
        toLeftTotal = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
        }

        toRightTotal[0] = honey[0];
        for (int i = 1; i < N; i++) {
            toRightTotal[i] = toRightTotal[i - 1] + honey[i];
        }

        toLeftTotal[N - 1] = honey[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            toLeftTotal[i] = toLeftTotal[i + 1] + honey[i];
        }

        total = toRightTotal[N - 1];
        case1();
        case2();
        case3();

        System.out.println(result);


    }
}
