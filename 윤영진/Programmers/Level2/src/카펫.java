public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        // 12 -> (3, 4), (4, 3),
        // 9 -> (3, 3)
        // 48 -> ()
        int total = brown + yellow;

        // 3 3 3 4
        for (int row = 3; row <= total / 2; row++) {
            if (total % row != 0 || total / row < 3) continue;
            int col = total / row;

            if ((col - 2) * (row - 2) == yellow) return new int[]{col, row};
        }

        return new int[]{-1, -1};
    }
}
