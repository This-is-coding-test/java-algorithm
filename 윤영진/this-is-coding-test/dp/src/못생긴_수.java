import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 못생긴_수 {
    // 못생긴 수 : 2, 3, 5만을 소인수로 가지는 수 -> 2, 3, 5를 약수로 가지는 합성수
    // 15 / 5
    // 3 / 3
    // 1
    // 못생긴 수에 2, 3, 5를 곱한 수 또한 못생긴 수에 해당한다.
    // 1 -> 2 3 5
    // 2 -> 4 6 10
    // 3 -> 6 9 15

    static int[] ugly = new int[1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int i2 = 0, i3 = 0, i5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;

        ugly[0] = 1;

        for (int i = 1; i <= n; i++) {

            ugly[i] = Math.min(next2, Math.min(next3, next5));

            if (ugly[i] == next2) {
                i2 += 1;
                next2 = ugly[i2] * 2;
            }
            if (ugly[i] == next3) {
                i3 += 1;
                next3 = ugly[i3] * 3;
            }
            if (ugly[i] == next5) {
                i5 += 1;
                next5 = ugly[i5] * 5;
            }
        }
        System.out.println(ugly[n - 1]);


    }
}
