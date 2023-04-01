import java.util.*;

class 피부과 {
    static class Info {
        int min;
        int type;

        public Info(int min, int type) {
            this.min = min;
            this.type = type;
        }
    }

    // 대기실에서 동시에 대기하는 최대 인원수
    public int solution(int[] laser, String[] enter) {
        int answer = 0;
        int n = enter.length;
        List<Info> infoList = new ArrayList<>();
        for (int i = 0; i < enter.length; i++) {
            String[] tmp = enter[i].split(" ");
            int min = getTime(tmp[0]);
            int type = tmp[1].charAt(0) - 48;
            infoList.add(new Info(min, type));
        }

        Queue<Integer> wait = new LinkedList<>(); // 타입 삽입
        wait.offer(infoList.get(0).type);

        int fT = infoList.get(0).min; // 시술 끝나는 시간
        int idx = 1;
        for (int t = fT; t <= 1200; t++) {
            if (idx < n && t == infoList.get(idx).min) { // 환자 도착
                if (wait.isEmpty() && t > fT) fT = t; // 현재 시간이 시술 끝나는 시간보다 큰 경우 -> 바로 시술 시작
                wait.offer(infoList.get(idx).type);
                idx++;
            }

            if (t == fT && !wait.isEmpty()) { // // 시술 끝나는 시간이 된 경우
                int type = wait.poll();
                fT += laser[type]; // 시술 끝나는 시간 업데이트
            }
            answer = Math.max(answer, wait.size());
        }

        return answer;
    }

    private int getTime(String s) {
        int h = Integer.parseInt(s.split(":")[0]) * 60;
        int m = Integer.parseInt(s.split(":")[1]);
        return h + m;
    }

    public static void main(String[] args) {
        피부과 T = new 피부과();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}