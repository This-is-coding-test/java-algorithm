package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 지도_자동_구축 {

    // 지도 자동 구축 기술을 개발해 지도 제작 시간을 단축하고 정밀도를 향상시키는 데 성공
    // Diamond-Square- Algorithm
    // 정사각형을 이루는 점 4개를 고르고 그 후에는 다음과 같은 과정을 거쳐 모양이 만들어진다.
    // 정사각형의 각 변의 중앙에 점 하나를 추가
    // 정사각형의 중심에 점을 하나 추가

    // N = 0 -> 4
    // N = 1 -> 9
    // N = 2 -> 25

    static int[] dp = new int[16];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp[0] = 2;
        dp[1] = 3;

        for (int i = 2; i <= 15; i++) {
            dp[i] = dp[i - 1] * 2 - 1;
        }

        System.out.println(dp[N]*dp[N]);



    }
}
