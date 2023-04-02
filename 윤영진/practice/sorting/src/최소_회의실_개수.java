import java.util.*;

class 최소_회의실_개수 {
    static class Info {
        int t;
        char type;

        public Info(int t, char type) {
            this.t = t;
            this.type = type;
        }
    }

    public int solution(int[][] meetings) {
        int answer = 0;
        List<Info> infoList = new ArrayList<>();
        for (int i = 0; i < meetings.length; i++) {
            int s = meetings[i][0];
            int e = meetings[i][1];
            infoList.add(new Info(s, 'S'));
            infoList.add(new Info(e, 'E'));
        }
        infoList.sort(new Comparator<>() {
            public int compare(Info i1, Info i2) {
                if (i1.t == i2.t) return i1.type - i2.type;
                return i1.t - i2.t;
            }
        });

        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for (Info info : infoList) {
            if (info.type == 'S') {
                cnt++;
            } else cnt--;
            max = Math.max(max, cnt);
        }

        return max;
    }

    public static void main(String[] args) {
        최소_회의실_개수 T = new 최소_회의실_개수();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}
