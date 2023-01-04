package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 아름다운_수 {

    // 1이상 4이하의 숫자로만 이루어져 있으면서, 정확히 해당 숫자만큼 연달아 같은 숫자가 나오는 숫자를 아름다운 수
    static int[] output;
    static int n;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        output = new int[n];

        backtracking(0);

        System.out.println(cnt);
    }

    private static void backtracking(int depth) {
        if (depth == n) {

            if (checkBeautifulNum()) {
                cnt++;
            }
        } else {

            for (int i = 1; i <= 4; i++) {
                output[depth] = i;
                backtracking(depth + 1);
            }

        }

    }

    private static boolean checkBeautifulNum() {

        // 연달아 같은 숫자가 나오는 시작 위치를 잡습니다.
        for(int i = 0; i < n; i += output[i]) {
            // 만약 연속하여 해당 숫자만큼 나올 수 없다면
            // 아름다운 수가 아닙니다.
            if(i + output[i] - 1 >= n)
                return false;
            // 연속하여 해당 숫자만큼 같은 숫자가 있는지 확인합니다.
            // 하나라도 다른 숫자가 있다면
            // 아름다운 수가 아닙니다.
            for(int j = i; j < i + output[i]; j++)
                if(output[j] != output[i])
                    return false;
        }
        return true;
    }
}
