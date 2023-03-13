public class _124_나라의_숫자 {
    static int[] nums = {4, 1, 2};

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int remainder = n % 3;
            n /= 3;

            if (remainder == 0) n--;
            sb.insert(0, nums[remainder]);
        }
        return sb.toString();
    }

}
