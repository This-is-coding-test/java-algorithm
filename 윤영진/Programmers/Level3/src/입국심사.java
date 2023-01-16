import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 입국심사 {

    // n명이 입국심사를 위해 줄을 서서 기다리고 있다.
    // 모든 사람이 심사를 받는데 걸리는 시간을 최소화
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0;
        long right = n * (long) times[times.length - 1];

        long answer = binarySearch(left, right, times, n);
        return answer;
    }

    public long binarySearch(long left, long right, int[] times, int n) {
        long answer = 0L;

        while (left <= right) {
            long mid = (left + right) / 2;

            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }

            if (sum >= n) {
                answer = sum;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;

    }

}
