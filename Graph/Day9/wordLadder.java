import java.util.*;

public class wordLadder {
    static class Pair {
        String str;
        int steps;

        Pair(String str, int steps) {
            this.str = str;
            this.steps = steps;
        }
    }

    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
                "des",
                "der",
                "dfr",
                "dgt",
                "dfs"
        };

        int ans = wordLadderLength(startWord, targetWord, wordList);
        System.out.print(ans);
    }

    private static int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1));

        Set<String> st = new HashSet<>();
        int length = wordList.length;
        for (int i = 0; i < length; i++) {
            st.add(wordList[i]);
        }
        st.remove(startWord);

        while (!q.isEmpty()) {
            String word = q.peek().str;
            int steps = q.peek().steps;
            q.remove();

            if (word.equals(targetWord))
                return steps;

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] charArray = word.toCharArray();
                    charArray[i] = ch;
                    String finalCharArray = new String(charArray);

                    if (st.contains(finalCharArray)) {
                        st.remove(finalCharArray);
                        q.add(new Pair(finalCharArray, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}

// ArrayList<String> or List<String>

/*
 * public int ladderLength(String beginWord, String endWord, List<String>
 * wordList) {
 * Queue<Pair> q = new LinkedList<>();
 * q.add(new Pair(beginWord, 1));
 * 
 * Set<String> st = new HashSet<>(wordList);
 * st.remove(beginWord);
 * 
 * while(!q.isEmpty()){
 * String word = q.peek().fir;
 * int steps = q.peek().sec;
 * q.remove();
 * 
 * if (word.equals(endWord) == true) return steps;
 * 
 * for(int i = 0; i < word.length(); i++){
 * for (char ch = 'a'; ch <= 'z'; ch++){
 * char replacedCharArray[] = word.toCharArray();
 * replacedCharArray[i] = ch;
 * String replacedWord = new String(replacedCharArray);
 * 
 * if (st.contains(replacedWord) == true) {
 * st.remove(replacedWord);
 * q.add(new Pair(replacedWord, steps + 1));
 * }
 * }
 * }
 * }
 * return 0;
 * }
 * 
 */