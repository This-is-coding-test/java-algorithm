import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기지국_설치 {

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int position = 1;
        int idx = 0;

        while (position <= n) {
            if (idx < stations.length && position >= stations[idx] - w) { // 기지국 안
                position = stations[idx] + w + 1;
                idx++;
            } else {
                position += 2 * w + 1;
                answer++;
            }


        }

        return answer;
    }

}
