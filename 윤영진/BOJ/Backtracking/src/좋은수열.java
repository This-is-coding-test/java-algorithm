import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 좋은수열 {
    // 숫자 1, 2, 3으로만 이루어지는 수열
    // 임의의 길이의 인접한 두 개의 부분 수열이 동일한 것이 있으면, 그 수열은 나쁜 수열

    // 길이가 N인 좋은 수열들을 N자리의 정수로 보아 그 중 가장 작은 수를 나타내는 수열
    static int N;
    static String result = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        backtracking(0, "");


    }

    private static void backtracking(int depth, String str) {

        if (depth == N) {
            System.out.println(str);
            System.exit(0);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (isPossible(str + i)) {
                backtracking(depth + 1, str + i);
            }
        }

    }

    private static boolean isPossible(String s) {
        for (int len = 1; len <= s.length() / 2; len++) {
            for (int i = 0; i <= s.length() - len * 2; i++) {
                if (s.substring(i, i + len).equals(s.substring(i + len, i + len * 2))) {
                    return false;
                }
            }
        }
        return true;
    }
}
