package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 회의실_예약 {

    // 회사에는 N개의 회의실이 있다.

    // 회의실은 9시부터 18시까지만 사용 가능하다.
    // 회의는 정확히 한 회의실을 연속한 일정 시간 동안만 점유한다.
    // 각 회의는 (회의실, 시작 시각, 종료 시각)의 정보로 나타낼 수 있다.
    // 회의의 시작과 종료 시각은 시 단위로만 설정 가능하다.
    // 한 회의가 끝나는 시각에 같은 회의실에서 다른 회의가 시작하는 것은 허용된다.

    // 이미 예약된 M개의 회의에 대한 정보가 주어지며, 회의실별로 비어 있는 시간대를 정리해 출력하는 프로그램을 작성

    // 각 회의실에 대한 정보를 회의실 이름의 오름차수능로 출력
    static int N, M; // N: 회의실 개수, M: 이미 예약된 회의실 개수


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<String, int[][]> reservation = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            int[][] temp = new int[9][2];
            for (int j = 0; j < 9; j++) {
                temp[j][0] = j;
                temp[j][1] = j + 1;
            }
            reservation.put(br.readLine(), temp);
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            int start = Integer.parseInt(st.nextToken()); // 14
            int end = Integer.parseInt(st.nextToken()); // 16

            int[][] curr = reservation.get(key);
            for (int j = start; j < end; j++) { // 14 ~ 16
                curr[j - 9][0] = -1; // [5][0]
                curr[j - 9][1] = -1; // [5][1]
            }
        }
        for (Map.Entry<String, int[][]> entry : reservation.entrySet()) {

            System.out.println(entry.getKey());
            int[][] value = entry.getValue();
            for (int[] ints : value) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }

        }


            StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, int[][]> entry : reservation.entrySet()) {
            StringBuilder temp = new StringBuilder();
            sb.append("Room ").append(entry.getKey()).append(":").append("\n");
            int[][] cur = entry.getValue();
            int total = 0;
            int start = -1;
            int end = -1;

            for (int i = 0; i < 9; i++) {
                if (cur[i][0] != -1) {
                    if (start == -1) {
                        start = cur[i][0]; // 0
                    }

                } else { // cur[i][0] == -1
                    if (start != -1) {
                        end = cur[i - 1][1]; // 2
                    }
                }

                if (start != -1 && end != -1) {
                    temp.append(start == 0 ? "09" : start + 9).append("-");
                    temp.append(end + 9).append("\n");
                    start = end = -1;
                    total++;
                }
            }

            if (start != -1) {
                // 아직 처리되지 않은게 남음
                total++;
                temp.append(start + 9 == 9 ? "09" : start + 9).append("-").append(18).append("\n");
            }

            if (total == 0) {
                sb.append("Not available").append("\n");
            } else {
                sb.append(total).append(" available:").append("\n");
                sb.append(temp);
            }
            sb.append("-----").append("\n");
        }
        sb.setLength(sb.length() - 6);

        System.out.println(sb);



    }
}
