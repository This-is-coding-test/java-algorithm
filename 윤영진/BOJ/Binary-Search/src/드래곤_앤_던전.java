import java.util.*;
import java.io.*;

class 드래곤_앤_던전 {

    // HmaxHP : 용사의 최대 생명력 -> 이 값은 1이상이어야 하며 던전에 들어간 이후 변하지 않는다.
    // HcurHP : 현재 용사의 생명력 -> 초기는 HmaxHP, HmaxHP보다 커질 수 없다.
    // Hatk : 용사의 공격력

    // 던전은 총 N개의 방
    // i번째 방을 통해서만 i + 1로 이동가능
    // 방에는 포션이 있거나 몬스터가 있는데 몬스터가 있을 경우 몬스터를 쓰러트려야지 다음방으로 이동 가능
    // N번째 방에는 공주와 용이 있고, 용을 무찌르면 공주를 구할 수 있다.

    // 몬스터가 방에
    // 용사의 공격력만큼 몬스터의 생명력을 깍는다.
    // 몬스터의 생명력이 0이하면 전투 종료 후 다음 방
    // 몬스터의 공격력만큼 용사의 생명력을 깍는다.
    // 용사의 생명력이 0이하면 전투가 종료되고 용사 사망
    // 다시 1부터 진행

    // 포션이 있는 방에 올 경우 현재 용사의 생명력, 공격력도 증가한다.
    // 용사는 수련을 하면 최대 생명력을 늘릴 수 있는데 얼마나 수련해야 할지?
    // 최소 HmaxHP를 계산

    static class Info {

        int t;
        long a, h;

        public Info(int t, long a, long h) {
            this.t = t;
            this.a = a;
            this.h = h;
        }
    }

    static int N, Ha;
    static ArrayList<Info> infoList = new ArrayList<>();
    static long result = 0;
    // t a h
    // t == 1 -> 공격력 a, 생명력 h인 몬스터
    // t == 2 -> 용사 공격력을 a, 생명력을 h


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Ha = Integer.parseInt(st.nextToken());

        long sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long h = Long.parseLong(st.nextToken());
            sum += a * h;
            infoList.add(new Info(t, a, h));
        }

        binarySearch(1, sum);
        System.out.println(result);

    }

    private static void binarySearch(long left, long right) {

        while (left <= right) {
            long mid = (left + right) / 2;
            if (simulate(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

    }

    private static boolean simulate(long mid) {
        long currH = mid;
        long currA = Ha;
        // 150

        for (int i = 0; i < infoList.size(); i++) {
            Info info = infoList.get(i);
            if (info.t == 1) {
                long cnt = info.h / currA;
                if (info.h % currA == 0) cnt--;
                currH -= cnt * info.a;
                if (currH <= 0) return false;
            } else {
                currA += info.a;
                currH = Math.min(mid, currH + info.h);
            }

        }

        return true;

    }


}