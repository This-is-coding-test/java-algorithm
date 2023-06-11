import java.util.Arrays;

public class 징검다리 {

    // 출발지점부터 distance만큼 떨어진 곳에 도착지점
    // 바위 중 몇 개를 제거하려고 한다.
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);

        int left = 0;
        int right = distance;

        while (left <= right) {
            int mid = (left + right) / 2;
            int curr = 0;
            int cnt = 0;

            for (int rock : rocks) {
                if (rock - curr < mid) {
                    cnt++;
                } else {
                    curr = rock;
                }
            }
            if (distance - curr < mid) cnt++;

            if (cnt <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}
