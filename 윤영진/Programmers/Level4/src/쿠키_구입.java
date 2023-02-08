public class 쿠키_구입 {

    public int solution(int[] cookie) {
        int answer = -1;

        for (int i = 0; i < cookie.length - 1; i++) {
            int left = i;
            int right = i + 1;
            int leftSum = cookie[left];
            int rightSum = cookie[right];

            while (true) {
                if (leftSum == rightSum) {
                    answer = Math.max(answer, leftSum);
                }
                if (left > 0 && leftSum <= rightSum) {
                    left--;
                    leftSum += cookie[left];
                } else if (right < cookie.length - 1 && rightSum <= leftSum) {
                    right++;
                    rightSum += cookie[right];
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}
