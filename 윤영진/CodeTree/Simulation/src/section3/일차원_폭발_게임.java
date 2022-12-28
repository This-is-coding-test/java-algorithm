package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일차원_폭발_게임 {
    static int N, M;
    static int[] bombs;
    static int endOfArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (M == 0) {
            System.out.println(0);
            return;
        }
        endOfArray = N;


        bombs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            bombs[i] = Integer.parseInt(br.readLine());
        }

        simulate();

        System.out.println(endOfArray);
        for (int i = 1; i <= endOfArray; i++) {
            System.out.println(bombs[i]);
        }
    }

    private static void simulate() {

        boolean flag = true;
        while (flag) {
            flag = false;

            for(int currIdx = 1; currIdx <= endOfArray; currIdx++) {
                // 각 위치마다 그 뒤로 폭탄이 m개 이상 있는지 확인합니다.

                // 이미 터지기로 예정되어있는 폭탄은 패스합니다.
                if(bombs[currIdx] == 0) {
                    continue;
                }
                // currIdx로부터 연속하여 같은 숫자를 갖는 폭탄 중
                // 가장 마지막 위치를 찾아 반환합니다.
                int endIdx = getEndIdxOfExplosion(currIdx, bombs[currIdx]);

                if(endIdx - currIdx + 1 >=  M) {
                    // 연속한 숫자의 개수가 m개 이상인 경우 폭탄이 터졌음을 기록해줍니다.
                    bomb(currIdx, endIdx);
                    flag = true;
                }


            }
            cutArray();

        }



    }

    public static int getEndIdxOfExplosion(int startIdx, int currNum) {
        int endIdx = startIdx + 1;
        while(endIdx <= endOfArray) {
            if(bombs[endIdx] == currNum)
                endIdx++;
            else{
                break;
            }
        }

        return endIdx - 1;
    }


    private static void cutArray() {
        int endOfTempArray = 1;
        int[] temp = new int[N + 1];
        for (int i = 1; i <= endOfArray; i++) {
            if (bombs[i] != 0) {
                temp[endOfTempArray++] = bombs[i];
            }
        }

        for (int i = 1; i <= endOfArray; i++) {
            bombs[i] = temp[i];
        }

        endOfArray = endOfTempArray - 1;
    }

    private static void bomb(int start, int end) {
        for (int i = start; i <= end; i++) {
            bombs[i] = 0;
        }
    }
}
