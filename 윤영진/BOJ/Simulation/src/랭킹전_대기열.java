import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 랭킹전_대기열 {
    // 플레이어 간의 실력차이가 있을 수 있기 대문에 입장을 신청하면 자신과 비슷한 레벨의 플레이어들을 매칭
    // 1. 플레이어가 입장을 신청하였을 때 매칭이 가능한 방이 없다면 새로운 방을 만들고 입장
    // 이때 해당 방에는 처음 입장한 플레이어의 레벨을 기준으로 -10부터 +10까지 입장 가능
    // 2. 입장 가능한 방이 있다면 입장시킨 후 방의 정원이 모두 찰 때까지 대기
    // 입장이 가능한 방이 여러 개라면 먼저 생성된 방에 입장
    // 3. 방의 정원이 모두 차면 게임을 시작

    static class Info {
        int level;
        String nickname;

        public Info(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }

    static int p, m; // p - 플레이어의 수, m - 방의 정원
    static TreeMap<Integer, ArrayList<Info>> room;
    static ArrayList<Integer> levels = new ArrayList<>();
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        room = new TreeMap<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

            if (room.isEmpty()) {
                room.put(idx, new ArrayList<>());
                room.get(idx).add(new Info(l, n));
                levels.add(l);
                idx++;
            } else {
                boolean flag = false;

                for (Integer idx : room.keySet()) {
                    if (l <= levels.get(idx) + 10 && l >= levels.get(idx) - 10) {
                        if (room.get(idx).size() < m) {
                            room.get(idx).add(new Info(l, n));
                            flag = true;
                            break;
                        }
                    }
                }

                if (!flag) {
                    room.put(idx, new ArrayList<>());
                    room.get(idx).add(new Info(l, n));
                    levels.add(l);
                    idx++;
                }
            }
        }

        for (Integer idx : room.keySet()) {

            if (room.get(idx).size() == m) {
                sb.append("Started!").append("\n");
            } else {
                sb.append("Waiting!").append("\n");
            }

            Collections.sort(room.get(idx), Comparator.comparing(o -> o.nickname));
            for (Info info : room.get(idx)) {
                sb.append(info.level).append(" ").append(info.nickname).append("\n");
            }
        }

        System.out.println(sb);


    }
}
