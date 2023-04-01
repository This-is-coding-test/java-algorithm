import java.util.TreeSet;

class 최대_길이_연속수열 {
    public int solution(int[] nums) {
        int answer = 0;
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int num : nums) {
            treeSet.add(num);
        }

        int prev = -1000000001;
        int cnt = 1;
        for (Integer num : treeSet) {
            if (prev + 1 == num) {
                prev = num;
                cnt++;
            } else {
                prev = num;
                cnt = 1;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        최대_길이_연속수열 T = new 최대_길이_연속수열();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}