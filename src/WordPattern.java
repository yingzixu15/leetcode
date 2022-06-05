import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> stringCharacterMap = new HashMap<>();
        Map<Character, String> characterStringMap = new HashMap<>();
        String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;
        for (int i = 0; i < words.length; i++) {
            Character c = pattern.charAt(i);
            String word = words[i];
            Character charLookup = stringCharacterMap.getOrDefault(word,null);
            String strLookup = characterStringMap.getOrDefault(c, null);
            if (charLookup == null && strLookup == null) {
                stringCharacterMap.put(word, c);
                characterStringMap.put(c, word);
            } else if (charLookup != null && strLookup != null) {
                if (!(charLookup.equals(c) && strLookup.equals(word)))
                    return false;
            } else return false;
        }
        return true;
//        Map<Character, String> patternMap = new HashMap<>();
//        String[] words = s.split(" ");
//        if (words.length != pattern.length())
//            return false;
//        for (int i = 0; i < words.length; i++) {
//            Character c = pattern.charAt(i);
//            if (patternMap.containsKey(c)) {
//                if (!patternMap.get(c).equals(words[i])) {
//                    return false;
//                }
//            } else {
//                patternMap.put(c, words[i]);
//            }
//        }
//        return true;
    }
}
