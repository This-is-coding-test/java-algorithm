import java.io.IOException;
import java.util.ArrayList;

public class 하노이_탑 {
    // 가장 큰 원반을 제외한 나머지 모든 원반을 보조 기둥
    //
    ArrayList<int[]> result = new ArrayList<>();

    public int[][] solution(int n) {

        hanoi(n, 1, 3, 2); // (원반 개수, 시작, 목표, 보조)
        int[][] answer = new int[result.size()][2];

        for (int i = 0; i < result.size(); i++) {
            answer[i][0] = result.get(i)[0];
            answer[i][1] = result.get(i)[1];
        }
        return answer;
    }

    // 시작, 목표, 보조
    private void hanoi(int n, int src, int dst, int mid) { // (3, 1, 3, 2)
        if (n == 1) { // (1, 1, 3, 2) / (1, 3, 2, 1)
            result.add(new int[]{src, dst}); // 이동 (1 -> 3) / (3 -> 2)
            return;
        }
        // (2, 1, 2, 3)
        // 맨 아래 원반을 제외한 나머지 모든 원반을 보조 기둥으로 이동
        hanoi(n - 1, src, mid, dst); // (1, 1, 3, 2)
        result.add(new int[]{src, dst}); // 이동 (1 -> 2) / (1 -> 3)

        // 목표 기둥에 존재하는 모든 원반을 보조 기둥으로 이동
        hanoi(n - 1, mid, dst, src); // (1, 3, 2, 1)ㅐㅐㅐㅑ
    }

    public static void main(String[] args) throws IOException {
        하노이_탑 sol = new 하노이_탑();
        sol.solution(3);
    }
}
