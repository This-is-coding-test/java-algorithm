import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부족한_금액_계산하기 {

    // 새로 생긴 놀이기구는 인기가 매우 많아 줄이 끊이질 않는다.
    // 이 놀이기구는 원래 이용로는 price 원 인데, 놀이기구를 N번째 이용한다면 원래 이용료의 N배를 받기로 한다.

    // 놀이기구를  count 번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를 return 하도록 solution 함수를 완성

    static class Solution {
        public long solution(int price, int money, int count) {
            long answer = -1;

            long totalPrice = 0;
            for (int i = 1; i <= count; i++) { // 1 -> 2 -> 3 -> 4
                totalPrice += (long) price * i;
            }
            answer = totalPrice - money;
            if (answer <= 0) {
                return 0;
            }

            return answer;
        }
    }

    public static void main(String[] args) throws IOException {

        Solution solution = new Solution();
        // 3 -> 6 -> 9 -> 12
        // 20 - 3 - 6 - 9 - 12 = 10
        System.out.println(solution.solution(3, 20, 4));


    }
}
