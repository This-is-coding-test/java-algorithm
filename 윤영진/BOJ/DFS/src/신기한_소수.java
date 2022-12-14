import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 신기한_소수 {

    // 수빈이가 가장 관심있어 하는 소수는 7331이다.
    // 7331은 소수인데, 신기하게도 733도 소수이고, 73도 소수이고, 7도 소수이다. 즉, 왼쪽부터 1자리, 2자리, 3자리 모두 소수

    static int N;
    static int[] output;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        output = new int[N];

        backTracking(0, 0);

        result.sort(Comparator.comparingInt(o -> o));

        for (Integer x : result) {
            System.out.println(x);
        }


    }

    private static void backTracking(int num, int n) {

        if (n == N) {
            result.add(num);
            return;
        }
        for (int i = 1; i < 10; i++) {
            int next = num * 10 + i;
            if (isPrime(next)) backTracking(next, n + 1);
        }

    }

    static boolean isPrime(int num) {
        if (num < 2) return false;
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
