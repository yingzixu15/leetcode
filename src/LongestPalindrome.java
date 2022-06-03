import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Boolean> frequencyMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (frequencyMap.containsKey(c)) {
                frequencyMap.put(c, !frequencyMap.get(c));
            } else {
                frequencyMap.put(c, false);
            }
        }
        int oddCount = frequencyMap.entrySet().stream().filter(p -> !p.getValue()).collect(Collectors.toList()).size();
        if (oddCount == 0)
            return s.length();
        else return s.length() - oddCount + 1;
    }
}
