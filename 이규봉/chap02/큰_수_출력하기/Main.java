package 큰_수_출력하기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public List<Integer> solution(int[] nums) {
        List<Integer> filteredNums = new ArrayList<>();
        filteredNums.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                filteredNums.add(nums[i]);
            }
        }

        return filteredNums;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Main main = new Main();
        List<Integer> filteredNums = main.solution(nums);

        filteredNums.forEach(num -> System.out.print(num + " "));
    }

}
