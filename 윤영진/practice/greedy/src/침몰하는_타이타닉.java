import java.util.*;

class 침몰하는_타이타닉 {
    // 구명보트는 2명 이하로만 탈 수 있으며, 보트 한 개에 탈 수 있는 총 무게도 Mkg 이하
    // 50 60 70 90 100
    //
    public int solution(int[] nums, int m) {
        int answer = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] + nums[right] <= m) {
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
        침몰하는_타이타닉 T = new 침몰하는_타이타닉();

        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(new int[]{86, 95, 107, 67, 38, 49, 116, 22, 78, 53}, 150));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}