package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 플레이페어_암호 {

    // Playfair cipher 는 알파벳으로 이루어진 어떤 문자열을 암호화하는 방법
    // 알파벳으로 이루어진 문자열인 키가 필요하다.

    // Playfair cipher 는 빈도분석을 어렵게 하기 위해 한번에 두 글자 단위로 암호화를 진행
    // 5*5 크기의 표를 사용하기 때문에 알파벳 26개를 모두 담기에는 칸이 한 개 부족해 I와 J를 동일한 것으로 생각한다. -> 편의상 J가 주어지지 않는다.

    // 먼저, 주어진 키를 5*5 크기의 표로 변환
    // 만약 이전에 봤던 알파벳이 한번 더 등장하면 무시하고 다음 글자를 보면 된다.
    // 키를 다 보고도 칸이 남는다면, 아직 등장하지 않은 알파벳을 순서대로 채워넣으면 된다.

    // 암호화하려는 메시지를 두 글자씩 나누는 일
    // HELLOWORLD -> HE LL OW OR LD
    // LL같이 두 글자로 이루어진 쌍이 생기면 중간에 다른 글자를 넣어 쌍을 파괴해줘야 한다.
    // 앞에 있는 쌍 사이에 X를 넣고 뒤쪽은 새롭게 쌍을 구성하면 된다. -> HELXLOWORLD
    // XX의 경우에는 Q로 대체
    // 마지막에 한 글자가 남는다면 X를 덧붙여 강제로 쌍을 맞춰준다.
    // 만약 마지막 한 글자가 X라면 예외적으로 XX

    // HELLOWORLD -> HE LX LO WO RL DX
    // XXYYY -> XX YY YX -> XQXYYY -> XQ XY YY -> XQXYYXY -> XQ XY YX YX
    // XX -> ZZ

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] map;
    static Map<Character, Point> pos = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String message = br.readLine();
        String key = br.readLine();

        // map 생성
        map = makeMap(key);

        // 문자 나누기
        List<String> splitMsg = splitMessage(message);

        // 암호화
        cipher(splitMsg);

    }

    private static void cipher(List<String> splitMsg) {
        StringBuilder sb = new StringBuilder();
        for (String s : splitMsg) {
            char x1 = s.charAt(0);
            char x2 = s.charAt(1);
            Point p1 = pos.get(x1);
            Point p2 = pos.get(x2);

            if (p1.x == p2.x) {
                int m1 = (p1.y + 1) % 5;
                int m2 = (p2.y + 1) % 5;
                sb.append(map[p1.x][m1]).append(map[p2.x][m2]);
            } else if (p1.y == p2.y) {
                // L -> (0, 1) -> (1, 1)
                // O -> (3, 1)
                int m1 = (p1.x + 1) % 5;
                int m2 = (p2.x + 1) % 5;

                sb.append(map[m1][p1.y]).append(map[m2][p2.y]);
            } else {
                // p1 = (0, 1)
                // p2 = (4, 3)

                // (0, 1) -> (0, 3)
                // (4, 3) -> (4, 1)
                sb.append(map[p1.x][p2.y]).append(map[p2.x][p1.y]);
            }


        }
        System.out.println(sb);

    }

    private static List<String> splitMessage(String message) {

        List<String> result = new ArrayList<>();

        int idx = 0;

        while (idx < message.length()) {
            if (idx == message.length() - 1) {
                result.add(message.charAt(idx) + "X");
                break;
            } else if (message.charAt(idx) != message.charAt(idx + 1)) {
                result.add(message.substring(idx, idx + 2));
                idx += 2;
            } else if (message.charAt(idx) == message.charAt(idx + 1)) {
                if (message.charAt(idx) != 'X') {
                    result.add(message.charAt(idx) + "X");
                } else {
                    result.add(message.charAt(idx) + "Q");
                }
                idx++;
            }
        }
        return result;

    }

    private static char[][] makeMap(String key) {

        char[][] result = new char[5][5];

        for (char c : key.toCharArray()) {
            if (pos.getOrDefault(c, null) == null) {
                result[pos.size() / 5][pos.size() % 5] = c;
                pos.put(c, new Point(pos.size() / 5, pos.size() % 5));
            }
        }

        for (int i = 65; i <= 90; i++) {
            if (i == 74) continue;
            if (pos.getOrDefault((char) i, null) == null) {
                result[pos.size() / 5][pos.size() % 5] = (char) i;
                pos.put((char) i, new Point(pos.size() / 5, pos.size() % 5));
            }
        }

        return result;

    }
}
