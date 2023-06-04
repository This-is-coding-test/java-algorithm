public class 신규_아이디_추천 {
    public String solution(String new_id) {
        String answer = "";

        // 1단계
        new_id = new_id.toLowerCase();

        // 2단계
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        // 3단계
        new_id = new_id.replaceAll("\\.{2,}", ".");
        // 4단계
        new_id = new_id.replaceAll("^[.]|[.]$", "");

        // 5단계
        if (new_id.isBlank()) new_id = "a";

        // 6단계
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]$", "");
        }

        // 7단계
        char c = new_id.substring(new_id.length() - 1).charAt(0);
        while (new_id.length() <= 2) {
            new_id += c;
        }

        return new_id;
    }
}
