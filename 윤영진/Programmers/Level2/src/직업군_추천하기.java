import java.util.HashMap;

public class 직업군_추천하기 {
    // 개발자가 사용하는 언어와 언어 선호도를 입력하면 그에 맞는 직업군을 추천
    HashMap<String, Integer> preferMap = new HashMap<>();
    String[] Languages;
    public String solution(String[] table, String[] languages, int[] preference) {
        Languages = languages;
        for (int i = 0; i < preference.length; i++) {
            preferMap.put(languages[i], preference[i]);
        }

        int max = Integer.MIN_VALUE;
        String result = "";

        for (int i = 0; i < table.length; i++) {
            HashMap<String, Integer> tableMap = new HashMap<>();
            String[] tmp = table[i].split(" ");
            int score = 5;
            for (int j = 1; j < tmp.length; j++) {
                tableMap.put(tmp[j], score--);
            }
            int point = getPoint(tableMap);
            if(max < point) {
                max = point;
                result = tmp[0];
            } else if(max == point) {
                result = result.compareTo(tmp[0]) < 1 ? result : tmp[0];
            }
        }
        return result;

    }

    private int getPoint(HashMap<String, Integer> tableMap) {
        int sum = 0;
        for (int i = 0; i < Languages.length; i++) {
            sum += tableMap.getOrDefault(Languages[i], 0) * preferMap.get(Languages[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        직업군_추천하기 sol = new 직업군_추천하기();
        System.out.println(sol.solution(new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#",
                        "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                        "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
                        "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                        "GAME C++ C# JAVASCRIPT C JAVA"},
                new String[]{"PYTHON", "C++", "SQL"}, new int[]{7, 5, 5}));
        System.out.println(sol.solution(new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#",
                        "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                        "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
                        "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                        "GAME C++ C# JAVASCRIPT C JAVA"},
                new String[]{"JAVA", "JAVASCRIPT"}, new int[]{7, 5}));
    }
}
