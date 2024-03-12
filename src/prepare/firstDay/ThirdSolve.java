package prepare.firstDay;

public class ThirdSolve {
    public static void main(String[] args) {
        Solution3 s = new Solution3();

        String word = "I";

        s.solution(word);
    }
}
class Solution3 {

    int answer;
    int index;

    public int solution(String word) {

        dfs(word, "");
        return answer;
    }

    void dfs(String word, String text) {
        if (word.equals(text)) {
            answer = index;
            return;
        }

        index++;

        if (text.length() == 5) {
            return;
        }

        dfs(word, text+"A");
        dfs(word, text+"E");
        dfs(word, text+"I");
        dfs(word, text+"O");
        dfs(word, text+"U");
    }
}