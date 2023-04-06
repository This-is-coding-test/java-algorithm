import java.util.*;

class 이동_횟수 {
    // 5kg 이하로만 들고 이동할 수 있다. -> 한 번에 여러개 가능

    public int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] + nums[right] <= 5) {
                left++;
                right--;
            } else {
                right--;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        이동_횟수 T = new 이동_횟수();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}