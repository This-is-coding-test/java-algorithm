import java.util.ArrayList;
import java.util.List;

class 최대길이_바이토닉_수열_2 {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;

        List<Integer> peeks = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                peeks.add(i);
            }
        }

        for (Integer peek : peeks) {

            int left = peek;
            int right = peek;

            while (left - 1 >= 0 && nums[left - 1] < nums[left]) {
                left--;
            }
            while (right + 1 < n && nums[right + 1] > nums[right]) {
                right++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        최대길이_바이토닉_수열_2 T = new 최대길이_바이토닉_수열_2();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}