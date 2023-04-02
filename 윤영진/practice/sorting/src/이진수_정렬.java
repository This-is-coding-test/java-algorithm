import java.util.*;

class 이진수_정렬 {
    static class Info {
        int origin;
        int cnt;

        public Info(int origin, int cnt) {
            this.origin = origin;
            this.cnt = cnt;
        }
    }

    public int[] solution(int[] nums) {
        int[] answer = new int[nums.length];
        List<Info> infos = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int cnt = Integer.bitCount(nums[i]);
            infos.add(new Info(nums[i], cnt));
        }
        Collections.sort(infos, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.cnt == o2.cnt) return o1.origin - o2.origin;
                return o1.cnt - o2.cnt;
            }
        });

        for (int i = 0; i < infos.size(); i++) {
            answer[i] = infos.get(i).origin;
        }
        return answer;
    }

    public static void main(String[] args) {
        이진수_정렬 T = new 이진수_정렬();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}