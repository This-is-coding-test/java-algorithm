package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가능한_수열_중_최솟값_구하기 {
    // 길이가 n인 수열을 세 개의 숫자 4, 5, 6
    // 두 개의 인접한 연속 부분 수열이 동일한 경우, 불가능한 수열로 간주
    static int n;
    static List<Integer> output = new ArrayList<>();
    static boolean flag = false;
    static String result = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        backtracking(0);
        System.out.println(result);

    }

    private static void backtracking(int depth) {
        if (depth == n) {
            for (int i = 0; i < output.size(); i++) {
                System.out.print(output.get(i));
            }
            System.exit(0);
        } else {
            for (int i = 4; i <= 6; i++) {
                output.add(i);
                if (isPossible()) {
                    backtracking(depth + 1);
                }
                output.remove(output.size() - 1);
            }
        }

    }

    private static boolean isPossible() {

        // 6 ->
        // 부분 수열은 n = 6인 경우 1,2,3만 가능
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < output.size(); i++) {
            s.append(output.get(i));
        }

        for (int num = 1; num <= output.size() / 2; num++) {
            for (int i = 0; i < output.size() - num; i++) {
                if (i + num * 2 <= output.size()) {
                    if (s.substring(i, i + num).equals(s.substring(i + num, i + num * 2))) {
                        return false;
                    }
                }
            }
        }
        return true;


    }
}
