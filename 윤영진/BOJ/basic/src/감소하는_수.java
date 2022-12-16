import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 감소하는_수 {
    // 음이 아닌 정수 X의 자릿수가 가장 큰 자릿수까지 감소한다면, 그 수를 감소하는 수라고 한다.

    static int N;
    static ArrayList<Long> nums = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N <= 10) {
            System.out.println(N);
        }else if (N > 1022) {
            System.out.println(-1);
        }else {
            for (int i = 0; i < 10; i++) {
                solution(i, 1);
            }
            Collections.sort(nums);
            System.out.println(nums.get(N));
        }




    }

    private static void solution(long num, int idx) {
        if (idx > 10) {
            return;
        }
        nums.add(num);
        for (int i = 0; i < num % 10; i++) {
            solution((num * 10) + i, idx + 1);
        }
    }
}
