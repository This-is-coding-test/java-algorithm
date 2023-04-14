import java.util.HashMap;

public class 상호_평가 {
    // 상호 평가를 통하여 학생들이 제출한 과제물에 학점을 부여
    // 유일한 최고점, 유일한 최저점

    public String solution(int[][] scores) {

        int n = scores.length;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            int maxCnt = 0, minCnt = 0;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (scores[j][j] < scores[i][j]) minCnt++;
                if (scores[j][j] > scores[i][j]) maxCnt++;
                sum += scores[i][j];
            }

            int avg = 0;
            if (maxCnt == n - 1 || minCnt == n - 1) {
                sum -= scores[j][j];
                avg = sum / (n - 1);
            } else avg = sum / n;
            sb.append(getScore(avg));
        }
        System.out.println(sb);
        return sb.toString();
    }

    private char getScore(int avg) {
        if (avg >= 90) return 'A';
        else if (avg >= 80) return 'B';
        else if (avg >= 70) return 'C';
        else if (avg >= 50) return 'D';
        else return 'F';
    }

    public static void main(String[] args) {
        상호_평가 sol = new 상호_평가();
        sol.solution(new int[][]{{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67}, {61, 57, 100, 80, 65}, {24, 90, 94, 75, 65}});

    }

}
