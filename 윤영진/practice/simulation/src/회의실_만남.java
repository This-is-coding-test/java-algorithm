import java.util.*;

class 회의실_만남 {
    // 현수가 다니는 회사는 회의실에 출입할 때 명부에 이름을 적어야 한다.
    // 현수는 각 사람별로 회의실에서 반드시 만남 사람은 몇 명인지 구하려고 한다.

    static int n;

    public int[] solution(int[] enter, int[] exit) {
        n = enter.length;

        for (int i = 0; i < n; i++) {
            enter[i] -= 1;
            exit[i] -= 1;
        }
        int[] enterIdx = new int[n]; // i번째 사람이 들어온 번호
        for (int i = 0; i < n; i++) {
            enterIdx[enter[i]] = i;
        }
        int[] enterT = new int[n]; // i번째 사람이 회의실에 들어온 시간
        int[] exitT = new int[n]; // i번째 사람이 회의실에 나간 시간


        int t = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && j <= enterIdx[exit[i]]) {
                enterT[enter[j]] = t++;
                j++;
            }
            exitT[exit[i]] = t++;
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!(exitT[i] < enterT[j] || exitT[j] < enterT[i])) {
                    answer[i]++;
                    answer[j]++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        회의실_만남 T = new 회의실_만남();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}