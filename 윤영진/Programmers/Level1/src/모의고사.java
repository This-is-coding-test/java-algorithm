import java.util.ArrayList;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[] A = new int[]{1, 2, 3, 4, 5}; // 5
        int[] B = new int[]{2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] C = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10

        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;

        for (int i = 0; i < answers.length; i++) {
            // A
            int ans = answers[i];

            if (A[idx1] == ans) answer[0]++;
            if (B[idx2] == ans) answer[1]++;
            if (C[idx3] == ans) answer[2]++;

            idx1 = (idx1 + 1) % A.length;
            idx2 = (idx2 + 1) % B.length;
            idx3 = (idx3 + 1) % C.length;
        }

        int max = Integer.MIN_VALUE;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (max < answer[i]) {
                max = answer[i];
                result = new ArrayList<>();
            }
            if (max == answer[i]) {
                result.add(i + 1);
            }
        }

        int[] results = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            results[i] = result.get(i);
        }

        return results;
    }
}
