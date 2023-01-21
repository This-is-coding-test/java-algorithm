import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class 불량_사용자 {
    // 개발팀 내에서 이벤트 개발을 담당하고 있는 무지는 최근 진행된 카카오이모티콘 이벤트에 비정상적인 방법으로 당첨을 시도한 응모자들을 발견
    // 이런 응모자들을 따로 모아 불량 사용자라는 이름으로 목록을 만들어서 당첨 처리 시 제외하도록 이벤트 담청자 담당자에게 전달
    // 개인정보 보호를 위해 사용자 아이디 중 일부 문자를 *문자로 가려서 전달
    // 가리고자 하는 문자 하나에 *문자 하나를 사용하였고 아이디 당 최소 하나 이상의 *문자를 사용

    // 불량 사용자 목록에 매핑된 응모자 아이디를 '제재 아이디'라고 부른다.

    static int n, m;
    static String[] userIds;
    static String[] bannedIds;
    static HashSet<HashSet<String>> result = new HashSet<>();

    public  int solution(String[] user_id, String[] banned_id) {
        n = banned_id.length;
        m = user_id.length;
        userIds = user_id;
        bannedIds = banned_id;

        findBannedUser(0, new HashSet<>());

        return result.size();

    }


    private  void findBannedUser(int depth, HashSet<String> set) {
        if (depth == n) {
            result.add(set);
        } else {
            for (int i = 0; i < m; i++) {
                if (set.contains(userIds[i])) {
                    continue;
                }
                if (isMatching(userIds[i], bannedIds[depth])) {
                    set.add(userIds[i]);
                    findBannedUser(depth + 1, new HashSet<>(set));
                    set.remove(userIds[i]);
                }
            }
        }
    }

     boolean isMatching(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }

        boolean match = true;
        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) {
                match = false;
                break;
            }
        }

        return match;
    }
}
